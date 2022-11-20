package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.ServiceTraiteurEntity;
import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortServiceTraiteurServiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ServiceTraiteurRepo extends JpaRepository<ServiceTraiteurEntity,Long> {
    @Transactional(readOnly = true)
    @Query(nativeQuery = true, name = "getServiceTraiteurByProvider")
    GetShortServiceTraiteurServiceDTO getServiceTraiteurByProvider(@Param("provider_email") String providerEmail);

}
