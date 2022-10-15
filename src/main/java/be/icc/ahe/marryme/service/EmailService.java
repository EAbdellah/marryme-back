package be.icc.ahe.marryme.service;

import javax.mail.MessagingException;

public interface EmailService {
    void sendLinkToActivateAccount(String firstName, String email) throws MessagingException;
}
