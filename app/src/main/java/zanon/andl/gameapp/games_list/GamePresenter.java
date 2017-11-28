package zanon.andl.gameapp.games_list;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zanon.andl.gameapp.R;
import zanon.andl.gameapp.entity.GamesListEntity;
import zanon.andl.gameapp.network.ListGamesApi;

/**
 * Created by Andre on 27/11/2017.
 */

public class GamePresenter {

    //interface do MVP que nao deixa acessar todos os metodos
    //da view, somente os necessarios
    private GamesView gamesView;

    /**
     * Construtor padrao
     * @param gamesView da camada de visualizacao do MVP
     */
    public GamePresenter(GamesView gamesView){
        this.gamesView = gamesView;
    }

    /**
     * Funcao que acessa os dados da web
     */
    public void acessaDados(){
        //instancia a api
        final ListGamesApi listGamesApi = ListGamesApi.getInstance();
        //chama o metdod getGames que faz o GET na API com o arquivo JSON
        listGamesApi.getGames().enqueue(new Callback<GamesListEntity>() {
            //metodo de resposta
            @Override
            public void onResponse(Call<GamesListEntity> call, Response<GamesListEntity> response) {
                GamesListEntity gamesListEntity = response.body();
                //se a lista nao for vazia, ou seja, se a resposta foi bem sucedida
                if(gamesListEntity != null){
                    gamesView.atualizaLista(gamesListEntity.getGames());
                }
                //senao mostra mensagem de erro
                else
                    gamesView.mensagemDeErro(gamesView.getTextFromR(R.string.msg_erro));
            }
            //esse método e quando nao foi possivel acessar o servidor web
            @Override
            public void onFailure(Call<GamesListEntity> call, Throwable t) {
                gamesView.mensagemDeErro(gamesView.getTextFromR(R.string.msg_erro));
            }
        });
    }
}
