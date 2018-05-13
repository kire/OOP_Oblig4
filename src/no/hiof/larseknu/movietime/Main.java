package no.hiof.larseknu.movietime;

import no.hiof.larseknu.movietime.model.*;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        lagOgSkrivUtInformasjonOmEtParFilmer();
        lagOgSkrivUtInformasjonOmStrangerThings();
        doAThing();
    }

    private static void lagOgSkrivUtInformasjonOmEtParFilmer() {
        // Lager og instansierer objektet frankDarabont av typen Person (som vi senere setter som regisor)
        Person frankDarabont = new Person("Frank", "Darabont");
        // Lager og instansierer objektet leeUnkrich av typen Person (som vi senere setter som regisor)
        Person leeUnkrich = new Person("Lee", "Unkrich");

        // Lager og instansierer objektet shawshankRedemption av typen Film
        Film shawshankRedemption = new Film("The Shawshank Redemption", "Two imprisoned men bond over a number of years...",142, LocalDate.of(1994, 9, 22), frankDarabont);
        // Lager og instansierer objektet coco av typen Film
        Film coco = new Film("Coco", "About aspiring musician Miguel...", 105, LocalDate.of(2017, 11, 21), leeUnkrich);

        // Lager og instansierer objekteter av typen Rolle
        Rolle andyDufrese = new Rolle("Andy", "Dufrese", new Person("Tim", "Robbins"));
        Rolle ellisBoydRedding = new Rolle("Ellis Boyd", "Redding", new Person("Morgan", "Freeman", LocalDate.of(1937, 6, 1)));

        shawshankRedemption.leggTilEnRolle(andyDufrese);
        shawshankRedemption.leggTilEnRolle(ellisBoydRedding);

        System.out.println("******************************");
        System.out.println("            Filmer");
        System.out.println("------------------------------");
        System.out.println(shawshankRedemption.toString() + " - regisert av " + shawshankRedemption.getRegisor().hentNavn());
        for (Rolle enRolle : shawshankRedemption.getRolleListe())
            System.out.println(enRolle.toString());
        System.out.println("------------------------------");
        System.out.println(coco.toString() + " - regisert av " + coco.getRegisor().hentNavn());
    }

    private static void lagOgSkrivUtInformasjonOmStrangerThings() {
        // Lager og instansierer objektet frankDarabont av typen Person (som vi senere setter som regisor)
        Person mattDuffer = new Person("Matt", "Duffer");

        // Lager og instansierer objektet strangerThings av typen TvSerie
        TvSerie strangerThings = new TvSerie("Stranger Things", "When a young boy disappears, his mother, a police chief, and his friends must confront terrifying forces in order to get him back.", LocalDate.of(2016, 7,15));

        // Lager og instansierer noen objekter av typen Episode
        Episode episode1 = new Episode(1, 1, "Chapter One: The Vanishing of Will Byers", "Will vanishes", 50, LocalDate.of(2016, 7, 15), mattDuffer);
        Episode episode2 = new Episode(2, 1, "Chapter Two: The Weirdo on Maple Street", "The weirdo arrives", 50, LocalDate.of(2016, 7, 15), mattDuffer);
        Episode episode3 = new Episode(3, 1, "Chapter Three: Holly, Jolly", "Holy jolly", 50, LocalDate.of(2016, 7, 15), mattDuffer);
        Episode episode4 = new Episode(4, 1, "Chapter Four: The Body", "A body is found", 50, LocalDate.of(2016, 7, 15), mattDuffer);

        // Legger til episodeobjektene til tvserieobjektet strangerThings
        strangerThings.leggTilEpisode(episode1);
        strangerThings.leggTilEpisode(episode2);
        strangerThings.leggTilEpisode(episode3);
        strangerThings.leggTilEpisode(episode4);

        // Instansierer noen objekter av typen Episode og legger de direkte inn i TvSerie objektet strangerThings
        strangerThings.leggTilEpisode(new Episode(1, 2, "Chapter One: MADMAX", "Max is mad", 50, LocalDate.of(2017, 10, 27), mattDuffer));
        strangerThings.leggTilEpisode(new Episode(2, 2, "Chapter Two: Trick or Treat, Freak", "Halloween is up", 50, LocalDate.of(2017, 10, 27), mattDuffer));
        strangerThings.leggTilEpisode(new Episode(3, 2, "Chapter Three: The Pollywog", "Little creatures...", 50, LocalDate.of(2017, 10, 27), mattDuffer));


        // Lager en liste som skal holde på alle hovedrollene vi lager
        ArrayList<Rolle> hovedRollerStrangerThings = new ArrayList<>();

        // Lager og legger til roller og legger de i listen med en gang
        hovedRollerStrangerThings.add(new Rolle("Joyce", "Byers", new Person("Winona", "Ryder")));
        hovedRollerStrangerThings.add(new Rolle("Jim", "Hopper", new Person("David", "Harbour")));
        hovedRollerStrangerThings.add(new Rolle("Mike", "Wheeler", new Person("Finn", "Wolfhard")));
        hovedRollerStrangerThings.add(new Rolle("Eleven", "", new Person("Millie Bobby", "Brown")));

        // lager en liste som holder på sekundærrollene vi lager
        ArrayList<Rolle> flereRollerStrangerThings = new ArrayList<>();

        // Lager og legger til roller og legger de i listen med en gang
        flereRollerStrangerThings.add(new Rolle("Dustin", "Henderson", new Person("Gaten", "Matarazzo")));
        flereRollerStrangerThings.add(new Rolle("Lucas", "Sinclair", new Person("Caleb", "McLaughlin")));


        // Henter ut en liste med episoder fra objektet strangerThings
        ArrayList<Episode> episodeListe = strangerThings.getEpisodeListe();

        for (Episode enEpisode : episodeListe) {
            // Legger til listen med hovedroller til alle epsioder
            enEpisode.leggTilMangeRoller(hovedRollerStrangerThings);
            // Legger bare til listen med flere roller i den første sesongen
            if (enEpisode.getSesongNummer() == 1)
                enEpisode.leggTilMangeRoller(flereRollerStrangerThings);
        }


        System.out.println("******************************");

        // Skriver ut tvserie objektet (toString blir kalt)
        System.out.println(strangerThings);
        System.out.println("-----------Episoder-----------");
        // Går gjennom alle episoder og skriver ut objektet (toString blir kalt) samt navnet på regisoren
        for (Episode episode : episodeListe) {
            System.out.println(episode + " - regisert av " + episode.getRegisor().hentNavn());
        }
        System.out.println("------------Cast--------------");
        // Går gjennom alle roller for tvserien StrangerThings og skriver ut rollen
        for (Rolle enRolle : strangerThings.hentCast()) {
            System.out.println(enRolle + ", har vært i " + strangerThings.hentAntalletEpisoderEnRolleHarSpilt(enRolle) + " episoder");
        }
        System.out.println("-------Cast og antall episoder spilt-------");
        // Går gjennom alle roller for tvserien StrangerThings og skriver ut rollen og antallepisoder spilt
        for (Map.Entry<Rolle, Integer> rolleSpilt : strangerThings.hentCastMedAntallEpisoderSpilt().entrySet()) {
            // Henter og skriver ut nøkkelen (rollen) sin skuespiller og verdien (antallspilt) for hvert element
            System.out.println(rolleSpilt.getKey().getSkuespiller() + " har spilt i " + rolleSpilt.getValue() + " episoder");
        }
        System.out.println("******************************");
    }




    private static void doAThing(){
        for (TvSerie enTVSerie : TvSerie.getTVSerieListe()){
            System.out.println(enTVSerie.toString());
            Collections.sort(TvSerie.getTVSerieListe());
        }

    }





}