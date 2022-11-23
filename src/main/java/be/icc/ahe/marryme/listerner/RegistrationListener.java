package be.icc.ahe.marryme.listerner;

import be.icc.ahe.marryme.event.OnRegistrationCompleteEvent;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.service.EmailService;
import be.icc.ahe.marryme.service.UserService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.UUID;

@Component
public class RegistrationListener implements
        ApplicationListener<OnRegistrationCompleteEvent> {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @SneakyThrows
    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnRegistrationCompleteEvent event) throws MessagingException {
        Person person = event.getPerson();
        String token = UUID.randomUUID().toString();
        userService.createVerificationToken(person.getUser(), token);

        String email = person.getUser().getEmail();
        String firstName = person.getFirstName();
        String confirmationUrl  = /*.getAppUrl() +*/ "http://localhost:8080/api/user/regitrationConfirm?token=" + token;

        LOGGER.info(confirmationUrl);

        emailService.sendLinkToConfirmRegistration(firstName, email,confirmationUrl,event);

    }
}
