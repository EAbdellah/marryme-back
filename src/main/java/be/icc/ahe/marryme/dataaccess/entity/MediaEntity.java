package be.icc.ahe.marryme.dataaccess.entity;

import be.icc.ahe.marryme.model.dto.GetShortFormuleDTO;
import be.icc.ahe.marryme.model.dto.GetShortMediaServiceDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NamedNativeQuery(
        name  = "getMediaByProvider",
        query = "SELECT  service.service_id,service.nom,service.type,media.do_album,media.do_souvenir,media.is_photo,media.is_video " +
                "FROM ((((myschema.media as media " +
                "INNER JOIN myschema.abstract_service as service ON service.service_id  = media.service_id) " +
                "INNER JOIN myschema.societe as societe ON service.service_id  = societe.service_id) " +
                "INNER JOIN myschema.person as person ON societe.person_id  = person.person_id) " +
                "INNER JOIN myschema.user as user ON user.user_id  = person.user_id) " +
                "Where user.email = :provider_email ; "
        ,
        resultSetMapping = "mediaByProvider"
)

@SqlResultSetMapping(
        name = "mediaByProvider",
        classes = {
                @ConstructorResult(
                        targetClass = GetShortMediaServiceDTO.class,
                        columns = {

                                @ColumnResult(name = "service_id", type = Long.class),
                                @ColumnResult(name = "nom", type = String.class),
                                @ColumnResult(name = "type", type = String.class),
                                @ColumnResult(name = "do_souvenir", type = Boolean.class),
                                @ColumnResult(name = "do_album", type = Boolean.class),
                                @ColumnResult(name = "is_photo", type = Boolean.class),
                                @ColumnResult(name = "is_video", type = Boolean.class),
                        })
        }
)

@Entity
@Table(name = "media")
@NoArgsConstructor
@Setter
@Getter
public class MediaEntity extends ServiceEntity implements Serializable {

    @Column(name = "isPhoto")
    private Boolean isPhoto;
    @Column(name = "isVideo")
    private Boolean isVideo;
    @Column(name = "doAlbum")
    private Boolean doAlbum;
    @Column(name = "doSouvenir")
    private Boolean doSouvenir;

  }
