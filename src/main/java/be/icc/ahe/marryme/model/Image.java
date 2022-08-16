package be.icc.ahe.marryme.model;

import be.icc.ahe.marryme.dataaccess.entity.FormuleEntity;
import be.icc.ahe.marryme.dataaccess.entity.ServiceEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class Image {

    private Long imageID;
    private byte[] photo;
    private Service service;
    private Formule formule;

}
