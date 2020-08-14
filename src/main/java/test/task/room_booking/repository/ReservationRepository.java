package test.task.room_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import test.task.room_booking.repository.model.Reservation;
import test.task.room_booking.repository.model.Room;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Transactional
    @Query(value = "SELECT * FROM room LEFT JOIN reservation r ON room.id = r.room_id " +
            "WHERE (r.date_in NOT BETWEEN ?1 AND ?2) " +
            "OR (r.date_out NOT BETWEEN ?1 AND ?2) " +
            "OR (r.date_in IS NULL AND r.date_out IS NULL)",
            nativeQuery = true)
    List<Room> findAllEmptyRoomsByDate(LocalDateTime dateIn, LocalDateTime dateOut);

    @Transactional
    @Query(value = "SELECT * FROM reservation r " +
            "WHERE r.date_in > ?1 OR  r.date_out > ?1 AND r.room_id = ?2", nativeQuery = true)
    List<Reservation> findAppropriateReservation(LocalDateTime currentDate, Integer roomId);

}
