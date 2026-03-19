import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FeladatokTest {

    static List<Szo> szavak;
    SzoTarolo tarolo;

    @BeforeAll
    static void feltolt(){
        szavak = new ArrayList<>();

        szavak.add(new Szo("alma"));
        szavak.add(new Szo("korte"));
        szavak.add(new Szo("eper"));
        szavak.add(new Szo("banan"));
        szavak.add(new Szo("alma"));
        szavak.add(new Szo("majom"));
    }

    @BeforeEach
    void setUp() {
        tarolo = new SzoTarolo(szavak);
    }

    @Test
    void szavakSzama() {
        assertEquals(6, tarolo.meret());
    }

    @Test
    void leghosszabbSzoIndexe() {
        assertEquals("korte", tarolo.melyikALeghosszabbSzo());
    }

    @Test
    void betukSzama() {
        assertEquals(2, tarolo.hanySzobanVanEBetu());
        // korte, eper
    }

    @Test
    void csere() {
        // korte -> eortk
        assertEquals("eortk", tarolo.elsoEsUtolsoMegcserelese(1));
    }

    @Test
    void egyformaSzavak() {
        assertTrue(tarolo.vanEEgyformaSzo());
    }

    @Test
    void betuStatisztika() {
        HashMap<String, Integer> stat = tarolo.melyikBetubolMennyiAdottSzo(2);
        // eper

        assertEquals(2, stat.get("e"));
        assertEquals(1, stat.get("p"));
        assertEquals(1, stat.get("r"));
    }
}