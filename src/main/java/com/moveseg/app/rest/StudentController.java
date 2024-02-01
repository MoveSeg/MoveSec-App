package com.moveseg.app.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.app.StudentService;
import com.moveseg.app.app.cmd.StudentForms.CreateStudent;
import com.moveseg.app.domain.StudentId;

import lombok.AllArgsConstructor;

@AllArgsConstructor

@RestController
@RequestMapping(path = "/api/students", produces = APPLICATION_JSON_VALUE)

public class StudentController {
    private final StudentService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Void> create(@RequestBody CreateStudent form) {

        StudentId id = service.handle(form);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

}
