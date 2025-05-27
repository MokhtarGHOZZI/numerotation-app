package numerotation.counter_service.DTO;


import lombok.Data;

@Data
public class CounterDto {
    private String configid ;
    private Integer valeurActuelle;

    public String getConfigid() {
        return configid;
    }

    public void setConfigid(String configid) {
        this.configid = configid;
    }

    public Integer getValeurActuelle() {
        return valeurActuelle;
    }

    public void setValeurActuelle(Integer valeurActuelle) {
        this.valeurActuelle = valeurActuelle;
    }
}
