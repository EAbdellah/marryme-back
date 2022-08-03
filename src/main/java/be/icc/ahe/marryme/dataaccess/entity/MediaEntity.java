package be.icc.ahe.marryme.dataaccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "media")
public class MediaEntity extends ServiceEntity implements Serializable {

    @Column(name = "isPhoto", nullable = false)
    private Boolean isPhoto;
    @Column(name = "isVideo", nullable = false)
    private Boolean isVideo;
    @Column(name = "doAlbum", nullable = false)
    private Boolean doAlbum;
    @Column(name = "doSouvenir", nullable = false)
    private Boolean doSouvenir;

    public MediaEntity() {
    }

    public Boolean getPhoto() {
        return isPhoto;
    }

    public void setPhoto(Boolean photo) {
        isPhoto = photo;
    }

    public Boolean getVideo() {
        return isVideo;
    }

    public void setVideo(Boolean video) {
        isVideo = video;
    }

    public Boolean getDoAlbum() {
        return doAlbum;
    }

    public void setDoAlbum(Boolean doAlbum) {
        this.doAlbum = doAlbum;
    }

    public Boolean getDoSouvenir() {
        return doSouvenir;
    }

    public void setDoSouvenir(Boolean doSouvenir) {
        this.doSouvenir = doSouvenir;
    }

    @Override
    public String toString() {
        return "MediaEntity{" +
                "isPhoto=" + isPhoto +
                ", isVideo=" + isVideo +
                ", doAlbum=" + doAlbum +
                ", doSouvenir=" + doSouvenir +
                '}';
    }
}
