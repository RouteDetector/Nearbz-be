package com.danijelsudimac.Nearbz.controller;

import com.danijelsudimac.Nearbz.DummyData;
import com.danijelsudimac.Nearbz.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @GetMapping("/persons/{id}")
    public List<Person> persons(@PathVariable(value = "id") String id) {
        return DummyData.getData();
    }
}