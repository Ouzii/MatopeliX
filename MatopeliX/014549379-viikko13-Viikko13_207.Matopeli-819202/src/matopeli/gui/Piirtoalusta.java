/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import matopeli.domain.Pala;
import matopeli.peli.Matopeli;

/**
 *
 * @author Oce
 */
public class Piirtoalusta extends JPanel implements Paivitettava {

    private Matopeli matopeli;
    private int palanKoko;

    public Piirtoalusta(Matopeli matopeli, int palanSivunPituus) {
        this.matopeli = matopeli;
        this.palanKoko = palanSivunPituus;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int pojot = this.matopeli.getMato().getPituus() - 3;
        if (this.matopeli.isAlkaa()) {
            if (this.matopeli.jatkuu()) {
                for (Pala pala : this.matopeli.getMato().getPalat()) {
                    g.setColor(Color.BLACK);
                    g.fill3DRect(pala.getX() * this.palanKoko, pala.getY() * this.palanKoko, this.palanKoko, this.palanKoko, true);
                }

                g.setColor(Color.RED);
                g.fillOval(this.matopeli.getOmena().getX() * this.palanKoko, this.matopeli.getOmena().getY() * this.palanKoko, this.palanKoko, this.palanKoko);
                g.setFont(new Font("Coming Sans MS", Font.BOLD, 12));
                g.setColor(Color.BLACK);
                if (pojot < 0) {
                    g.drawString("" + 0, 10, 20);
                } else {
                    g.drawString("" + pojot, 10, 20);
                }

            } else {
                Font font = new Font("Comic Sans MS", Font.BOLD, 40);
                g.setFont(font);
                g.drawString("END", this.matopeli.getLeveys() / 2 * this.palanKoko - 30, this.matopeli.getKorkeus() / 2 * this.palanKoko);
                g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
                g.drawString("Pisteet: " + pojot, this.matopeli.getLeveys() / 2 * this.palanKoko - 30, this.matopeli.getKorkeus() / 2 * this.palanKoko + 30);
                g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
                g.drawString("Paina <Enter> aloittaaksesi uudestaan", this.matopeli.getLeveys() / 2 * this.palanKoko - 100, this.matopeli.getKorkeus() / 2 * this.palanKoko + 50);

            }
        } else {
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
            g.drawString("Aloita painamalla <Enter>", this.matopeli.getLeveys() / 2 * this.palanKoko - 190, this.matopeli.getKorkeus() / 2 * this.palanKoko);
        }
    }

    @Override
    public void paivita() {
        repaint();
    }

}
