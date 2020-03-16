package app.joinedtable;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Pet extends Animal {
    private String name;
}