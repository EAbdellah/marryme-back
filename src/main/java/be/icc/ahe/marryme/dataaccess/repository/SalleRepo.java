package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.SalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface SalleRepo extends JpaRepository<SalleEntity,Long> {

}
