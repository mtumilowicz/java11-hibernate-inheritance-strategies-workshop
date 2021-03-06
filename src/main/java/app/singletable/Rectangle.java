package app.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// discriminator: Rectangle, hint: @DiscriminatorValue
@Getter
@Setter
class Rectangle extends Shape {

    private double width;

    private double length;
}