package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.DTO;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.enums.LangueEnum;

import java.util.ArrayList;
import java.util.Objects;

public class JoueurDTO {
    private String prenom;
    private String pseudo;
    private int anneeNaissance;
    private LangueEnum langue;
    private ArrayList<InteretDTO> interets;
    private ArrayList<StatistiquePartieDTO> stats;

    public JoueurDTO(String prenom, String pseudo, int anneeNaissance, LangueEnum langue, ArrayList<InteretDTO> interets, ArrayList<StatistiquePartieDTO> stats) {
        this.prenom         = prenom;
        this.pseudo         = pseudo;
        this.anneeNaissance = anneeNaissance;
        this.langue         = langue;
        this.interets       = interets;
        this.stats = stats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoueurDTO joueur = (JoueurDTO) o;
        return Objects.equals(pseudo, joueur.pseudo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pseudo);
    }

    public String getPrenom() {        return prenom;    }
    public String getPseudo() {        return pseudo;    }
    public int getAnneeNaissance() {        return anneeNaissance;    }
    public LangueEnum getLangue() {        return langue;    }
    public ArrayList<InteretDTO> getInterets() {        return interets;    }
    public ArrayList<StatistiquePartieDTO> getStats() {        return stats;    }

    public void setPrenom(String prenom) {this.prenom = prenom; }
    public void setPseudo(String pseudo) { this.pseudo = pseudo;}
    public void setAnneeNaissance(int anneeNaissance) {this.anneeNaissance = anneeNaissance;}
    public void setLangue(LangueEnum langue) { this.langue = langue; }



}

