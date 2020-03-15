package app.mappedsuperclass;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
@Getter
public class BaseEntity {

    @Id
    @GeneratedValue
    Long id;

    @Version
    Integer version;
}