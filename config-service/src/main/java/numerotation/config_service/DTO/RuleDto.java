package numerotation.config_service.DTO;


import jakarta.validation.constraints.NotNull;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.lang.NonNull;

public class RuleDto {
    private Long id;
    private String dateFormat;

    @NotNull
    private String field;
    private Integer length;
    private int orderIndex;
    private String prefix;
    private String suffix;
    @NotNull
    private String configid;
    private Integer valeurInitiale;

    public Integer getValeurInitiale() {
        return valeurInitiale;
    }

    public void setValeurInitiale(Integer valeurInitile) {
        this.valeurInitiale = valeurInitile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfigid() {
        return configid;
    }

    public void setConfigid(String configid) {
        this.configid = configid;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }


}
