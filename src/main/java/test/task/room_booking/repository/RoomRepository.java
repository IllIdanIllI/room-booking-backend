package test.task.room_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.task.room_booking.repository.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
