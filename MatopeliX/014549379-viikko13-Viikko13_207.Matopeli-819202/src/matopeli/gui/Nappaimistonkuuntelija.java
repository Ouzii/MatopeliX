/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import matopeli.Suunta;
import matopeli.domain.Mato;
import matopeli.peli.Matopeli;

/**
 *
 * @author Oce
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Mato mato;
    private Matopeli matopeli;

    public Nappaimistonkuuntelija(Mato mato, Matopeli matopeli, Piirtoalusta piirtoalusta) {
        this.mato = mato;
        this.matopeli = matopeli;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.mato.setSuunta(Suunta.OIKEA);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.mato.setSuunta(Suunta.VASEN);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.mato.setSuunta(Suunta.YLOS);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.mato.setSuunta(Suunta.ALAS);
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!this.matopeli.isAlkaa()) {
                this.matopeli.aloita();
            }
            if (!this.matopeli.jatkuu()) {
                this.matopeli.reset();
                this.mato = this.matopeli.getMato();
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
