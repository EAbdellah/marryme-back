package be.icc.ahe.marryme.controller;

import be.icc.ahe.marryme.event.OnProviderRegistration;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.UsernameExistException;
import be.icc.ahe.marryme.exception.sqlexception.SocieteDatabaseException;
import be.icc.ahe.marryme.model.Societe;
import be.icc.ahe.marryme.model.dto.DecisionRequestRegistrationProvider;
import be.icc.ahe.marryme.model.dto.ProviderRegisterFormDTO;
import be.icc.ahe.marryme.model.dto.ProviderRequestRegistrationDTO;
import be.icc.ahe.marryme.model.dto.UserRegistrationFormDTO;
import be.icc.ahe.marryme.service.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.mail.MessagingException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final SocieteService societeService;
    private EmailService emailService;


    @Autowired
    public AdminController(SocieteService societeService,EmailService emailService) {
        this.societeService=societeService;
        this.emailService=emailService;

    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<ProviderRequestRegistrationDTO>> register(WebRequest request){
        List<ProviderRequestRegistrationDTO> list = societeService.getAllRequestProvider();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @SneakyThrows
    @PostMapping(value = "/decision")
    public ResponseEntity<DecisionRequestRegistrationProvider> decision(@RequestBody DecisionRequestRegistrationProvider drrp) throws MessagingException {
        emailService.sendDecisionProviderRegistration(drrp.isAccepted(),drrp.getEmail(),drrp.getNom());
        Societe societe= societeService.findUserByEmail(drrp.getEmail());
        if (drrp.isAccepted()){
            societe.setDecisionRegistration("ACCEPTED");
            societe.getOwner().getUser().setActive(true);
        }else {
            societe.setDecisionRegistration("REFUSED");
        }

        societeService.update(societe);

        return new ResponseEntity<>(drrp, HttpStatus.OK);
    }

}
