package be.icc.ahe.marryme.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "media")
@NoArgsConstructor
@Setter
@Getter
public class MediaEntity extends ServiceEntity implements Serializable {

    @Column(name = "isPhoto", nullable = false)
    private Boolean isPhoto;
    @Column(name = "isVideo", nullable = false)
    private Boolean isVideo;
    @Column(name = "doAlbum", nullable = false)
    private Boolean doAlbum;
    @Column(name = "doSouvenir", nullable = false)
    private Boolean doSouvenir;

  }
