package be.icc.ahe.marryme.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Media extends Service{
    private Boolean isPhoto;
    private Boolean isVideo;
    private Boolean doAlbum;
    private Boolean doSouvenir;

}
