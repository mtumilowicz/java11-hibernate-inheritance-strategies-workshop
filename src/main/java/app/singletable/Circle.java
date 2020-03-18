package app.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// discriminator: Circle, hint: @DiscriminatorValue
@Getter
@Setter
class Circle extends Shape {

    private double radius;
}