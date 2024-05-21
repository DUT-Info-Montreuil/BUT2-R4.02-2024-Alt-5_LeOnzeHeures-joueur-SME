package org.univ_paris8.iut.montreuil.qdev.tp2024.gr5.LeOnzeHeures.entities.utils.exceptions;

public class NonAlphanumeriqueException extends Exception{
    public NonAlphanumeriqueException(String errorMessage) { //pour le pseudo
        super(errorMessage);
    }
}