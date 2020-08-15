package test.task.room_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import test.task.room_booking.repository.model.ReservationReason;

public interface ReservationReasonRepository extends JpaRepository<ReservationReason, Integer> {

    @Transactional
    ReservationReason findByNameAndDescription(String name, String description);
}
