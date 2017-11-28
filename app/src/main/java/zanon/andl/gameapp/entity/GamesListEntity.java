package zanon.andl.gameapp.entity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Classe de lista de jogos
 */
public class GamesListEntity {

    //serializable e games pois e o vetor definito no JSON
    @SerializedName("games")
    @Expose
    private List<GamesEntity> games = null;

    public List<GamesEntity> getGames() {
        return games;
    }

    public void setGames(List<GamesEntity> games) {
        this.games = games;
    }

}
