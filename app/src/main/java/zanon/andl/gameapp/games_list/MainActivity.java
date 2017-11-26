package zanon.andl.gameapp.games_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import zanon.andl.gameapp.R;
import zanon.andl.gameapp.entity.GamesEntity;
import zanon.andl.gameapp.games_detail.GamesDetail;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.rv_games)
    RecyclerView mRecyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public GamesAdapter mAdapterGames;
    private RecyclerView.LayoutManager mLayoutManager;
    private DividerItemDecoration mDividerItemDecoration;
    private ArrayList<GamesEntity> listaEstatica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.tokengames);

        //lista estatica para teste de funcionamento da RecyclerView
        listaEstatica = new ArrayList<>();
        listaEstatica.add(new GamesEntity("Super Mario Odyssey", "10/02/2017"));
        listaEstatica.add(new GamesEntity("Mario Kart", "05/06/2017"));
        listaEstatica.add(new GamesEntity("Persona 5", "09/02/2017"));
        listaEstatica.add(new GamesEntity("Zelda Breath of the Wild", "01/03/2017"));
        listaEstatica.add(new GamesEntity("Pokemon Sun and Moon", "07/04/2017"));
        listaEstatica.add(new GamesEntity("The Last of Us", "06/07/2017"));
        listaEstatica.add(new GamesEntity("The Last of Us", "06/07/2017"));
        listaEstatica.add(new GamesEntity("The Last of Us", "06/07/2017"));
        listaEstatica.add(new GamesEntity("The Last of Us", "06/07/2017"));
        listaEstatica.add(new GamesEntity("The Last of Us", "06/07/2017"));
        listaEstatica.add(new GamesEntity("The Last of Us", "06/07/2017"));
        listaEstatica.add(new GamesEntity("The Last of Us", "06/07/2017"));
        listaEstatica.add(new GamesEntity("The Last of Us", "06/07/2017"));
        listaEstatica.add(new GamesEntity("The Last of Us", "06/07/2017"));

        atualizaLista(listaEstatica);
    }

    private void atualizaLista(ArrayList<GamesEntity> listaEstatica) {
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapterGames = new GamesAdapter(listaEstatica, this);
        mAdapterGames.setOnRecyclerItemClick(new OnRecyclerItemClick() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, GamesDetail.class);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(mAdapterGames);

        //adiciona linha de separacao na RecyclerView
        mDividerItemDecoration = new DividerItemDecoration(
                mRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL
        );
        mRecyclerView.addItemDecoration(mDividerItemDecoration);
    }
}
