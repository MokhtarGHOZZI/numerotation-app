package numerotation.counter_service.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "counters")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Counter {
    @Id
    private String configid ;
    private Integer valeurInitiale;
    private Integer valeurActuelle;

    public String getConfigid() {
        return configid;
    }

    public void setConfigid(String configid) {
        this.configid = configid;
    }

    public int getValeurInitiale() {
        return valeurInitiale;
    }

    public void setValeurInitiale(int valeurInitiale) {
        this.valeurInitiale = valeurInitiale;
    }

    public int getValeurActuelle() {
        return valeurActuelle;
    }

    public void setValeurActuelle(int valeurActuelle) {
        this.valeurActuelle = valeurActuelle;
    }
}