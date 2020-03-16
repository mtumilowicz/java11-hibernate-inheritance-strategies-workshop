package app.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EmployerRepository extends JpaRepository<Employer, Long> {
}
