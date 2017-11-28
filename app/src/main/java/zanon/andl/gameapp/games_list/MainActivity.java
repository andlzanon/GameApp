package zanon.andl.gameapp.games_list;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zanon.andl.gameapp.R;
import zanon.andl.gameapp.entity.GamesEntity;
import zanon.andl.gameapp.games_detail.GamesDetail;

public class MainActivity extends AppCompatActivity implements GamesView{

    //binding com butterknife
    @BindView(R.id.rv_games)
    RecyclerView mRecyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    //declaracoes
    public GamesAdapter mAdapterGames;
    private RecyclerView.LayoutManager mLayoutManager;
    private DividerItemDecoration mDividerItemDecoration;
    private GamePresenter gamePresenter;
    private List<GamesEntity> gameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //seta a action bar no topo da tela
        setSupportActionBar(toolbar);
        //define o nome da action bar
        getSupportActionBar().setTitle(R.string.tokengames);

        if(savedInstanceState != null)
            gameList = savedInstanceState.getParcelableArrayList("games");
        else
            gameList = new ArrayList<>();

        //seta um adapter default para nao acusar erro de RecyclerView sem adapter
        mRecyclerView.setAdapter(new GamesAdapter(gameList, this));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //adiciona linha de separacao na RecyclerView
        mDividerItemDecoration = new DividerItemDecoration(
                mRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL
        );
        mRecyclerView.addItemDecoration(mDividerItemDecoration);

        //inicia um presenter
        gamePresenter = new GamePresenter(this);
        //acessa os dados da web
        gamePresenter.acessaDados();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("games", (ArrayList) gameList);
    }


    /**
     * Funcao que define a recyclerView e coloca a lista jogos para ser exibida
     * @param lista de jogos recebidas pela web para a RecyclerView
     */
    @Override
    public void atualizaLista(List<GamesEntity> lista) {

        gameList = lista;

        mAdapterGames = new GamesAdapter(gameList, this);
        mAdapterGames.setOnRecyclerItemClick(new OnRecyclerItemClick() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, GamesDetail.class);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mAdapterGames);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    /**
     * Funcao que mostra mensagem de erro
     * @param mensagem a ser exibida pelo toast
     */
    @Override
    public void mensagemDeErro(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * @param id da String dos Recursos que se quer acessar
     * @return String correspondente ao id da classe R
     */
    @Override
    public String getTextFromR(int id){
        return getResources().getString(id);
    }
}
