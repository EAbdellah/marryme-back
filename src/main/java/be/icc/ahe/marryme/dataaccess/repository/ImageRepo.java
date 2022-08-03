package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ImageRepo extends JpaRepository<ImageEntity,Long> {
}
