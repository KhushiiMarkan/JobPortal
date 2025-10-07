package Repository;

import Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface JobRepo extends JpaRepository<Job,String> {
    Optional<Job> findById(Integer id);
    Optional<Job> findByCompanyName(String companyName);
    List<Job> findByJobRole(String jobRole);
    List<Job> findByLocation(String location);
    List<Job> findByPostedDate(LocalDate date);


}
