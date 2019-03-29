package com.mkyong.controller.login;

import com.mkyong.models.sec.Role;
import com.mkyong.models.sec.SecUser;
import com.mkyong.repositories.sec.RoleRepository;
import com.mkyong.services.sec.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By: Ron Rith
 * Create Date on: 3/29/2019.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        List<Role> roles = (List<Role>) roleRepository.findAll();
        List<SecUser> secUsers = userService.findAllUsers();

        if (roles == null || roles.size() <= 0) {
            Role role = new Role();
            role.setRole("ADMIN");
            roleRepository.save(role);
        }

        if (secUsers == null || secUsers.size() < 3) {
            isSaveDefaultUser();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    private boolean isSaveDefaultUser() {
        List<SecUser> secUsersDefaul = getDefaultUser();
        for (SecUser secUser : secUsersDefaul) {
            userService.saveUser(secUser);
        }
        return true;
    }

    private List<SecUser> getDefaultUser(){
        List<SecUser> secUsers = new ArrayList<>();
        SecUser secUser = new SecUser();
        SecUser secUserUser = new SecUser();
        SecUser secUserAdmin = new SecUser();

        secUser.setName("Rith");
        secUser.setLastName("Ron");
        secUser.setEmail("rithronlkh@gmail.com");
        secUser.setActive(1);
        secUser.setPassword("123456");

        secUserUser.setName("User");
        secUserUser.setLastName("User");
        secUserUser.setEmail("user@gmail.com");
        secUserUser.setActive(1);
        secUserUser.setPassword("123456");

        secUserAdmin.setName("Admin");
        secUserAdmin.setLastName("Admin");
        secUserAdmin.setEmail("admin@gmail.com");
        secUserAdmin.setActive(1);
        secUserAdmin.setPassword("123456");

        secUsers.add(secUser);
        secUsers.add(secUserUser);
        secUsers.add(secUserAdmin);

        return secUsers;
    }

}
