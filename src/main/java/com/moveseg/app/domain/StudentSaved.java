package com.moveseg.app.domain;

import java.time.Instant;

import com.moveseg.app.infra.domain.DomainEvent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import static lombok.AccessLevel.PRIVATE;

@Getter
@ToString
@Builder(access = PRIVATE)
public class StudentSaved implements DomainEvent {
    private final StudentId studentId;
    private final String firstName;
    private final Instant occurredOn;

    public static StudentSaved from(StudentEntity account) {
        return StudentSaved.builder()
                .studentId(account.id())
                .firstName(account.firstName())
                .occurredOn(Instant.now())
                .build();
    }
}
