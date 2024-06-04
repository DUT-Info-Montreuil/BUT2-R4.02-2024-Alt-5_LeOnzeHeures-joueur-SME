package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.Services.modele.IJoueurService;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.DTO.InteretDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.DTO.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.utils.exceptions.*;

import java.util.ArrayList;

public class JoueurMockTemp implements IJoueurService {

    public JoueurMockTemp() {
    }

    @Override
    public JoueurDTO ajouterJoueur(String nom, String pseudo, int anneeDeNaissance, LangueEnum langue, String centreDInteretListe) throws AnneeInvalideException,
                                                                                                                    ChampVideException,NonAlphabetiqueException,
                                                                                                                    NonAlphanumeriqueException, PseudoUtiliseException
    {
        return new JoueurDTO("joueurSimple", "pseudoSimple", 2003,
                LangueEnum.FRANCAIS, centreDInteretListe);
    }
}
