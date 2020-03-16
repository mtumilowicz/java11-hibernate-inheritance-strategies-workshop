package app.joinedtable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
class Animal {

    @Id
    @GeneratedValue
    long id;
}