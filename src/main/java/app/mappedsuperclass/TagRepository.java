package app.mappedsuperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TagRepository extends JpaRepository<Tag, Long> {
}
