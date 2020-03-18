package app.singletable;

import javax.persistence.*;

@Entity
// discriminator column: type, hint: @DiscriminatorColumn
// inheritance: SINGLE_TABLE
class Shape {

    @Id
    @GeneratedValue
    private Long id;
}