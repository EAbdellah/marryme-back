package be.icc.ahe.marryme.controller;


import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import be.icc.ahe.marryme.model.mapper.PersonMapper;
import be.icc.ahe.marryme.model.mapper.dtomapper.RegistrationUserMapper;
import be.icc.ahe.marryme.service.PersonService;
import be.icc.ahe.marryme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.Period;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final PersonService personService;


    @Autowired
    public UserController(UserService userService, PersonService personService) {
        this.userService = userService;
        this.personService= personService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody UserRegistrationFormDTO userForm, WebRequest request) throws Exception {

        System.out.println(userForm);
        Person person = RegistrationUserMapper.INSTANCE.dtotomodel(userForm);
        System.out.println(person);

        PersonEntity personEntity =  PersonMapper.INSTANCE.modelToEntity(person);
        personService.save(personEntity);

        return ResponseEntity.ok(userForm);
    }



}
