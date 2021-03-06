package app.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CircleRepository extends JpaRepository<Circle, Long> {
}
