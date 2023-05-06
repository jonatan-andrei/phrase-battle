package phrasebattle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phrasebattle.model.TablePosition;

public interface TablePositionRepository extends JpaRepository<TablePosition, Long> {

}
