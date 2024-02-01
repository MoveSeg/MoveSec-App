package com.moveseg.app.app;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;
import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.validation.annotation.Validated;

import com.moveseg.app.app.cmd.StudentForms;
import com.moveseg.app.domain.StudentEntity;
import com.moveseg.app.domain.StudentId;
import com.moveseg.app.domain.StudentRepository;
import com.moveseg.app.domain.StudentSaved;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor

@Service
@Validated
@Transactional(propagation = REQUIRES_NEW)
public class StudentService {

    private final StudentRepository repository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public StudentId handle(StudentForms.CreateStudent cmd) {
        StudentEntity entity = StudentEntity.of(cmd.name());
        repository.save(entity);
        return entity.id();
    }

    @TransactionalEventListener
    public void on(StudentSaved event) {
        System.out.println("================Handling Event!================");
        System.out.println("Student Event Received - Student ID: "
                + event.studentId() + ", First Name: "
                + event.firstName());
    }
}
