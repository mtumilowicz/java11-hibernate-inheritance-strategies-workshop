package app.joinedtable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
class Pet extends Animal {

    private String name;
}