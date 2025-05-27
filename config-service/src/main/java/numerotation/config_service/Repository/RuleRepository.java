package numerotation.config_service.Repository;


import numerotation.config_service.Entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RuleRepository extends JpaRepository<Rule, Long> {
    List<Rule> findAllByConfigidOrderByOrderIndexAsc(String id);
    void deleteByConfigid(String configId);
    @Query("SELECT DISTINCT r.configid FROM Rule r")
    List<String> findAllConfigIds();
    //void deleteByConfigId(String configId);
}
