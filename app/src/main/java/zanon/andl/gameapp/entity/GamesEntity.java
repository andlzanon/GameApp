package zanon.andl.gameapp.entity;

import java.util.ArrayList;

/**
 * Created by Andre on 26/11/2017.
 */

public class GamesEntity {

    private int id;
    private String imagem;
    private String nome;
    private String data;
    private String trailer;
    private ArrayList<String> plataformas;

    public GamesEntity(String nome, String data){
        this.nome = nome;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getImagem() {
        return imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getTrailer() {
        return trailer;
    }

    public ArrayList<String> getPlataformas() {
        return plataformas;
    }
}
