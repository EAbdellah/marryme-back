package be.icc.ahe.marryme.model;

import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Image {

    private Long imageID;
    private byte[] photo;
    private Service service;
    @JsonBackReference
    private Formule formule;

}
