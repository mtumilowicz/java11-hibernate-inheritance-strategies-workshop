package app.mappedsuperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Tag extends BaseEntity {
    private String name;
}