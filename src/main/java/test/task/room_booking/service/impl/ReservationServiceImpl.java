package test.task.room_booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.task.room_booking.repository.ReservationRepository;
import test.task.room_booking.repository.model.Reservation;
import test.task.room_booking.service.ReservationService;
import test.task.room_booking.service.dto.request.ReservationRequestDto;
import test.task.room_booking.service.exception.ReservationProcessingException;
import test.task.room_booking.service.format.FormatHandler;
import test.task.room_booking.service.mapper.EntityMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository repository;
    @Autowired
    private FormatHandler<LocalDateTime> formatter;
    @Autowired
    private EntityMapper<Reservation, ReservationRequestDto> requestMapper;

    @Override
    @Transactional
    public Integer reserveRoom(ReservationRequestDto dto) {
        LocalDateTime dateIn = formatter.receiveFormattedDate(dto.getDateIn());
        LocalDateTime dateOut = formatter.receiveFormattedDate(dto.getDateOut());
        List<Reservation> reservations = repository
                .findAppropriateReservation(LocalDateTime.now(), dto.getRoomId());
        Optional<Reservation> conflictReservation = reservations.stream()
                .filter(res -> dateIn.isAfter(res.getDateIn())
                        && dateIn.isBefore(res.getDateOut())
                        || dateOut.isBefore(res.getDateIn())
                        && dateOut.isAfter(res.getDateOut()))
                .findFirst();
        if (conflictReservation.isPresent() && !reservations.isEmpty()) {
            throw new ReservationProcessingException("This time has already booked");
        } else {
            return setUpReservation(dto);
        }
    }

    private Integer setUpReservation(ReservationRequestDto dto) {
        Reservation reservation = requestMapper.map(dto);
        repository.save(reservation);
        Integer id = reservation.getId();
        if (id == null) {
            throw new ReservationProcessingException("Smth went wrong");
        } else {
            return id;
        }
    }

    @Override
    @Transactional
    public void stopReservation(Integer reservationId) {
        Optional<Reservation> optionalReservation = repository.findById(reservationId);
        Reservation reservation = optionalReservation
                .orElseThrow(() -> new ReservationProcessingException("Such reservation do not exist"));
        reservation.setDateOut(LocalDateTime.now());
        repository.save(reservation);
    }
}
