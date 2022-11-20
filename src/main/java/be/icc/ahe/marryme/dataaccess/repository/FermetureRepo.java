package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.FermetureEntity;
import be.icc.ahe.marryme.model.dto.GetShortFermetureDTO;
import be.icc.ahe.marryme.model.dto.ReservationClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface FermetureRepo extends JpaRepository<FermetureEntity, Long> {
    @Transactional(readOnly = true)
    @Query(nativeQuery = true, name = "getAllFermetureByProvider")
    List<GetShortFermetureDTO> getAllFermetureByProvider(@Param("provider_email") String ProviderEmail);

}
