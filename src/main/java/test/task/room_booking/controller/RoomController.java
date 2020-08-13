package test.task.room_booking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class RoomController {

    @PostMapping
    public ResponseEntity addRoom(@RequestParam int number,
                                  @RequestParam String type,
                                  UriComponentsBuilder uriBuilder) {
        URI uri = uriBuilder.path("/room/").buildAndExpand("id").toUri();
        return ResponseEntity.created(uri).build();
    }
}
