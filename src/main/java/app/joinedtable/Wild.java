package app.joinedtable;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Wild extends Animal {
    private boolean endangered;
}