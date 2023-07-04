package com.example.demo.repository;

import com.example.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    @Query("SELECT e from Employee e WHERE e.name LIKE CONCAT('%', :query, '%')")
    List<Employee> searchEmployees(String query);
}
