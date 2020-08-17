package test.task.room_booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import test.task.room_booking.service.EmployeeService;
import test.task.room_booking.service.dto.request.EmployeeRequestDto;
import test.task.room_booking.service.dto.response.EmployeeResponseDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

import static test.task.room_booking.constant.UrlConstant.EMPLOYEES_URL;
import static test.task.room_booking.constant.UrlConstant.PATH_ID_URL;

@RestController
@RequestMapping(EMPLOYEES_URL)
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping(PATH_ID_URL)
    public ResponseEntity<EmployeeResponseDto> findEmployee(@PathVariable @NotNull Integer id) {
        EmployeeResponseDto employee = service.findModel(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity addEmployee(@Valid @RequestBody EmployeeRequestDto dto,
                                      UriComponentsBuilder uriBuilder) {
        Integer id = service.addModel(dto);
        URI uri = uriBuilder.path(EMPLOYEES_URL + PATH_ID_URL).buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
