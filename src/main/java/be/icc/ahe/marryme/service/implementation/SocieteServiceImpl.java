package be.icc.ahe.marryme.service.implementation;

import be.icc.ahe.marryme.dataaccess.dao.SocieteDAO;
import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.exception.EmailExistException;
import be.icc.ahe.marryme.exception.UserNotFoundException;
import be.icc.ahe.marryme.exception.UsernameExistException;
import be.icc.ahe.marryme.exception.sqlexception.AddressDatabaseException;
import be.icc.ahe.marryme.exception.sqlexception.SocieteDatabaseException;
import be.icc.ahe.marryme.model.*;
import be.icc.ahe.marryme.model.dto.ProviderRegisterFormDTO;
import be.icc.ahe.marryme.model.dto.ProviderRequestRegistrationDTO;
import be.icc.ahe.marryme.model.mapper.AddressMapper;
import be.icc.ahe.marryme.model.mapper.SocieteMapper;
import be.icc.ahe.marryme.model.mapper.dtomapper.CycleAvoidingMappingContext;
import be.icc.ahe.marryme.service.AddressService;
import be.icc.ahe.marryme.service.PersonService;
import be.icc.ahe.marryme.service.ServicesService;
import be.icc.ahe.marryme.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

@Service
public class SocieteServiceImpl implements SocieteService {

    private final SocieteDAO societeDAO;
    private final PersonService personService;
    private final ServicesService servicesService;
    private final AddressService addressService;


    @Autowired
    public SocieteServiceImpl(SocieteDAO societeDAO, PersonService personService,ServicesService servicesService,AddressService addressService) {
        this.societeDAO = societeDAO;
        this.personService = personService;
        this.servicesService = servicesService;
        this.addressService = addressService;

    }


    @Override
    public Societe save(Societe societe) throws SocieteDatabaseException {

        Optional.ofNullable(societe)
                .orElseThrow(() -> new SocieteDatabaseException("Can not save null societe: " + societe));

        SocieteEntity persistedSocieteEntity= societeDAO.save(SocieteMapper.INSTANCE.modelToEntity(societe, new CycleAvoidingMappingContext()));

        Optional.ofNullable(persistedSocieteEntity)
                .orElseThrow(() -> new SocieteDatabaseException("Persisted societe is null: " + persistedSocieteEntity));

        return SocieteMapper.INSTANCE.entityToModel(persistedSocieteEntity, new CycleAvoidingMappingContext());

    }

    @Override
    public Societe findByID(Long id) throws SocieteDatabaseException {

        SocieteEntity societeEntity= this.societeDAO.findByID(id)
                .orElseThrow(() -> new SocieteDatabaseException("None societe found at id:" + id));

        return SocieteMapper.INSTANCE.entityToModel(societeEntity, new CycleAvoidingMappingContext());

    }

    @Override
    public Societe update(Societe societe) throws SocieteDatabaseException {

        Optional.ofNullable(societe)
                .orElseThrow(() -> new SocieteDatabaseException("Can not persist null societe: " + societe));

        if (!societeDAO.existsById(societe.getSocieteID())) {
            throw new SocieteDatabaseException("Try to update into data base a societe that does not exist: " + societe);
        }

        SocieteEntity societeEntity= societeDAO.save(SocieteMapper.INSTANCE.modelToEntity(societe, new CycleAvoidingMappingContext()));


        Optional.ofNullable(societeEntity)
                .orElseThrow(() -> new SocieteDatabaseException("Persisted societe is null: " + societeEntity));

        return SocieteMapper.INSTANCE.entityToModel(societeEntity, new CycleAvoidingMappingContext());
    }

    @Override
    public void deleteById(Long id) throws SocieteDatabaseException {
        if (societeDAO.existsById(id)) {
            societeDAO.deleteById(id);
        } else {
            throw new SocieteDatabaseException("None societe found at id: " + id);
        }
        if (societeDAO.existsById(id)) {
            throw new SocieteDatabaseException("Failed to delete societe into database at id: " + id);
        }
    }

    @Override
    public Societe Register(ProviderRegisterFormDTO providerForm) throws SocieteDatabaseException, UserNotFoundException, UsernameExistException, EmailExistException, MessagingException, AddressDatabaseException {

        Address address = AddressMapper.INSTANCE.RegistrationProviderDtoToModel(providerForm);

        /// TODO: 17/11/2022 RUSTINE DEGEULASSE !!! il faudra ajouter au front un formulaire pour recupere l'adresse
        Address address2 = AddressMapper.INSTANCE.RegistrationProviderDtoToModel(providerForm);
        address2 = addressService.save(address2);
        be.icc.ahe.marryme.model.Service service = (be.icc.ahe.marryme.model.Service) servicesService.getTypeOfService(providerForm.getServiceType());

        service.setAddress(address2);
        service.setNom(providerForm.getName());
        Societe societe = SocieteMapper.INSTANCE.RegistrationProviderDtoToModel(providerForm);
        societe.setService(service);
        Person person = personService.registerProvider(providerForm);
        societe.setLocalisation(address);
        societe.setOwner(person);
        societe.setDecisionRegistration("WAITING");
        societe = this.save(societe);

//        this.update(societe);
        return societe;
    }

    @Override
     public List<ProviderRequestRegistrationDTO> getAllRequestProvider(){
        return societeDAO.getAllProviderRequestRegistration();
     }

    public Societe findUserByEmail(String email) throws SocieteDatabaseException {

        SocieteEntity societeEntity =  societeDAO.findByEmail(email)
                .orElseThrow(() -> new SocieteDatabaseException("None societe found for email:" + email));;

        return SocieteMapper.INSTANCE.entityToModel(societeEntity, new CycleAvoidingMappingContext());


    }


}
