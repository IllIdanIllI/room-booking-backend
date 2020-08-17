package test.task.room_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.task.room_booking.repository.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

//    @Transactional
//    @Query(value = "SELECT DISTINCT room.id FROM room LEFT JOIN reservation r ON room.id = r.room_id " +
//            "WHERE r.date_out > ?1 OR (r.date_in IS NULL AND r.date_out IS NULL)",
//            countQuery = "SELECT COUNT(DISTINCT room.id) FROM room LEFT JOIN reservation r ON room.id = r.room_id" +
//                    " WHERE r.date_out > ? OR (r.date_in IS NULL AND r.date_out IS NULL)",
//            nativeQuery = true)
//    Page<Integer> findAllRoomsWithRelevantDate(LocalDateTime currentDate, Pageable pageable);
//
//    @Transactional
//    @Query(value = "SELECT * FROM room LEFT JOIN reservation r ON room.id = r.room_id " +
//            "WHERE (r.date_in NOT BETWEEN ?1 AND ?2) " +
//            "OR (r.date_out NOT BETWEEN ?1 AND ?2) " +
//            "OR (r.date_in IS NULL AND r.date_out IS NULL)",
//            nativeQuery = true)
//    List<Room> findAllEmptyRoomsByDate(LocalDateTime dateIn, LocalDateTime dateOut);

}
