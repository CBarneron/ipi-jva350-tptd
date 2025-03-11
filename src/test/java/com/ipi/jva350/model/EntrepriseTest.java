package com.ipi.jva350.model;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntrepriseTest {
    
    @Test
    void testEstDansPlagetrue(){
        // Given
        Entreprise e = new Entreprise();
        LocalDate dateDebut = LocalDate.of(2020, 4, 4);
        LocalDate dateFin = LocalDate.of(2022, 4, 4);
        // When
        boolean res = e.estDansPlage(LocalDate.of(2021, 4, 4),dateDebut,dateFin);
        // Then
        Assertions.assertTrue(res);
    }
}
