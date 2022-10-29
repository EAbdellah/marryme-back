package be.icc.ahe.marryme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Getter @Setter @NoArgsConstructor
@ToString
public class ServiceTraiteur extends Service {
    private Boolean manOnly;
    private Boolean womanOnly;

}
