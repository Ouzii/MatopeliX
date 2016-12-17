/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.domain;

import java.util.List;
import java.util.ArrayList;
import matopeli.Suunta;

/**
 *
 * @author Oce
 */
public class Mato {
    
    private Suunta suunta;
    private List<Pala> palat;
    private int kasvaako;

    public Mato(int alkuX, int alkuY, Suunta alkusuunta) {
        this.suunta = alkusuunta;
        this.palat = new ArrayList<>();
        this.palat.add(new Pala(alkuX, alkuY));
        this.kasvaako = 1;
    }

    public Suunta getSuunta() {
        return suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public int getPituus() {
        return this.palat.size();
    }

    public List<Pala> getPalat() {
        return palat;
    }
    
    public void liiku() {
        if(this.suunta==Suunta.YLOS) {
            palat.add(new Pala(palat.get(getPituus()-1).getX(), palat.get(getPituus()-1).getY()-1));
        }
        if(this.suunta==Suunta.ALAS) {
            palat.add(new Pala(palat.get(getPituus()-1).getX(), palat.get(getPituus()-1).getY()+1));
        }
        if(this.suunta==Suunta.VASEN) {
            palat.add(new Pala(palat.get(getPituus()-1).getX()-1, palat.get(getPituus()-1).getY()));
        }
        if(this.suunta==Suunta.OIKEA) {
            palat.add(new Pala(palat.get(getPituus()-1).getX()+1, palat.get(getPituus()-1).getY()));
        }
        if(this.kasvaako == 0 && getPituus() > 3) {
            this.palat.remove(0);
        } else {
            this.kasvaako = 0;
        }
        
    }
    
    public void kasva() {
//        palat.add(new Pala(palat.get(getPituus()-1).getX(), palat.get(getPituus()-1).getY()));
        this.kasvaako = 1;
    }
    
    public boolean osuu(Pala pala) {
        for (Pala pala1 : palat) {
            if(pala1.osuu(pala)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean osuuItseensa() {
        for (Pala pala : palat) {
            for (int i = 0; i < getPituus()-1; i++) {
                if(pala.osuu(palat.get(i)) && !pala.equals(palat.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    
}
