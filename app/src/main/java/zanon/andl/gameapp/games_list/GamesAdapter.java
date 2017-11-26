package zanon.andl.gameapp.games_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zanon.andl.gameapp.R;
import zanon.andl.gameapp.entity.GamesEntity;

/**
 * Created by Andre on 26/11/2017.
 */

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder>  {

    OnRecyclerItemClick onRecyclerItemClick;

    /**
     * GamesViewHolder e a classe que representa cada item da lista
     */
    public class GamesViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.nomeGame)
        TextView txtNome;

        @BindView(R.id.dataGame)
        TextView txtData;

        public GamesViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        @OnClick(R.id.item_recycler)
        void onItemClick(View view){
            if(onRecyclerItemClick != null){
                onRecyclerItemClick.onClick(view, getAdapterPosition());
            }
        }
    }

    private ArrayList<GamesEntity> gamesList;
    private Context context;

    /**
     * Construtor para o Adapter
     * @param gamesList lista de Games
     * @param context contexto da activity
     */
    public GamesAdapter(ArrayList<GamesEntity> gamesList, Context context){
        this.gamesList = gamesList;
        this.context = context;
    }

    /**
     * Cria uma instancia de layout para o item da lista
     * @param parent layout pai da ViewHolder
     * @param viewType
     * @return
     */
    @Override
    public GamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_item, parent, false);
        GamesViewHolder contatosViewHolder = new GamesViewHolder(layout);
        return contatosViewHolder;
    }

    /**
     *  Faz os bindigs do layout criado pela onCreateViewHolder
     * @param holder item conforme definido na classe
     * @param position posicao do holder, ou seja em que posicao da lista sera exibido
     */
    @Override
    public void onBindViewHolder(GamesViewHolder holder, int position) {
        GamesEntity gamesEntity  = gamesList.get(position);
        holder.txtNome.setText(gamesEntity.getNome());
        holder.txtData.setText(gamesEntity.getData());
    }

    /**
     *
     * @return quantidade de itens a serem mostrados
     */
    @Override
    public int getItemCount() {
        return gamesList.size();
    }

    public void setOnRecyclerItemClick(OnRecyclerItemClick onRecyclerItemClick){
        this.onRecyclerItemClick = onRecyclerItemClick;
    }
}
