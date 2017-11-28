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


public class GamesDetail extends YouTubeBaseActivity {

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

    private YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_detail);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        GamesEntity game = intent.getParcelableExtra(EXTRA_GAME);

        if(game != null){
            Picasso.with(this)
                    .load(game.getImage())
                    .centerCrop()
                    .fit()
                    .into(detailFoto);

            detailNome.setText(game.getName());
            detailData.setText(game.getReleaseDate());
            String plataformas = "";
            for(int i = 0; i < game.getPlatforms().size(); i++){
                if(i == 0)
                    plataformas = game.getPlatforms().get(i);
                else
                    plataformas = plataformas + ", " + game.getPlatforms().get(i);
            }
            detailPlataformas.setText(plataformas);
        }
        else{
            Toast.makeText(this, getString(R.string.msg_erro), Toast.LENGTH_SHORT).show();
        }

        String url = game.getTrailer();
        String [] url_separada = url.split("=");
        final String final_url = url_separada[url_separada.length - 1];
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(final_url);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayer.initialize("AIzaSyBO-7-ycpzNfraxgrQ9qPK9qvfu50PmN_g", onInitializedListener);
    }

    @OnClick(R.id.backButton)
    public void onClick(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
