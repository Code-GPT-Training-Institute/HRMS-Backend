package SpringBoot.HRMS.Controller;


import SpringBoot.HRMS.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/login")

public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/{userName}/{password}")
    public ResponseEntity<String> valid(@PathVariable String userName, @PathVariable String password ){
        String status = loginService.validation(userName,password);
        return new ResponseEntity<String>(status, HttpStatus.OK );
    }

}
