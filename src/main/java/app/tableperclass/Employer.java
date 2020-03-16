package app.tableperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Employer extends Person {
    int budget;
}
