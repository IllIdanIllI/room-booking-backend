package test.task.room_booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import test.task.room_booking.service.ReservationService;
import test.task.room_booking.service.dto.request.ReservationRequestDto;

import java.net.URI;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @PostMapping
    public ResponseEntity reserveRoom(@RequestBody ReservationRequestDto dto,
                                      UriComponentsBuilder uriBuilder) {
        Integer id = service.reserveRoom(dto);
        URI uri = uriBuilder.path("/reservations/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
