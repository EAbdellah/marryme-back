package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.MediaEntity;
import be.icc.ahe.marryme.model.dto.GetShortFormuleDTO;
import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MediaRepo  extends JpaRepository<MediaEntity,Long> {
    @Transactional(readOnly = true)
    @Query(nativeQuery = true, name = "getMediaByProvider")
    GetShortMediaServiceDTO getMediaByProvider(@Param("provider_email") String providerEmail);

}
