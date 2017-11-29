package zanon.andl.gameapp.games_detail;

import java.util.List;

import zanon.andl.gameapp.R;
import zanon.andl.gameapp.entity.GamesEntity;

/**
 * Created by Andre on 28/11/2017.
 */

public class GamesDatailPresenter {

    //gamesView responsavel por nao deixar com que
    //a camada de visulizacao fique "exposta"
    GamesDatailView gamesDatailView;

    /**
     * Construtor padrao
     * @param gamesDatailView que servira de interface entre camada logica e de visualizacao
     */
    public GamesDatailPresenter(GamesDatailView gamesDatailView){
        this.gamesDatailView = gamesDatailView;
    }

    /**
     * Define a imagem e os textos conforme o Gameentity que vem da acitivity anterior
     * @param gamesEntity
     */
    public void setCampos(GamesEntity gamesEntity){
        if(gamesEntity != null)
            gamesDatailView.setDados(gamesEntity);
        else
            gamesDatailView.mensagemDeErro(R.string.msg_erro);
    }

    /**
     *
     * @param plataformas lista de plataformas do jogo
     * @return url somente com o texto depois do = do campo do JSON
     */
    public String youTubeUrl(List<String> plataformas){
        String StringPlataformas = "";
        for(int i = 0; i < plataformas.size(); i++){
            if(i == 0)
                StringPlataformas = plataformas.get(i);
            else
                StringPlataformas = StringPlataformas + ", " + plataformas.get(i);
        }

        return StringPlataformas;
    }
}
