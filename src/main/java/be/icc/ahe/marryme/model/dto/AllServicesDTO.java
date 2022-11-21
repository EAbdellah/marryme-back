package be.icc.ahe.marryme.model.dto;

import be.icc.ahe.marryme.dataaccess.entity.*;
import be.icc.ahe.marryme.dataaccess.entity.enumeration.HallType;
import be.icc.ahe.marryme.dataaccess.entity.enumeration.MusiqueType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllServicesDTO {

    private Long serviceID;
    private String type ;
    private String nom;
    private ImageEntity image;
    private Boolean doHair;
    private Boolean doMakeUp;
    private Boolean doMan;
    private Boolean doWoman;
    private Boolean isPhoto;
    private Boolean isVideo;
    private Boolean doAlbum;
    private Boolean doSouvenir;
    private String musiqueType ;
    private Integer capaciteTotal;
    private Integer placeAssise;
    private Boolean pisteDance;
    private Boolean decoration;
    private Boolean materielMusique;
    private Boolean traiteur;
    private Boolean cuisine;
    private Boolean isExternal;
    private String hallTypeEntity;
    private Boolean haveParking;
    private Boolean manOnly;
    private Boolean womanOnly;
    private Boolean doMeat;
    private Boolean doFish;
    private Boolean doVegan;
    private Boolean DoVegetarian;
    private String presentation;


}
