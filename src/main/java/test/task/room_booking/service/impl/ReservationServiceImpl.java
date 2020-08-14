package test.task.room_booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.room_booking.repository.RoomRepository;
import test.task.room_booking.service.ReservationService;
import test.task.room_booking.service.dto.request.ReservationRequestDto;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ReservationService service;

    @Override
    public void reserveRoom(ReservationRequestDto dto) {
//        Boolean reserved = roomRepository.findReserveStatusById(dto.getRoomId());
//        Optional<Room> room = roomRepository.findById(dto.getRoomId());
//        LocalDateTime currentTime = LocalDateTime.now();
//        currentTime.isBefore()
//        if (reserved){
//
//        } else {
//            service.reserveRoom(dto);
//        }
    }
}
