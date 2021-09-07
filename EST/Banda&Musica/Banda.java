/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EST2;

import java.util.ArrayList;

/**
 *
 * @author G
 */
public class Banda {
    private String nome;
    private ArrayList<Musica> musicasBanda;

    public Banda(String nome) {
        this.nome = nome;
        this.musicasBanda = new ArrayList<Musica>();
    }
    
    public int getNumeroDeMusicas() {
        return musicasBanda.size();
    }
    
    public void addMusica(Musica musica) {
        musicasBanda.add(musica);
    }
    
    public void removeMusica(Musica musica) {
        musicasBanda.remove(musica);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Musica> getMusicasBanda() {
        return musicasBanda;
    }

    public void setMusicasBanda(ArrayList<Musica> musicasBanda) {
        this.musicasBanda = musicasBanda;
    }

    @Override
    public String toString() {
        return "Banda: " + nome + " " + "Quantida de musicas: " + musicasBanda.size();
    }
    
}
