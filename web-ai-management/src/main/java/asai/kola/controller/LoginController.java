package asai.kola.controller;

import asai.kola.pojo.Emp;
import asai.kola.pojo.LoginInfo;
import asai.kola.pojo.Result;
import asai.kola.service.EmpService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("登录操作：{}", emp);
        LoginInfo loginRequest = empService.login(emp);
        if (loginRequest != null) {
            return Result.success(loginRequest);
        }
        return Result.error("用户名或密码错误");
    }
}
