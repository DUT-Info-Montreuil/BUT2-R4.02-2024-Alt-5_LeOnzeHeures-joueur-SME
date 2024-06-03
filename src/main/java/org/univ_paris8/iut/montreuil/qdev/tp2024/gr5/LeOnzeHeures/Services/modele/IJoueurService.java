package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.Services.modele;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.DTO.InteretDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.DTO.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.utils.exceptions.*;

import java.util.ArrayList;

public interface IJoueurService {
    public JoueurDTO ajouterJoueur(String prenom,
                                   String pseudo,
                                   int anneeNaissance,
                                   LangueEnum langue,
                                   String interets) throws AnneeInvalideException,
                                                                        ChampVideException,
                                                                        NonAlphabetiqueException,
                                                                        NonAlphanumeriqueException,
                                                                        PseudoUtiliseException;
}
