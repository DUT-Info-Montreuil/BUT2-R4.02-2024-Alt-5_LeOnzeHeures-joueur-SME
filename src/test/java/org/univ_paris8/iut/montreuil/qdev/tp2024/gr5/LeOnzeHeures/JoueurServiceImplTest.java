package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.Services.modele.IJoueurService;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.DTO.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.utils.exceptions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JoueurServiceImplTest {

        private IJoueurService serviceJoueurBeanImpl;

        @BeforeEach
        void setUp(TestInfo testInfo) throws Exception {

            serviceJoueurBeanImpl = null;

            System.out.println("test " + testInfo.getDisplayName());
        }

        @Test
        void ajouterJoueurSimpleOKTest() {
            // MOCK à supprimer lors de l'ajout du vrai service
            serviceJoueurBeanImpl = new JoueurMockTemp();


            JoueurDTO joueurAttendu = new JoueurDTO("joueurSimple", "pseudoSimple", 2003, LangueEnum.FRANCAIS, "bowling, manga");
            try {
                JoueurDTO joueurResultat = serviceJoueurBeanImpl.ajouterJoueur("joueurSimple", "pseudoSimple", 2003, LangueEnum.FRANCAIS, "bowling, manga");
                System.out.println("JoueurAttendu : "+joueurAttendu);
                System.out.println("joueurResultat: "+joueurResultat);
                assertEquals(joueurAttendu,joueurResultat,"Insertion d'un joueur classique");
            }
            catch (Exception e) {
                System.out.println("Erreur inattendu dans le test ajouterJoueurSimpleOKTest");
            }
        }

        @Test
        void erreurPrenomInvalide() {
            // MOCK à supprimer lors de l'ajout du vrai service
            serviceJoueurBeanImpl = new JoueurMockTemp();

            try {
                NonAlphabetiqueException except = assertThrows(
                        NonAlphabetiqueException.class,
                        () -> serviceJoueurBeanImpl.ajouterJoueur("hackx456", "pseudoSimple", 2003, LangueEnum.FRANCAIS, "bowling, manga")
                );

                System.out.println("erreur attendue : NonAlphabetiqueException" );
                System.out.println("ereur throw :"+ except);
            }
            catch (Exception e) {
                System.out.println("Erreur inattendu dans le test erreurPrenom invalide");
            }
        }

        @Test
        void erreurPseudoInvalide() {
            // MOCK à supprimer lors de l'ajout du vrai service
            serviceJoueurBeanImpl = new JoueurMockTemp();
            try {
                NonAlphanumeriqueException except = assertThrows(
                        NonAlphanumeriqueException.class,
                        () -> serviceJoueurBeanImpl.ajouterJoueur("harmon", "PseudoInvalide##",  2003, LangueEnum.FRANCAIS, "bowling, manga")
                );

                System.out.println("erreur attendue : NonAlphanumériqueException" );
                System.out.println("ereur throw :"+ except);
            }
            catch (Exception e) {
                System.out.println("Erreur inattendu dans le test erreurPseudoInvalide");
            }
        }

        @Test
        void erreurPseudoUtilise() {
            // MOCK à supprimer lors de l'ajout du vrai service
            serviceJoueurBeanImpl = new JoueurMockTemp();

    try {
                serviceJoueurBeanImpl.ajouterJoueur("armand", "PseudoPeuOriginal", 2003, LangueEnum.FRANCAIS, "bowling, manga");
                PseudoUtiliseException except = assertThrows(
                        PseudoUtiliseException.class,
                        () -> serviceJoueurBeanImpl.ajouterJoueur("harmon", "PseudoPeuOriginal", 2003, LangueEnum.FRANCAIS, "bowling, manga")
                );

                System.out.println("erreur attendue : PseudoUtiliséException" );
                System.out.println("ereur throw :"+ except);
            }
            catch (Exception e) {
                System.out.println("Erreur inattendu dans le test erreurPseudoUtilise");
            }
        }

        @Test
        void erreurAnneeInvalide() {
            // MOCK à supprimer lors de l'ajout du vrai service
            serviceJoueurBeanImpl = new JoueurMockTemp();

            try {
                AnneeInvalideException except = assertThrows(
                        AnneeInvalideException.class,
                        () ->             serviceJoueurBeanImpl.ajouterJoueur("armand", "PseudoPeuOriginal", 2035, LangueEnum.FRANCAIS, "bowling, manga"));

                System.out.println("erreur attendue : AnneeInvalideException" );
                System.out.println("ereur throw :"+ except);
            }
            catch (Exception e) {
                System.out.println("Erreur inattendu dans le test anneeInvalideException");
            }
        }

        @Test
        void erreurPrenomVide() {
            // MOCK à supprimer lors de l'ajout du vrai service
            serviceJoueurBeanImpl = new JoueurMockTemp();

            try {
                ChampVideException except = assertThrows(
                        ChampVideException.class,
                        () -> serviceJoueurBeanImpl.ajouterJoueur("", "XxDarkSasukexX", 2003, LangueEnum.FRANCAIS, "bowling, manga")
                );

                System.out.println("erreur attendue : ChampVideException" );
                System.out.println("ereur throw :"+ except);
            }
            catch (Exception e) {
                System.out.println("Erreur inattendu dans le test erreurPrneomVide");
            }
        }
        @Test
        void erreurPseudoVide() {
                // MOCK à supprimer lors de l'ajout du vrai service
                serviceJoueurBeanImpl = new JoueurMockTemp();

                try {
                    ChampVideException except = assertThrows(
                            ChampVideException.class,
                            () -> serviceJoueurBeanImpl.ajouterJoueur("armand", "", 2003, LangueEnum.FRANCAIS, "bowling, manga")
                    );

                    System.out.println("erreur attendue : ChampVideException" );
                    System.out.println("ereur throw :"+ except);
                }
                catch (Exception e) {
                    System.out.println("Erreur inattendu dans le test erreurPseudoVide");
                }
            }

    @Test
    void erreurLangueVide() {
        // MOCK à supprimer lors de l'ajout du vrai service
        serviceJoueurBeanImpl = new JoueurMockTemp();

        try {
            ChampVideException except = assertThrows(
                    ChampVideException.class,
                    () -> serviceJoueurBeanImpl.ajouterJoueur("armand", "XxDarkSasukexX", 2003 , null, "bowling, manga")
            );

            System.out.println("erreur attendue : ChampVideException" );
            System.out.println("ereur throw :"+ except);
        }
        catch (Exception e) {
            System.out.println("Erreur inattendu dans le test erreurPrneomVide");
        }
    }
        @Test
        void testInteretsVide() {
            // MOCK à supprimer lors de l'ajout du vrai service
            serviceJoueurBeanImpl = new JoueurMockTemp();

            JoueurDTO j = new JoueurDTO("armand", "XxDarSasukexX", 2003, LangueEnum.FRANCAIS, "");
            try {
                JoueurDTO j2 = serviceJoueurBeanImpl.ajouterJoueur("armand", "XxDarSasukexX", 2003, LangueEnum.FRANCAIS, "");

                System.out.println("joueur attendu :" + j );
                System.out.println("joueur trouvé :" + j2);
                assertEquals(j,j2);
            }
            catch (Exception e) {
                System.out.println("Erreur inattendu dans le test testInteretsVide");
            }
        }
}


