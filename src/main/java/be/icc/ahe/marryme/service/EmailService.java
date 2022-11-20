package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.event.OnRegistrationCompleteEvent;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
@Service
public interface EmailService {
    void sendLinkToConfirmRegistration(String firstName, String email, String link, OnRegistrationCompleteEvent event) throws MessagingException;
    void notifyNewProviderInscription(String nom, String email, Long nEntreprise , String ntva,  String ceoFirstName,String ceoLastName) throws MessagingException;
    void sendDecisionProviderRegistration(boolean accepted, String email, String nom ) throws MessagingException;
    void sendDecisionUserRegistration(boolean accepted, String email, String prenom, String formuleName ) throws MessagingException;

}
