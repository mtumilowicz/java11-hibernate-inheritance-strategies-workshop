package app.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AnimalRepository extends JpaRepository<Animal, Long> {
}
