package tn.fst.eventsproject.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.fst.eventsproject.entities.Participant;
import tn.fst.eventsproject.repositories.EventRepository;
import tn.fst.eventsproject.repositories.LogisticsRepository;
import tn.fst.eventsproject.repositories.ParticipantRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Active Mockito avec JUnit 5
class EventServicesImplTest {

    @Mock
    private EventRepository eventRepository;

    @Mock
    private ParticipantRepository participantRepository;

    @Mock
    private LogisticsRepository logisticsRepository;

    @InjectMocks
    private EventServicesImpl eventServices;

    @Test
    void testAddParticipant() {
        // 1. Création d'un participant
        Participant participant = new Participant();
        participant.setNom("Tounsi");
        participant.setPrenom("Ahmed");

        // 2. Simulation du comportement du repository
        when(participantRepository.save(participant)).thenReturn(participant);

        // 3. Appel de la méthode à tester
        Participant result = eventServices.addParticipant(participant);

        // 4. Vérifications
        assertNotNull(result); // Vérifie que le résultat n'est pas nul
        verify(participantRepository, times(1)).save(participant); // Vérifie que save() a été appelée une seule fois
    }
}

