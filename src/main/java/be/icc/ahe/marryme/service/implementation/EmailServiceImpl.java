package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final JavaMailSender emailSender;
    private final Environment environment;



    @Override
    public void sendLinkToActivateAccount(String firstName, String email) throws MessagingException {
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        String carbonCopyEmail = environment.getProperty("spring.mail.username");
        LOGGER.debug("Carbon Copy Email: {}", carbonCopyEmail);
        message.setCc(carbonCopyEmail);
        message.setSubject(EMAIL_SUBJECT);
        String link = "null";
        message.setText("Hello " + firstName + "!\n\nClick on the link for activate your account" + link + "\n\nThe Support Team");

        // Send Message!
        this.emailSender.send(message);}
}
