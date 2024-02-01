package com.moveseg.app.domain;

import java.sql.ResultSet;

import com.moveseg.app.infra.hibernate.DomainObjectIdCustomType;
import com.moveseg.app.infra.hibernate.DomainObjectIdTypeDescriptor;

public class StudentIdType extends DomainObjectIdCustomType<StudentId> {

    private static final long serialVersionUID = -2160651261294939489L;

    private static final DomainObjectIdTypeDescriptor<StudentId> TYPE_DESCRIPTOR = new DomainObjectIdTypeDescriptor<StudentId>(
            StudentId.class, StudentId::new);

    public StudentIdType() {
        super(TYPE_DESCRIPTOR);
    }

    @Override
    public String getName() {
        return "StudentId";
    }

}
