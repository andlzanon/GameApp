package zanon.andl.gameapp.network;

import retrofit2.Call;
import retrofit2.http.GET;
import zanon.andl.gameapp.entity.GamesListEntity;

/**
 * Created by Andre on 27/11/2017.
 */

public interface GamesService {

    /**
     * Assinatura Retrofit para acessar a URL
     * @return lista de jogos conforme o arquivo JSON
     */
    @GET("s/1b7jlwii7jfvuh0/games")
    Call<GamesListEntity> getGames();
}
