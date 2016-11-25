package no.avec.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by avec on 25/11/2016.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Sex sex;

    public enum Sex {
        MALE,
        FEMALE
    }
}
