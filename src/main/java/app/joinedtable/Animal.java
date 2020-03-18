package app.joinedtable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
// hint: Inheritance, strategy: JOINED
@Getter
@Setter
class Animal {

    @Id
    @GeneratedValue
    long id;
}