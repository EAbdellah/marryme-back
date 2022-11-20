package be.icc.ahe.marryme.listerner;

import be.icc.ahe.marryme.event.OnProviderRegistration;
import be.icc.ahe.marryme.event.OnRegistrationCompleteEvent;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.Societe;
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
public class ProviderRegistrationListener implements
        ApplicationListener<OnProviderRegistration> {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());


    @Autowired
    private EmailService emailService;

    @SneakyThrows
    @Override
    public void onApplicationEvent(OnProviderRegistration event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnProviderRegistration event) throws MessagingException {
        Societe societe = event.getSociete();

        String email = societe.getEmail();
        String ntva = societe.getNTVA();
        Long nEntreprise = societe.getNEntreprise();
        String nom = societe.getNom();
        String ceoFirstName = societe.getOwner().getFirstName();
        String ceoLastName= societe.getOwner().getLastName();
        emailService.notifyNewProviderInscription(nom, email, nEntreprise, ntva,ceoFirstName,ceoLastName);

    }
}
