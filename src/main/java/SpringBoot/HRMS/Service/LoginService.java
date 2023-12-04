package SpringBoot.HRMS.Service;

import SpringBoot.HRMS.Dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginDao loginDao;

    public String validation (String userName, String password) {
        String status = loginDao.validation(userName , password);
        return status;
    }

}
