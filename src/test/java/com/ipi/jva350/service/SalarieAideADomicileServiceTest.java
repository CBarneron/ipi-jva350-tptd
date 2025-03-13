package com.ipi.jva350.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ipi.jva350.repository.SalarieAideADomicileRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

@ExtendWith(MockitoExtension.class)
public class SalarieAideADomicileServiceTest {
   
    @InjectMocks
    private SalarieAideADomicileService salarieAideADomicileService;

    @Mock
    private SalarieAideADomicileRepository salarieAideADomicileRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculeLimiteEntrepriseCongesPermis() {
        // Arrange
        LocalDate moisEnCours = LocalDate.of(2025, 3, 1);
        double congesPayesAcquisAnneeNMoins1 = 20.0;
        LocalDate moisDebutContrat = LocalDate.of(2020, 1, 1);
        LocalDate premierJourDeConge = LocalDate.of(2025, 7, 1);
        LocalDate dernierJourDeConge = LocalDate.of(2025, 7, 15);

        // Configurez les mocks si nécessaire
        when(salarieAideADomicileRepository.partCongesPrisTotauxAnneeNMoins1()).thenReturn(0.5);

        // Act
        long result = salarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(
                moisEnCours, congesPayesAcquisAnneeNMoins1, moisDebutContrat, premierJourDeConge, dernierJourDeConge);

        // Assert
        long expectedValue = 8;
        assertEquals(expectedValue, result);
    }
    
}
