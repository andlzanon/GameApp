package zanon.andl.gameapp.games_detail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import zanon.andl.gameapp.R;
import zanon.andl.gameapp.entity.GamesEntity;
import zanon.andl.gameapp.games_list.MainActivity;

import static zanon.andl.gameapp.games_list.MainActivity.EXTRA_GAME;

/**
 * Classe extende a YouTubeBase Activity devido a API do YouTube
 */
public class GamesDetail extends YouTubeBaseActivity implements GamesDatailView{

    //bindings de todos os campos do xml
    @BindView(R.id.detailFoto)
    CircleImageView detailFoto;

    @BindView(R.id.detailNome)
    TextView detailNome;

    @BindView(R.id.detailData)
    TextView detailData;

    @BindView(R.id.detailPlataformas)
    TextView detailPlataformas;

    @BindView(R.id.youTubePlayer)
    YouTubePlayerView youTubePlayer;

    @BindView(R.id.backButton)
    ImageView backButton;

    GamesDatailPresenter gamesDatailPresenter;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_detail);

        ButterKnife.bind(this);

        //recebe o game da activity anterior, ou seja, da lista
        //mais especificamente do game que o usuário tocar
        Intent intent = getIntent();
        GamesEntity game = intent.getParcelableExtra(EXTRA_GAME);

        //define o presenter
        gamesDatailPresenter = new GamesDatailPresenter(this);
        gamesDatailPresenter.setCampos(game);

        //preprara a url para ser consumida pela API do YouTube
        //para a API do Youtube e necessario somente a string apos o "="
        //para isso foi utilizado o medoto slip em que se separa a String
        //antes do = e depois do =
        //para o video somente e necessario depois do igual, logo, a ultima posicao do vetor
        String url = game.getTrailer();
        String [] url_separada = url.split("=");
        final String final_url = url_separada[url_separada.length - 1];
        // a youTube Data API, utiliza de um listener para inicializar o carregamente do video
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(final_url);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        //initialize passa como parametro a chave que foi criada quando e cadastrado um projeto e sua API (no caso a do YouTube) no Google Developer Console.
        //Incialmente criou-se um apk assinado com uma chave, utilizou-se o comando keytool -list -v -keystore C:\Android\keys\keysGameApp.jks
        //para pegar a fingerpritn SHA1, que e cadastrada como certificao novamente no Google Developer Console, jutnamente ao pacote da aplicacao
        youTubePlayer.initialize("AIzaSyBO-7-ycpzNfraxgrQ9qPK9qvfu50PmN_g", onInitializedListener);
    }

    /**
     * Funcao responsavel por ser o back button da Toolbar ja que
     * a YouTubeBaseActivity nao suporta
     */
    @OnClick(R.id.backButton)
    public void onClick(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Seta os campos do xml com o gameEntity
     * @param gamesEntity que e recebido pela acitivity
     */
    @Override
    public void setDados(GamesEntity gamesEntity) {
        Picasso.with(this)
                .load(gamesEntity.getImage())
                .centerCrop()
                .fit()
                .into(detailFoto);

        detailNome.setText(gamesEntity.getName());
        detailData.setText(gamesEntity.getReleaseDate());
        String plataformas = gamesDatailPresenter.youTubeUrl(gamesEntity.getPlatforms());
        detailPlataformas.setText(plataformas);
    }

    /**
     * Funcao para mostrar o toast de erro
     * @param id da string que se quer mostrar o toast
     */
    @Override
    public void mensagemDeErro(int id) {
        Toast.makeText(this, getString(id), Toast.LENGTH_SHORT).show();
    }
}
