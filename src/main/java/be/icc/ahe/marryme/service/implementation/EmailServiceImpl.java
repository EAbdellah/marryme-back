package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.event.OnRegistrationCompleteEvent;
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


}
