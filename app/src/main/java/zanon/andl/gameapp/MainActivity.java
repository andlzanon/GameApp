package zanon.andl.gameapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_games)
    RecyclerView mRecyclerView;

    public RecyclerView.Adapter mAdapterGames;
    private RecyclerView.LayoutManager mLayoutManager;
    private DividerItemDecoration mDividerItemDecoration;
    private ArrayList<GamesEntity> listaEstatica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        ButterKnife.bind(this);
        atualizaLista(listaEstatica);
    }

    private void atualizaLista(ArrayList<GamesEntity> listaEstatica) {
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapterGames = new GamesAdapter(listaEstatica, this);
        mRecyclerView.setAdapter(mAdapterGames);

        //adiciona linha de separacao na RecyclerView
        mDividerItemDecoration = new DividerItemDecoration(
                mRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL
        );
        mRecyclerView.addItemDecoration(mDividerItemDecoration);
    }
}
