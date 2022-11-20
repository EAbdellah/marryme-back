package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.event.OnRegistrationCompleteEvent;
import be.icc.ahe.marryme.model.Societe;
import be.icc.ahe.marryme.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

import static be.icc.ahe.marryme.constant.EmailConstant.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private final JavaMailSender emailSender;
    @Autowired
    private final Environment environment;

    @Qualifier("messageSource")
    @Autowired
    private MessageSource messages;



    @Override
    public void sendLinkToConfirmRegistration(String firstName, String email, String link, OnRegistrationCompleteEvent event) throws MessagingException {
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        String carbonCopyEmail = environment.getProperty("spring.mail.username");
//        String messageContent = messages.getMessage("Hello " + firstName + EMAIL_CONFIRMATION_MESSAGE, null, event.getLocale());

        LOGGER.debug("Carbon Copy Email: {}", carbonCopyEmail);


        message.setTo(email);
        message.setCc(carbonCopyEmail);
        message.setSubject(EMAIL_SUBJECT);
        message.setText("Hello " + firstName + EMAIL_CONFIRMATION_MESSAGE + "\r\n" + link + "\r\nThe Support Team");

        // Send Message!
        this.emailSender.send(message);}

    @Override
    public void notifyNewProviderInscription(String nom, String email, Long nEntreprise , String ntva,String ceoFirstName,String ceoLastName) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();

        String carbonCopyEmail = environment.getProperty("spring.mail.username");

        LOGGER.info("Carbon Copy Email: {}", carbonCopyEmail);

        message.setTo(email);
        message.setCc(carbonCopyEmail);
        message.setSubject("Verification Provider");
        message.setText(
                "Hello " + nom +","+
                "\r\n" +
                " Merci de vous etre inscrit Sur MarryMe ! Vous receverez une notification aprés verification de vos données" +
                "\r\n" +
                "Dirigeant: "+ ceoLastName +" "+ceoFirstName +
                "\r\n"+
                "Nom de l'entreprise : " +nom+
                "\r\n"+
                "Numero de TVA : " + ntva+
                "\r\n"+
                "Numero de d'entreprise : " + nEntreprise+
                "\r\n"+
                "\r\n"+
                "Marryme Support Team");

        // Send Message!
        this.emailSender.send(message);}


    public void sendDecisionProviderRegistration(boolean accepted, String email, String nom ) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();

        String carbonCopyEmail = environment.getProperty("spring.mail.username");

        LOGGER.info("Carbon Copy Email: {}", carbonCopyEmail);

        String subject=accepted?"Inscription à MarryMe acceptée":"Inscription à MarryMe refusée";
        String body=accepted?"Nous avons le plaisir de valider votre incription!":"Nous ne pouvons malheuresement pas valider votre inscription,"+ "\r\n" +" veuillez prendre contact avec notre administration pour plus ample informations";

        message.setTo(email);
        message.setCc(carbonCopyEmail);
        message.setSubject(subject);
        message.setText(
                         nom +","+
                        "\r\n" +
                         body  +
                        "\r\n"+
                        "\r\n"+
                        "Marryme Support Team");

        // Send Message!
        this.emailSender.send(message);}


    public void sendDecisionUserRegistration(boolean accepted, String email, String prenom, String formuleName )throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();

        String carbonCopyEmail = environment.getProperty("spring.mail.username");

        LOGGER.info("Carbon Copy Email: {}", carbonCopyEmail);


        String subject=accepted?"Votre demande de reservation à été acceptée":"Votre demande de reservation à été refusée";
        String body=accepted?"Felicitation votre reservation à la formule "+formuleName+" a été acceptée!"+ "\r\n" +"Aller sur le site pour payer votre reservation"
                :"Votre demande de reservation pour a formule "+formuleName+" à malheureusement été refusée,"+ "\r\n" +" Nous vous poussons a chercher un autre prestataire sur notre site";

//        message.setTo(email);
        message.setTo("tamere@gmail.com");
        message.setCc(carbonCopyEmail);
        message.setSubject(subject);
        message.setText(
                prenom +","+
                        "\r\n" +
                        body  +
                        "\r\n"+
                        "\r\n"+
                        "Marryme Support Team");

        // Send Message!
        this.emailSender.send(message);

    };


}
