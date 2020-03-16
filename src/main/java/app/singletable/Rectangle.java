package app.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Rectangle")
@Getter
@Setter
class Rectangle extends Shape {

    private double width;

    private double length;
}