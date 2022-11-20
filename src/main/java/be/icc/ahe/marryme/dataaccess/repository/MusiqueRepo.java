package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.MusiqueEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import be.icc.ahe.marryme.model.dto.GetShortFormuleDTO;
import be.icc.ahe.marryme.model.dto.GetShortMusiqueServiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public interface MusiqueRepo  extends JpaRepository<MusiqueEntity,Long> {

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, name = "getMusiqueByProvider")
    GetShortMusiqueServiceDTO getMusiqueByProvider(@Param("provider_email") String providerEmail);

}
