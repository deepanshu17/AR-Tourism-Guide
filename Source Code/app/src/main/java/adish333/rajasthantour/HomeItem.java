package adish333.rajasthantour;

/**
 * Created by Adish Jain on 8/14/2017.
 */

public class HomeItem {
    private String name;
    private int thumbnail;

    public HomeItem() {
    }

    public HomeItem(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
