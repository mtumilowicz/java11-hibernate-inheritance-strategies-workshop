package app.tableperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
// inheritance: TABLE_PER_CLASS
class Person {

    @Id
    @GeneratedValue
    Long id;
}
