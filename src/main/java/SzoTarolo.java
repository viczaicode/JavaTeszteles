import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SzoTarolo {

    private List<Szo> szavak;

    public SzoTarolo(List<Szo> szavak) {
        this.szavak = szavak;
    }

    public void kiir() {
        for (Szo szo : szavak) {
            System.out.println(szo.getSzo());
        }
    }

    public int meret() {
        return szavak.size();
    }

    public String melyikALeghosszabbSzo() {
        int idegiglenesSzoHosszusag = 0;
        String ideiglenesSzoNeve = "";

        for (Szo szo : szavak) {
            if (szo.getSzo().length() > idegiglenesSzoHosszusag) {
                idegiglenesSzoHosszusag = szo.getSzo().length();
                ideiglenesSzoNeve = szo.getSzo();
            }
        }
        return ideiglenesSzoNeve;
    }

    public int hanySzobanVanEBetu() {
        int szamlalo = 0;
        for (Szo szo : szavak) {
            if (szo.getSzo().contains("e")) {
                szamlalo += 1;
            }
        }
        return szamlalo;
    }

    public String elsoEsUtolsoMegcserelese(int index) {
        String str = szavak.get(index).getSzo();
        if (str == null || str.length() <= 1) {
            return str;
        }

        int len = str.length();
        char first = str.charAt(0);
        char last = str.charAt(len - 1);
        String middle = str.substring(1, len - 1);

        return last + middle + first;
    }

    public boolean vanEEgyformaSzo() {

        HashSet<String> szohalmaz = new HashSet<>();

        for (Szo szo : szavak) {
            szohalmaz.add(szo.getSzo());
        }

        return szohalmaz.size() != szavak.size();
    }

    /*public HashMap<String, Integer> melyikBetubolMennyiAdottSzo(int index) {
        String szo =  szavak.get(index).getSzo();
        HashMap<String, Integer> betukMennyisege = new HashMap<>();

        for (int i = szo.charAt(szo.length()); i < szo.charAt(szo.length()-1); i++) {
            betukMennyisege.put(szo.charAt([i]),+1);
        }


        return betukMennyisege;
    }*/

    public HashMap<String, Integer> melyikBetubolMennyiAdottSzo(int index) {
        String szo = szavak.get(index).getSzo();
        HashMap<String, Integer> betukMennyisege = new HashMap<>();

        for (int i = 0; i < szo.length(); i++) {
            String betu = String.valueOf(szo.charAt(i));

            if (betukMennyisege.containsKey(betu)) {
                betukMennyisege.put(betu, betukMennyisege.get(betu) + 1);
            } else {
                betukMennyisege.put(betu, 1);
            }
        }

        return betukMennyisege;
    }

    public HashMap<String, Integer> melyikBetubolMennyi() {
        HashMap<String, Integer> betukMennyisege = new HashMap<>();

        for (int j = 0; j < szavak.size(); j++) {
            String szo = szavak.get(j).getSzo();

            for (int i = 0; i < szo.length(); i++) {
                String betu = String.valueOf(szo.charAt(i));

                betukMennyisege.put(betu, betukMennyisege.getOrDefault(betu, 0) + 1);
            }
        }

        return betukMennyisege;
    }



    public void kiirParamString(String valami) {
        System.out.println(valami);
    }

    public void kiirParamInt(int valami) {
        System.out.println(valami);
    }

    public void kiirParamBoolean(boolean valami) {
        System.out.println(valami);
    }


}