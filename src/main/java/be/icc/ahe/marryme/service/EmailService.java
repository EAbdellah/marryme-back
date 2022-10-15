package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.event.OnRegistrationCompleteEvent;

import javax.mail.MessagingException;

public interface EmailService {
    void sendLinkToConfirmRegistration(String firstName, String email, String link, OnRegistrationCompleteEvent event) throws MessagingException;
}
