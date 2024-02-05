package com.moveseg.app.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static lombok.AccessLevel.PRIVATE;

import com.moveseg.parent.infra.domain.AbstractAggregateRoot;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = PRIVATE, force = true)

@Entity
public class StudentEntity extends AbstractAggregateRoot<StudentId> {

    private final String firstName;

    private StudentEntity(String firstName) {
        super(randomId(StudentId.class));
        this.firstName = firstName;
    }

    public static StudentEntity of(String firstName) {
        StudentEntity account = new StudentEntity(firstName);
        account.registerEvent(StudentSaved.from(account));
        return account;
    }
}