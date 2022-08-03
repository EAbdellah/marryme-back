package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.ServiceTraiteurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ServiceTraiteurRepo extends JpaRepository<ServiceTraiteurEntity,Long> {
}
