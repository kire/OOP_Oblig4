package no.hiof.larseknu.movietime.model;

import java.time.LocalDate;
import java.util.ArrayList;

// En film "er en" produksjon, så derfor har vi satt at den extender Produksjon
// Vi får dermed med alle egenskapene fra Produksjon "gratis"
public class Film extends Produksjon implements Comparable<Film>{

    private static ArrayList<Film> filmene = new ArrayList<>();

    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regisor) {
        // Kaller superkontruktøren (som tilhører Produksjon), vi "sender" da tittel, beskrivelse, spilletid, utgivelsesdato og regisor videre
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regisor);
        filmene.add(this);
    }
    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato) {
        super(tittel,beskrivelse,spilletid,utgivelsesdato);
    }

    @Override
    public String toString() {
        // super - nøkkelordet her er strengt tatt ikke nødvendig, men det gjør det tydelig at metodene tilhører superklassen
        return super.getTittel() + " (" + super.getUtgivelsesdato().getYear() + ")";
    }

    @Override public int compareTo(Film andre) {
        return getTittel().compareTo( andre.getTittel() );
    }
}
