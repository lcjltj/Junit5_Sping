package com.example.junit5_database.test.repository;

import com.example.junit5_database.test.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

    TestEntity findByName(String name);

}
