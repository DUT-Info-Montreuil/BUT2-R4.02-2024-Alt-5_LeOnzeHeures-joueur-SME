package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.Services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.Services.modele.IJoueurService;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.DTO.InteretDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.utils.exceptions.*;

import java.util.ArrayList;

public class ServiceJoueurImpl implements IJoueurService {

    private ArrayList<JoueurDTO> joueurs;
    public static ServiceJoueurImpl uniqueInstance = null;

    public static ServiceJoueurImpl getUniqueInstance() {
        if (uniqueInstance == null){
            uniqueInstance= new ServiceJoueurImpl();
        }
        return uniqueInstance;
    }

    private ServiceJoueurImpl() {
        joueurs = new ArrayList<JoueurDTO>();
    }

    @Override
    public boolean ajouterJoueur(String prenom, String pseudo, int anneeNaissance, LangueEnum langue, String interets) throws AnneeInvalideException, ChampVideException, NonAlphabetiqueException, NonAlphanumeriqueException, PseudoUtiliseException {

        if (prenom == null || prenom.isEmpty()) {
            throw new ChampVideException("Le prénom ne peut pas être vide.");
        }
        if (!prenom.matches("[a-zA-Z]+")) {
            throw new NonAlphabetiqueException("Le prénom doit contenir uniquement des lettres.");
        }

        if (langue == null) {
            throw new ChampVideException("Le choix de langue préféré ne peut pas être vide.");
        }

        if (pseudo == null || pseudo.isEmpty()) {
            throw new ChampVideException("Le pseudo ne peut pas être vide.");
        }

        if (!pseudo.matches("[a-zA-Z0-9]+")) {
            throw new NonAlphanumeriqueException("Le pseudo doit contenir uniquement des lettres et des chiffres.");
        }

        if (anneeNaissance < 0 ||anneeNaissance > 2024) {
            throw new AnneeInvalideException("L'année de naissance est invalide.");
        }

       for (JoueurDTO joueur : joueurs) {
            if (joueur.getPseudo().equals(pseudo)) {
                throw new PseudoUtiliseException("Le pseudo est déjà utilisé.");
            }
        }

        JoueurDTO nouveauJoueur = new JoueurDTO(prenom, pseudo, anneeNaissance, langue, interets, null)
        joueurs.add(nouveauJoueur);
        return true;
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueurs() throws ChampVideException{
        if (joueurs.size() == 0) {
            throw new ChampVideException("Erreur la liste de joueur est vide");
        } else
            return joueurs;
    }
}
