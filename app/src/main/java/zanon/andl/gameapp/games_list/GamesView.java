package zanon.andl.gameapp.games_list;

import android.widget.ProgressBar;

import java.util.List;

import zanon.andl.gameapp.entity.GamesEntity;

/**
 * Created by Andre on 27/11/2017.
 */

public interface GamesView {
    //funcao que atualiza a lista com os dados da API
    public void atualizaLista(List<GamesEntity> lista);
    //mostra toast com mensagem de erro
    public void mensagemDeErro(String mensagem);
    //acessa os recursos do app para acessar uma String a partide do id da classe R
    public String getTextFromR(int id);
    //incia a animacao da progressBar
    public void initProgressBar();
    //para a animacao da progressBar
    public void stopProgressBar();
}
