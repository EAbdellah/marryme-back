package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.AddressEntity;
import be.icc.ahe.marryme.dataaccess.entity.PersonEntity;
import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Person;
import be.icc.ahe.marryme.model.Societe;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-03T17:16:26+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class SocieteMapperImpl implements SocieteMapper {

    @Override
    public SocieteEntity entityToModel(Societe societe) {
        if ( societe == null ) {
            return null;
        }

        SocieteEntity societeEntity = new SocieteEntity();

        societeEntity.setSocieteID( societe.getSocieteID() );
        societeEntity.setNTVA( societe.getNTVA() );
        societeEntity.setNEntreprise( societe.getNEntreprise() );
        societeEntity.setNom( societe.getNom() );
        societeEntity.setEmail( societe.getEmail() );
        societeEntity.setNTel( societe.getNTel() );
        societeEntity.setLocalisation( addressToAddressEntity( societe.getLocalisation() ) );
        societeEntity.setOwner( personToPersonEntity( societe.getOwner() ) );

        return societeEntity;
    }

    @Override
    public Societe modelToEntity(SocieteEntity societeEntity) {
        if ( societeEntity == null ) {
            return null;
        }

        Societe societe = new Societe();

        societe.setSocieteID( societeEntity.getSocieteID() );
        societe.setNTVA( societeEntity.getNTVA() );
        societe.setNEntreprise( societeEntity.getNEntreprise() );
        societe.setNom( societeEntity.getNom() );
        societe.setEmail( societeEntity.getEmail() );
        societe.setNTel( societeEntity.getNTel() );
        societe.setLocalisation( addressEntityToAddress( societeEntity.getLocalisation() ) );
        societe.setOwner( personEntityToPerson( societeEntity.getOwner() ) );

        return societe;
    }

    protected AddressEntity addressToAddressEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setAdressID( address.getAdressID() );
        addressEntity.setPays( address.getPays() );
        addressEntity.setVille( address.getVille() );
        addressEntity.setCodePostal( address.getCodePostal() );
        addressEntity.setRue( address.getRue() );
        addressEntity.setNumero( address.getNumero() );
        addressEntity.setBox( address.getBox() );

        return addressEntity;
    }

    protected PersonEntity personToPersonEntity(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setPersonID( person.getPersonID() );
        personEntity.setNom( person.getNom() );
        personEntity.setPrenom( person.getPrenom() );
        personEntity.setEmail( person.getEmail() );
        personEntity.setNTel( person.getNTel() );
        personEntity.setLocalisation( addressToAddressEntity( person.getLocalisation() ) );

        return personEntity;
    }

    protected Address addressEntityToAddress(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        Address address = new Address();

        address.setAdressID( addressEntity.getAdressID() );
        address.setPays( addressEntity.getPays() );
        address.setVille( addressEntity.getVille() );
        address.setCodePostal( addressEntity.getCodePostal() );
        address.setRue( addressEntity.getRue() );
        address.setNumero( addressEntity.getNumero() );
        address.setBox( addressEntity.getBox() );

        return address;
    }

    protected Person personEntityToPerson(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        Person person = new Person();

        person.setPersonID( personEntity.getPersonID() );
        person.setNom( personEntity.getNom() );
        person.setPrenom( personEntity.getPrenom() );
        person.setEmail( personEntity.getEmail() );
        person.setNTel( personEntity.getNTel() );
        person.setLocalisation( addressEntityToAddress( personEntity.getLocalisation() ) );

        return person;
    }
}
