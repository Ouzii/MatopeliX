package matopeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import matopeli.peli.Matopeli;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Matopeli matopeli;
    private int sivunPituus;
    private Piirtoalusta piirto;

    public Kayttoliittyma(Matopeli matopeli, int sivunPituus) {
        this.matopeli = matopeli;
        this.sivunPituus = sivunPituus;
    }

    @Override
    public void run() {
        frame = new JFrame("Matopeli");
        int leveys = (matopeli.getLeveys() + 1) * sivunPituus + 16;
        int korkeus = (matopeli.getKorkeus() + 2) * sivunPituus + 18;

        frame.setPreferredSize(new Dimension(leveys, korkeus));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
        // Huom! Luo ensin piirtoalusta jonka lisäät container-olioon
        // Luo vasta tämän jälkeen näppäimistönkuuntelija, jonka lisäät frame-oliolle
        this.piirto = new Piirtoalusta(this.matopeli, this.sivunPituus);
        container.add(piirto);
        
        Nappaimistonkuuntelija nk = new Nappaimistonkuuntelija(this.matopeli.getMato(), this.matopeli, this.piirto);
        frame.addKeyListener(nk);
    }
    
    public Paivitettava getPaivitettava() {
        return this.piirto;
    }


    public JFrame getFrame() {
        return frame;
    }
}
