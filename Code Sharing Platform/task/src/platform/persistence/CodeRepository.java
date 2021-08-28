package platform.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.business.Code;

import java.util.List;

@Repository
public interface CodeRepository extends CrudRepository<Code, String> {
    Code findCodeByUuid(String uuid);
    List<Code> findTop10ByOrderByDateDesc();
    List<Code> findAllByOrderByDateDesc();
}
