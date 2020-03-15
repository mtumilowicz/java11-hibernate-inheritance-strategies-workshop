package app.singletable;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Shape {

    @Id
    @GeneratedValue
    private Long id;

}