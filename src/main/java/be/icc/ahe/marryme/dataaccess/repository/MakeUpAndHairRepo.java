package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.MakeUpAndHairEntity;
import be.icc.ahe.marryme.model.dto.GetShortFormuleDTO;
import be.icc.ahe.marryme.model.dto.GetShortMakeUpAndAirServiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MakeUpAndHairRepo extends JpaRepository<MakeUpAndHairEntity,Long> {

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, name = "getMakeUpAndAirByProvider")
    GetShortMakeUpAndAirServiceDTO getMakeUpAndAirByProvider(@Param("provider_email") String ProviderEmail);

}
