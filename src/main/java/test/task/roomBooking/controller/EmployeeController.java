package test.task.roomBooking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import test.task.roomBooking.service.EmployeeService;
import test.task.roomBooking.service.dto.request.EmployeeRequestDto;
import test.task.roomBooking.service.dto.response.EmployeeResponseDto;

import java.net.URI;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<EmployeeResponseDto> addEmployee(@RequestParam int id) {
        EmployeeResponseDto employee = service.findEmployee(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity addEmployee(@RequestBody EmployeeRequestDto dto,
                                      UriComponentsBuilder uriBuilder) {
        Integer id = service.addEmployee(dto);
        URI uri = uriBuilder.path("/employee/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
