package numerotation.config_service.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import numerotation.config_service.DTO.RuleDto;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ConfigurationRulesDTO {
    private String configid ;
    private List<RuleDto> rules;

    public String getConfigid() {
        return configid;
    }

    public void setConfigid(String configid) {
        this.configid = configid;
    }

    public List<RuleDto> getRules() {
        return rules;
    }

    public void setRules(List<RuleDto> rules) {
        this.rules = rules;
    }
}
