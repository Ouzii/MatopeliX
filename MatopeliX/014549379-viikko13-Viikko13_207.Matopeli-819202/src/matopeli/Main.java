package matopeli;

import javax.swing.SwingUtilities;
import matopeli.gui.Kayttoliittyma;
import matopeli.peli.Matopeli;

public class Main {

    public static void main(String[] args) {
        Matopeli matopeli = new Matopeli(20, 20);

        Kayttoliittyma kali = new Kayttoliittyma(matopeli, 20);
        SwingUtilities.invokeLater(kali);

        while (kali.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }

        matopeli.setPaivitettava(kali.getPaivitettava());
        matopeli.start();
        
    }
}
