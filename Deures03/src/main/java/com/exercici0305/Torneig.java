package com.exercici0305;

import java.util.ArrayList;

public class Torneig {
    private ArrayList<Participant> participants;
    public Torneig(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    public void afegirParticipant(Participant p) {
        participants.add(p);
    }

    public void competir() {
        for (Participant p : participants) {
            if (p instanceof Competidor competidor) {
                competidor.competir();
            }
        }
    }

    public void entrenar() {
        for (Participant p : participants) {
            if (p instanceof Esportista esportistes) {
                esportistes.entrenar();
            }
        }
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public void printParticipants() {
        for (Participant p : participants) {
            System.out.println(p);
        }
    }
}
