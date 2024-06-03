package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.DTO;

import java.util.Objects;

public class InteretDTO {
    protected String nom;

    public InteretDTO(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InteretDTO that = (InteretDTO) o;
        return Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
