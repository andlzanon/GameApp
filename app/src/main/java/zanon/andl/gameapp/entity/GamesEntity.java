package zanon.andl.gameapp.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Andre on 26/11/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Entidade de Games, possui
 * todos os atributos correspondentes ao arquivo JSON
 */

public class GamesEntity implements Parcelable{

    //assinatura serializable do GSON faz com
    //que o GSON tranforme o JSON no atributo correto
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("trailer")
    @Expose
    private String trailer;
    @SerializedName("platforms")
    @Expose
    private List<String> platforms = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

    private GamesEntity(Parcel from){
        id = from.readInt();
        name = from.readString();
        image = from.readString();
        releaseDate = from.readString();
        trailer = from.readString();
        platforms = from.createStringArrayList();
    }

    public static final Parcelable.Creator<GamesEntity>
        CREATOR = new Parcelable.Creator<GamesEntity>(){

        public GamesEntity createFromParcel(Parcel in){
            return new GamesEntity(in);
        }

        @Override
        public GamesEntity[] newArray(int i) {
            return new GamesEntity[i];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(releaseDate);
        dest.writeString(trailer);
        dest.writeStringList(platforms);
    }

    @Override
    public int describeContents(){
        return 0;
    }

}
