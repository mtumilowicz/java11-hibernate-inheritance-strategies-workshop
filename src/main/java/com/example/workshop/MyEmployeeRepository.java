package com.example.workshop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MyEmployeeRepository extends JpaRepository<MyEmployee, Long> {
}
