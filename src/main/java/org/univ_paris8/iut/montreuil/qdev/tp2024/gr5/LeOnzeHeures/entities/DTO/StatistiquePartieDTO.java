package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.DTO;

public class StatistiquePartieDTO {
    protected int score;
    protected int temps; // en secondes

    public StatistiquePartieDTO(int score, int temps) {
        this.score = score;
        this.temps = temps;
    }

    public int getScore() {
        return score;
    }

    public int getTemps() {
        return temps;
    }
}
