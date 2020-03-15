package app.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WildRepository extends JpaRepository<Wild, Long> {
}
