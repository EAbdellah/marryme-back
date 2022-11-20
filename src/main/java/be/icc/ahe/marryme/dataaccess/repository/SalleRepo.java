package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import be.icc.ahe.marryme.model.dto.GetShortSalleServiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface SalleRepo extends JpaRepository<SalleEntity,Long> {
    @Transactional(readOnly = true)
    @Query(nativeQuery = true, name = "getSalleByProvider")
    GetShortSalleServiceDTO getSalleByProvider(@Param("provider_email") String providerEmail);

}
