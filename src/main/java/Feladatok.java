import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Feladatok {

    public static void main(String[] args) {
        List<Szo> lista = beolvas("fajl.txt");
        SzoTarolo szt = new SzoTarolo(lista);

        //szt.kiir();

        //HÁNY SZÓ VAN?
        szt.kiirParamString("Hány szó van?");
        szt.kiirParamInt(szt.meret());

        //MELYIK A LEGHOSSZABB SZÓ?
        szt.kiirParamString("Melyik a leghosszabb szó?");
        szt.kiirParamString(szt.melyikALeghosszabbSzo());

        //HÁNY SZÓBAN VAN "E"?
        szt.kiirParamString("Hány szóban van 'E', mint betű?");
        szt.kiirParamInt(szt.hanySzobanVanEBetu());

        //Egy adótt szó első és utolsó betűjét meg kell cserélni!! //LISTA INDEXÉNEK ELEMÉT KELL MEGADNI PARAMBA!!!!!
        szt.kiirParamString("Egy adótt szó első és utolsó betűjét meg kell cserélni!!");
        szt.kiirParamString(szt.elsoEsUtolsoMegcserelese(3));

        //VAN E EGYFORMA SZÓ????
        szt.kiirParamString("Van e egyforma szó?");
        szt.kiirParamBoolean(szt.vanEEgyformaSzo());

        //MELYIK BETŰBŐL MENNYI VAN? //ADOTT SZÓ
        szt.kiirParamString("Melyik betűből mennyi van? Index alapján választott szó!");
        System.out.println(szt.melyikBetubolMennyiAdottSzo(2));

        //MELYIK BETŰBŐL MENNYI VAN? //EGÉSZ LISTA
        szt.kiirParamString("Melyik betűből mennyi van? Egész lista tartalma!");
        System.out.println(szt.melyikBetubolMennyi());


    }

    public static List<Szo> beolvas(String fajl) {
        List<Szo> szavak = new ArrayList<>();

        try {
            List<String> sorok = Files.readAllLines(Path.of(fajl));

            for (String sor : sorok) {
                String[] adatok = sor.split(";");

                for (String adat : adatok) {
                    szavak.add(new Szo(adat));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return szavak;
    }



}
