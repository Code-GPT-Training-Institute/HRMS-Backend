package SpringBoot.HRMS.Repo;

import SpringBoot.HRMS.Entity.LoginEntity;
import SpringBoot.HRMS.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LoginRepo extends JpaRepository<LoginEntity ,Long> {
     //List<LoginEntity> findByUsernameAndPassword(String userName, String password);



}
