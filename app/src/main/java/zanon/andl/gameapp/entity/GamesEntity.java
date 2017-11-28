package zanon.andl.gameapp.entity;

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

public class GamesEntity {

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

}
