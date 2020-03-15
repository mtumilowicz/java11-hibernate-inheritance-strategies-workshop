package app.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Circle")
@Getter
@Setter
public class Circle extends Shape {

    private double radius;
}