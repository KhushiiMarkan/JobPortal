package Controller;

import Model.User;
import Service.JobService;
import Service.UserService;
import Service. JobService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")

public class UserController {
    private final UserService userService;
    private final JobService jobService;

    UserController(UserService userService, JobService jobService) {
        this.userService = userService;
        this.jobService = jobService;
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register(User u) {
        try {
            return ResponseEntity.ok(userService.registerUser(u));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(User u) {
        try {
            // Validate credentials using your service
            User loggedInUser = userService.loginUser(u.getEmail(), u.getPassword());

            // If successful, return user data
            return ResponseEntity.ok(loggedInUser);
        } catch (IllegalArgumentException ex) {
            // If login fails (invalid credentials)
            return ResponseEntity.status(401).body(ex.getMessage());
        }
    }

}
