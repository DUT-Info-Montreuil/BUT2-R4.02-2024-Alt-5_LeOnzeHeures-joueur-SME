package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.Services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.Services.modele.IJoueurService;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.DTO.InteretDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.DTO.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.utils.exceptions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public JoueurDTO ajouterJoueur(String prenom, String pseudo, int anneeNaissance, LangueEnum langue, String interets) throws AnneeInvalideException, ChampVideException, NonAlphabetiqueException, NonAlphanumeriqueException, PseudoUtiliseException {

        if (prenom == null || prenom.isEmpty()) {
            throw new ChampVideException("Le prénom ne peut pas être vide.");
        }

        validerPrenom(prenom);

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

        ArrayList<InteretDTO> interetDTOArrayList = convertirStringEnListeInterets(interets);

        JoueurDTO nouveauJoueur = new JoueurDTO(prenom, pseudo, anneeNaissance, langue, interetDTOArrayList);

        if (joueurs.contains(nouveauJoueur)) {
            throw new PseudoUtiliseException("Le pseudo est déjà utilisé.");
        }

        joueurs.add(nouveauJoueur);

        return nouveauJoueur;
    }

    private void validerPrenom(String prenom) throws NonAlphabetiqueException {

        if (prenom.startsWith("-") || prenom.endsWith("-")) {
            throw new NonAlphabetiqueException("Le prénom ne doit pas commencer ni se terminer par un tiret.");
        }

        if (prenom.contains("--")) {
            throw new NonAlphabetiqueException("Le prénom ne doit pas contenir plusieurs tirets consécutifs.");
        }

        if (!prenom.matches("[a-zA-Z-]+")) {
            throw new NonAlphabetiqueException("Le prénom doit contenir uniquement des lettres et peut inclure des tirets.");
        }
    }

    public ArrayList<InteretDTO> convertirStringEnListeInterets(String interetsString) throws NonAlphabetiqueException {
        ArrayList<InteretDTO> interets = new ArrayList<>();
        Set<String> interetSet = new HashSet<>();
        String[] interetsArray = interetsString.split(",");
        for (String interet : interetsArray) {
            String interetTrimmed = interet.trim();

            if (!interetTrimmed.matches("[a-zA-Z]+")) {
                throw new NonAlphabetiqueException("L'intérêt ne peut pas contenir de chiffres : " + interetTrimmed);
            }

            // ajout au set pour ne pas avoir de doublon
            interetSet.add(interetTrimmed);
        }

        for (String interet : interetSet) {
            interets.add(new InteretDTO(interet));
        }

        return interets;
    }


    public ArrayList<JoueurDTO> listerJoueurs() throws ChampVideException{
        if (joueurs.size() == 0) {
            throw new ChampVideException("Erreur la liste de joueur est vide");
        } else
            return joueurs;
    }

}
