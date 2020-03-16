package app.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PetRepository extends JpaRepository<Pet, Long> {
}
