package com.crud.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crud.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
    
    

}
