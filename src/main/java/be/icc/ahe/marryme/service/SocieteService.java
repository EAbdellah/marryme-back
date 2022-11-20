package be.icc.ahe.marryme.service;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.UsernameExistException;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.ReservationDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.SocieteDatabaseException;
import be.icc.ahe.marryme.model.Societe;
import be.icc.ahe.marryme.model.dto.ProviderRegisterFormDTO;
import be.icc.ahe.marryme.model.dto.ProviderRequestRegistrationDTO;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public interface SocieteService {
    Societe save(Societe societe) throws SocieteDatabaseException;
    Societe findByID(Long id) throws SocieteDatabaseException;
    Societe update(Societe societe) throws SocieteDatabaseException;
    void deleteById(Long id) throws SocieteDatabaseException;
    Societe Register(ProviderRegisterFormDTO providerRegisterFormDTO) throws SocieteDatabaseException, UserNotFoundException, UsernameExistException, EmailExistException, MessagingException, AddressDatabaseException;
    List<ProviderRequestRegistrationDTO> getAllRequestProvider();
    Societe findUserByEmail(String email) throws SocieteDatabaseException;
}
