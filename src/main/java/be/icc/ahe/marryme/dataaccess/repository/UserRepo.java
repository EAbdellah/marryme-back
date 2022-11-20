package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.model.User;
import be.icc.ahe.marryme.model.dto.GetShortTraiteurServiceDTO;
import be.icc.ahe.marryme.model.dto.GetTypeOfService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<UserEntity,Long> {

    UserEntity findUserByEmail(String email);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, name = "getTypeOfServiceByProvider")
    String getTypeOfServiceByProvider (@Param("provider_email") String providerEmail);

}
