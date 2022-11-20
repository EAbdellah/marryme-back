package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortTraiteurServiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TraiteurRepo extends JpaRepository<TraiteurEntity,Long> {

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, name = "getTraiteurByProvider")
    GetShortTraiteurServiceDTO getTraiteurByProvider(@Param("provider_email") String providerEmail);

}
