
import wad.hakupuut.*;
import java.util.Scanner;

public class SuorituskyvynTestaus {
    HakupuuRajapinta bst, avl, rbt, splay;
    
    public SuorituskyvynTestaus() {
        bst = new BinaarinenHakupuu();
        avl = new AVLpuu();
        rbt = new PunaMustaPuu();
        splay = new SplayPuu();
    }
    
    /**
     * Luokan ainoa näkyvä metodi. Metodia kutsumalla on tarkoitus hoitaa ulkopuolinen
     * suorituskykytestaus.
     */
    public void testaaPuita() {
        liirumlaarum();
        int maara = kysyMaara("Kuinka monella syötteellä testataan?");
        
        testataanBst(maara);
        testataanAVL(maara);
        testataanRbt(maara);
        testataanSplay(maara);
    }
    
    /**
     * Alku höpinöitä. 
     */
    private void liirumlaarum() {
        System.out.println("Testataan binäärisiä hakupuita:\n"
                + "1. Perinteinen binäärinen hakupuu\n"
                + "2. AVL-puu\n"
                + "3. Punamusta puu\n"
                + "4. Splay-puu\n");
    }
    
    /**
     * Kysytään käyttäjältä int arvoa, jonka metodi palauttaa
     * @param s kysymys string
     * @return käyttäjän syöttämä int arvo.
     */
    private int kysyMaara(String s) {
        System.out.println(s);
        try {
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        } catch (Exception e) {
            return kysyMaara(s);
        }
    }
    
    /**
     * Testataan Binääristä hakupuuta
     * @param maara puun alkioiden määrä
     */
    private void testataanBst(int maara) {
        System.out.println("Testataan binääristä hakupuuta...");
        bst = puuLisays(maara, bst);
        puuHaku(maara,bst);
        bst = puuPoisto(maara,bst);
    }
    
    /**
     * Testataan AVL-puuta
     * @param maara puun alkioiden määrä
     */
    private void testataanAVL(int maara) {
        System.out.println("Testataan AVL-puuta...");
        avl = puuLisays(maara, avl);
        puuHaku(maara,avl);
        avl = puuPoisto(maara,avl);
    }
    
    /**
     * Testataan Punamustaa puuta
     * @param maara puun alkioiden määrä
     */
    private void testataanRbt(int maara) {
        System.out.println("Testataan Punamustaa puuta...");
        rbt = puuLisays(maara, rbt);
        puuHaku(maara,rbt);
        rbt = puuPoisto(maara,rbt);
    }
    
    /**
     * Testataan Splay-puuta
     * @param maara puun alkioiden määrä
     */
    private void testataanSplay(int maara) {
        System.out.println("Testataan Splay-puuta...");
        splay = puuLisays(maara, splay);
        splay = puuHaku(maara,splay);
        splay = puuPoisto(maara,splay);
    }
    /**
     * Lisätään alkioita puuhun.
     * @param maara montako lisätään
     * @param puu mihin puuhun
     * @return palautetaan operoitu puu
     */
    private HakupuuRajapinta puuLisays(int maara, HakupuuRajapinta puu) {
        long aikaAlussa = System.currentTimeMillis(); 
        for(int i = maara; i>0; i--) puu.lisaa(i);
        long aikaLopussa = System.currentTimeMillis();  
        System.out.println("Lisäyksessä kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");  
        return puu;
    }
    
    /**
     * Haetaan kaikki alkiot puusta.
     * @param maara Montako alkiota on puussa
     * @param puu Mikä puu
     * @return palautetaan operoitu puu. Tätä tarvitaan erityisesti splaypuussa, missä haku muuttaa puun rakennetta.
     */
    private HakupuuRajapinta puuHaku(int maara, HakupuuRajapinta puu) {
        long aikaAlussa = System.currentTimeMillis(); 
        for(int i = maara; i>0; i--) puu.hae(i);
        long aikaLopussa = System.currentTimeMillis();  
        System.out.println("Haussa kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");  
        return puu;
    }
    
    /**
     * Poistetaan kaikki puun alkiot.
     * @param maara poistettavien määrä
     * @param puu, josta poistetaan
     * @return palautetaan tyhjä puu
     */
    private HakupuuRajapinta puuPoisto(int maara, HakupuuRajapinta puu) {
        long aikaAlussa = System.currentTimeMillis(); 
        for(int i = maara; i>0; i--) puu.poista(i);
        long aikaLopussa = System.currentTimeMillis();  
        System.out.println("Poistossa kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");  
        return puu;
    }
}