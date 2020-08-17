package test.task.room_booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import test.task.room_booking.service.RoomService;
import test.task.room_booking.service.dto.request.RoomRequestDto;
import test.task.room_booking.service.dto.response.RoomResponseDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

import static test.task.room_booking.constant.UrlConstant.PATH_ID_URL;
import static test.task.room_booking.constant.UrlConstant.ROOMS_URL;

@RestController
@RequestMapping(ROOMS_URL)
@CrossOrigin(origins = "http://localhost:3000")
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping
    public ResponseEntity<Page<RoomResponseDto>> findRooms(@RequestParam int currentPage,
                                                           @RequestParam int recordAmount) {
        Page<RoomResponseDto> allPages = service.findAllModels(currentPage, recordAmount);
        return ResponseEntity.ok(allPages);
    }


    @GetMapping(PATH_ID_URL)
    public ResponseEntity<RoomResponseDto> findRoom(@PathVariable @NotNull Integer id) {
        RoomResponseDto room = service.findModel(id);
        return ResponseEntity.ok(room);
    }

    @PostMapping
    public ResponseEntity addRoom(@Valid @RequestBody RoomRequestDto dto,
                                  UriComponentsBuilder uriBuilder) {
        Integer id = service.addModel(dto);
        URI uri = uriBuilder.path(ROOMS_URL + PATH_ID_URL).buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
