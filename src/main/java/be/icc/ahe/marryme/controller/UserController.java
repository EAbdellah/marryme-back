package be.icc.ahe.marryme.controller;


import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.dataaccess.entity.VerificationTokenEntity;
import be.icc.ahe.marryme.event.OnRegistrationCompleteEvent;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.UsernameExistException;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import be.icc.ahe.marryme.model.mapper.PersonMapper;
import be.icc.ahe.marryme.model.mapper.dtomapper.RegistrationUserMapper;
import be.icc.ahe.marryme.security.domain.UserPrincipal;
import be.icc.ahe.marryme.security.utility.JWTTokenProvider;
import be.icc.ahe.marryme.service.PersonService;
import be.icc.ahe.marryme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.mail.MessagingException;
import java.time.Period;
import java.util.Calendar;
import java.util.Locale;

import static be.icc.ahe.marryme.constant.SecurityConstant.JWT_TOKEN_HEADER;
import static be.icc.ahe.marryme.constant.UserImplConstant.VERIFIACTION_TOKEN_EXPIRED;
import static org.springframework.http.HttpStatus.OK;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final PersonService personService;
    private AuthenticationManager authenticationManager;
    private JWTTokenProvider jwtTokenProvider;
    private ApplicationEventPublisher eventPublisher;


    @Autowired
    public UserController(UserService userService, PersonService personService, AuthenticationManager authenticationManager, JWTTokenProvider jwtTokenProvider, ApplicationEventPublisher eventPublisher) {
        this.userService = userService;
        this.personService= personService;
        this.authenticationManager=authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.eventPublisher = eventPublisher;

    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserRegistrationFormDTO> register(@RequestBody UserRegistrationFormDTO userForm,WebRequest request) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException {

        Person person = personService.register(userForm);

        String appUrl = request.getContextPath();
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(person,
                request.getLocale(), appUrl));

        return ResponseEntity.ok(userForm);
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        authenticate(user.getEmail(), user.getPassword());
        User loginUser = userService.findUserByEmail(user.getEmail());
        UserPrincipal userPrincipal = new UserPrincipal(loginUser);
        HttpHeaders jwtHeader = getJwtHeader(userPrincipal);
        return new ResponseEntity<>(loginUser, jwtHeader, OK);
    }

    @GetMapping("/regitrationConfirm")
    public String confirmRegistration
            (WebRequest request, Model model, @RequestParam("token") String token) throws Exception {

        Locale locale = request.getLocale();

        VerificationTokenEntity verificationToken = userService.getVerificationToken(token);

        if (verificationToken == null) {
//            String message = messages.getMessage("auth.message.invalidToken", null, locale);
//            model.addAttribute("message", message);
//            return "redirect:/badUser.html?lang=" + locale.getLanguage();
            throw new EmailExistException(VERIFIACTION_TOKEN_EXPIRED);
        }

        UserEntity user = verificationToken.getUser();

        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 15) {

//            String messageValue = messages.getMessage("auth.message.expired", null, locale);
//            model.addAttribute("message", messageValue);
//            return "redirect:/badUser.html?lang=" + locale.getLanguage();
            throw new EmailExistException(VERIFIACTION_TOKEN_EXPIRED);
//            return ResponseEntity.("Hello");

        }

        user.setActive(true);
        userService.save(user);
        return "redirect:/login.html?lang=" + request.getLocale().getLanguage();
    }



    private HttpHeaders getJwtHeader(UserPrincipal user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(user));
        return headers;
    }

    @GetMapping(value = "/hello")
    public ResponseEntity Hello(@RequestBody UserRegistrationFormDTO userForm) throws Exception {
        return ResponseEntity.ok("Hello");
    }


    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }



}
