package be.icc.ahe.marryme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter @Setter @NoArgsConstructor
public class ServiceTraiteur extends Service {
    private Boolean manOnly;
    private Boolean womanOnly;

}
