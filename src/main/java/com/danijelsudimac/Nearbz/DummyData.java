package com.danijelsudimac.Nearbz;

import com.danijelsudimac.Nearbz.model.Person;

import java.util.List;

public class DummyData {

    public static List<Person> getData() {
        return List.of(
                getPerson(1L, "localhost:8080/img/1", 44.802432, 20.478773, 1L),
                getPerson(2L, "localhost:8080/img/2", 44.802386, 20.478741, 2L),
                getPerson(3L, "localhost:8080/img/3", 44.802355, 20.478816, 3L),
                getPerson(4L, "localhost:8080/img/4", 44.802447, 20.478907, 4L)
        );
        //my location 44.802409, 20.478848
    }

    public static Person getPerson(long id, String path, double lat, double lon, long token) {
        Person p = new Person();
        p.setId(id);
        p.setImagePath(path);
        p.setLatitude(lat);
        p.setLongitude(lon);
        p.setToken(token);
        return p;
    }
}
