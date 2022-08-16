package be.icc.ahe.marryme.controller;

import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import be.icc.ahe.marryme.model.mapper.UserMapper;
import be.icc.ahe.marryme.model.mapper.dtomapper.RegistrationUserMapper;
import be.icc.ahe.marryme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Controller
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody UserRegistrationFormDTO userForm, WebRequest request) throws Exception {

        System.out.println(userForm);
        User user = RegistrationUserMapper.INSTANCE.dtotomodel(userForm);

        System.out.println(user);
        UserEntity userEntity = UserMapper.INSTANCE.modelToEntity(user);
        System.out.println(userEntity);

        userService.save(userEntity);


        System.out.println(user);
        return ResponseEntity.ok(user);

//        QuizzUser user = new QuizzUser();
//        user.setFirstName(userForm.getFirstName());
//        user.setLastName(userForm.getLastName());
//        user.setGender(userForm.getGender());
//
//        user.setEmail(userForm.getEmail());
//        user.setUsername(userForm.getUsername());
//        user.setPassword(userForm.getPassword());
//        user.setAuthority(userForm.getAuthority());
//        user.setCredentialsNonExpired(true);
//        user.setEnabled(false);
//        user.setAccountNonExpired(true);
//        user.setAccountNonLocked(true);
//        Date date = Objects.isNull(userForm.getBirthday()) ? Date.valueOf(LocalDate.now())
//                : Date.valueOf(userForm.getBirthday());
//        user.setBirthday(date);
//        user.setEnterprise(new Enterprise(userForm.getEnterpriseId()));
//
//        try {
//            user = userService.save(user);
//            String appUrl = request.getContextPath();
//            eventPublisher.publishEvent(new OnRegistrationSuccessEvent(quizzUserConverter.toFinalEntity(user),
//                    request.getLocale(), appUrl));
//
//        } catch (UserDatabaseException p) {
//            return ResponseEntity
//                    .status(HttpStatus.FORBIDDEN)
//                    .body(p.getMessage());
//        }
//        return ResponseEntity.ok(user);
    }
}
