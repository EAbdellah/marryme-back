package be.icc.ahe.marryme.model;

public class Media extends Service {

    private Boolean isPhoto;
    private Boolean isVideo;

    public Media() {
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

    @Override
    public String toString() {
        return "MediaEntity{" +
                "isPhoto=" + isPhoto +
                ", isVideo=" + isVideo +
                '}';
    }

}
