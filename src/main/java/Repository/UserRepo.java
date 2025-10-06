package Repository;


import java.util.List;
import java.util.Optional;
import Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
    Optional<User> findUserById(String id);
    Optional<User> findByEmail(String email) ;
    boolean existsByEmail(String email);
    boolean existsById(String id);
    List<User> findAll() ;

//    Optional<User> findById(String id) ;
}
