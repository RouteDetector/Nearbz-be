package com.danijelsudimac.Nearbz.repository;

import com.danijelsudimac.Nearbz.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}