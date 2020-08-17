package test.task.room_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import test.task.room_booking.repository.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Transactional
    @Query(value = "SELECT * FROM reservation r " +
            "WHERE r.date_out > ?1 AND r.room_id = ?2", nativeQuery = true)
    List<Reservation> findAppropriateReservations(LocalDateTime currentDate, Integer roomId);

    @Transactional
    @Query(value = "SELECT * FROM reservation r " +
            "WHERE r.date_out > ?1 AND r.employee_id = ?2", nativeQuery = true)
    List<Reservation> findEmployeeReservations(LocalDateTime currentDate, Integer employeeId);

}
