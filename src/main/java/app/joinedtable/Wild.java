package app.joinedtable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Wild extends Animal {
    private boolean endangered;
}