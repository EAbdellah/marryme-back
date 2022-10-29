package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.MusiqueEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
@Transactional
public interface MusiqueRepo  extends JpaRepository<MusiqueEntity,Long> {

//    @Query("select new MusiqueEntity (d.ServiceID, d.nom) from ServiceEntity d ")
//    Collection<ServiceEntity> findAllServiceForListMenu();
}
