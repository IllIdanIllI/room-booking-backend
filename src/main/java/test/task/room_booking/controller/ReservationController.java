package test.task.room_booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import test.task.room_booking.service.ReservationService;
import test.task.room_booking.service.dto.request.ReservationRequestDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

import static test.task.room_booking.constant.UrlConstant.*;

@RestController
@RequestMapping(RESERVATIONS_URL)
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {


    @Autowired
    private ReservationService service;

    @PostMapping
    public ResponseEntity reserveRoom(@Valid @RequestBody ReservationRequestDto dto,
                                      UriComponentsBuilder uriBuilder) {
        Integer id = service.reserveRoom(dto);
        URI uri = uriBuilder.path(RESERVATIONS_URL + PATH_ID_URL).buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(PATH_ID_URL + STOP_URL)
    public ResponseEntity stopReservation(@PathVariable @NotNull Integer id) {
        service.stopReservation(id);
        return ResponseEntity.ok("Reservation has been stopped");
    }
}
