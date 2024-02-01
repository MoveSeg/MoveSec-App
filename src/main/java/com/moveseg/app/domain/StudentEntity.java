package com.moveseg.app.domain;

import static lombok.AccessLevel.PRIVATE;
import static com.moveseg.app.infra.domain.DomainObjectId.randomId;

import org.hibernate.usertype.UserTypeLegacyBridge;
import org.springdoc.core.converters.models.MonetaryAmount;

import com.moveseg.app.infra.domain.AbstractAggregateRoot;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CompositeType;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.usertype.UserTypeLegacyBridge;

@Getter
@ToString
@NoArgsConstructor(access = PRIVATE, force = true)

@Entity
public class StudentEntity extends AbstractAggregateRoot<StudentId> {

    @Type(value = UserTypeLegacyBridge.class, parameters = @Parameter(name = UserTypeLegacyBridge.TYPE_NAME_PARAM_KEY, value = "StudentId"))
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