package nasa.unam.mx.nasa.model;

public class ApodFavorite
{
    public int id;
    public String imgSrc;
    public String cameraFullName;
    public String earthDate;
    public String roverName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getCameraFullName() {
        return cameraFullName;
    }

    public void setCameraFullName(String cameraFullName) {
        this.cameraFullName = cameraFullName;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    public String getRoverName() {
        return roverName;
    }

    public void setRoverName(String roverName) {
        this.roverName = roverName;
    }
}
