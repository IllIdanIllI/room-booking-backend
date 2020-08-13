package test.task.room_booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import test.task.room_booking.service.RoomService;
import test.task.room_booking.service.dto.request.RoomRequestDto;
import test.task.room_booking.service.dto.response.RoomResponseDto;

import java.net.URI;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService service;

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponseDto> findRoom(@PathVariable int id) {
        RoomResponseDto room = service.findModel(id);
        return ResponseEntity.ok(room);
    }

    @PostMapping
    public ResponseEntity addRoom(@RequestBody RoomRequestDto dto,
                                  UriComponentsBuilder uriBuilder) {
        Integer id = service.addModel(dto);
        URI uri = uriBuilder.path("/room/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
