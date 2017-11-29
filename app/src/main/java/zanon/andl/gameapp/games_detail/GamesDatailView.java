package zanon.andl.gameapp.games_detail;

import zanon.andl.gameapp.entity.GamesEntity;

/**
 * Created by Andre on 28/11/2017.
 */

public interface GamesDatailView {
    //define os campos do xml a partir do game que entra na GamesDetailActivity
    public void setDados(GamesEntity gamesEntity);
    //exibe um toast com uma mensagem de erro
    public void mensagemDeErro(int id);
}
