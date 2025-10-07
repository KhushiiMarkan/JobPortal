package Service;

import java.util.List;
import Model.User;
import Repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    UserService(UserRepo userRepo,  PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder=passwordEncoder;
    }

    //REGISTER
    public User registerUser(User u){
        if (userRepo.existsByEmail(u.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }
//        if(userRepo.existsById((u.getUserid()))){
//            throw new IllegalArgumentException("User already registered");
//        }
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return userRepo.save(u);
    }

    //LOGIN
    public User loginUser(String email, String password) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        return user;
    }


    //UPDATE
    public User updateUser(User u) {
        if (userRepo.existsByEmail(u.getEmail())) {
            return userRepo.save(u);
        }
        return null;
    }

    //DELETE
    public void deleteUserById(String id) {
        if(!userRepo.existsById(id)){
            throw new IllegalArgumentException("User not found");
        }
        userRepo.deleteById(id);
    }

    public void deleteUserByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        userRepo.delete(user);
    }


    public User getUser(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public boolean passwordMatches(User u, String raw) {
        return u != null && passwordEncoder.matches(raw, u.getPassword());
    }

    public String encodePassword(String raw) {
        return passwordEncoder.encode(raw);
    }



}
