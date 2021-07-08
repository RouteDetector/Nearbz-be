package com.danijelsudimac.Nearbz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private Double longitude;
    private Double latitude;
    private String imagePath;
    private Long token;

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        // field comparison
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", image='" + this.imagePath + '\''+ ", longitude='" + this.longitude + '\'' + ", latitude='" + this.latitude + '\'' + '}';
    }
}
