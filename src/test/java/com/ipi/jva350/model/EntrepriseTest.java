package com.ipi.jva350.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    void testEstDansPlagefalse(){
        // Given
        Entreprise e = new Entreprise();
        LocalDate dateDebut = LocalDate.of(2020, 4, 4);
        LocalDate dateFin = LocalDate.of(2021, 4, 4);
        // When
        boolean res = e.estDansPlage(LocalDate.of(2021, 4, 4),dateDebut,dateFin);
        // Then
        Assertions.assertFalse(res);
    }
 
    @ParameterizedTest(name= "Le jour {0} est férie: {1}")
    @CsvSource({
        "2021-01-01, true",
        "2021-05-01, true",
        "2021-07-14, true",
        "2021-11-01, true",
        "2021-12-25, true",
        "2021-04-01, false",
        "2021-06-01, false",
        "2021-08-14, false",
        "2021-10-01, false",
        "2021-11-25, false"
    })
    void testestJourFerieTrue(LocalDate jourFerie, boolean expected){
        assertEquals(expected, Entreprise.estJourFerie(jourFerie));
     }

     @ParameterizedTest(name = "Pour la date {0}, le premier jour de l'année de congés est {1}")
     @CsvSource({
         "2023-07-15, 2023-06-01",
         "2023-03-15, 2022-06-01",
         "2024-06-01, 2024-06-01",
         "2024-05-31, 2023-06-01"
     })
     void testGetPremierJourAnneeDeConges(String dateStr, String expectedStr) {
         LocalDate date = dateStr == null ? null : LocalDate.parse(dateStr);
         LocalDate expected = expectedStr == null ? null : LocalDate.parse(expectedStr);
         assertEquals(expected, Entreprise.getPremierJourAnneeDeConges(date));
     }
}
