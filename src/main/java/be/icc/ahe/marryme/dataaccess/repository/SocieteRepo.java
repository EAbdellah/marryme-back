package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;
import be.icc.ahe.marryme.model.Societe;
import be.icc.ahe.marryme.model.dto.ProviderRequestRegistrationDTO;
import be.icc.ahe.marryme.model.dto.ReservationClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface SocieteRepo extends JpaRepository<SocieteEntity,Long> {

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, name = "getAllProviderRequestRegistration")
    List<ProviderRequestRegistrationDTO> getAllProviderRequestRegistration();

    Optional<SocieteEntity> findByEmail(String email);

}
