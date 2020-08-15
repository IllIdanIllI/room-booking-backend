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

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> findEmployee(@PathVariable @NotNull Integer id) {
        EmployeeResponseDto employee = service.findModel(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity addEmployee(@Valid @RequestBody EmployeeRequestDto dto,
                                      UriComponentsBuilder uriBuilder) {
        Integer id = service.addModel(dto);
        URI uri = uriBuilder.path("/employees/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
