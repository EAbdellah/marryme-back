package be.icc.ahe.marryme.dataaccess.repository;

import be.icc.ahe.marryme.dataaccess.entity.ReservationEntity;
import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.model.dto.ReservationClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ReservationRepo extends JpaRepository<ReservationEntity,Long> {

    List<ReservationEntity> findAllByUser(UserEntity user);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, name = "getAllReservationsByUser")
    List<ReservationClientDTO> getAllReservationsByUser(@Param("asking_user_id") Long asking_user_id);

    Integer countByTicket(String ticket);
}
