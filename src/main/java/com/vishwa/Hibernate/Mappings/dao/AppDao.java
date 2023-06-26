package com.vishwa.Hibernate.Mappings.dao;

import com.vishwa.Hibernate.Mappings.entity.Instructor;
import org.springframework.stereotype.Repository;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
