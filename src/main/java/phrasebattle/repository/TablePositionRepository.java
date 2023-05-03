package phrasebattle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phrasebattle.model.TablePosition;

import java.util.List;

public interface TablePositionRepository extends JpaRepository<TablePosition, Long> {

//    List<TablePosition> saveAll(List<TablePosition> positions);
}
