package SpringBoot.HRMS.Dao;

import SpringBoot.HRMS.Entity.LoginEntity;

import SpringBoot.HRMS.Repo.LoginRepo;

import SpringBoot.HRMS.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class LoginDao {
    @Autowired
    LoginRepo loginRepo;

    public String validation(String userName, String password) {
        List<LoginEntity> loginEntityList = loginRepo.findAll();
        for (LoginEntity loginEntity : loginEntityList) {
            if (loginEntity.getUserName().equals(userName) && loginEntity.getPassword().equals(password) )
            {
                Token token = new Token();
                String tokens = token.generateToken();
                return tokens;
            }else {
                return "failure";
            }
        }
        return null;
    }


}

