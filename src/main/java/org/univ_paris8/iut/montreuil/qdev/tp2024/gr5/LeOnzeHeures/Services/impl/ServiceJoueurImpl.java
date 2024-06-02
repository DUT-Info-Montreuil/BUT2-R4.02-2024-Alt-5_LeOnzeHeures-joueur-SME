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
    public boolean ajouterJoueur(String prenom, String pseudo, int anneeNaissance, LangueEnum langue, ArrayList<InteretDTO> interets) throws AnneeInvalideException, ChampVideException, NonAlphabetiqueException, NonAlphanumeriqueException, PseudoUtiliseException {


        return false;
    }


}
