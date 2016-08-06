
package nasa.unam.mx.nasa.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import nasa.unam.mx.nasa.model.Photo;

public class MarsRoverResponse {

    @SerializedName("photos")
    @Expose
    private List<Photo> photos = new ArrayList<Photo>();

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

}
