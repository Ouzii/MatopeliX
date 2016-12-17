package matopeli.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import matopeli.Suunta;
import matopeli.domain.Mato;
import matopeli.domain.Omena;
import matopeli.gui.Paivitettava;

public class Matopeli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private boolean jatkuu;
    private Paivitettava paivitettava;
    private Mato mato;
    private Omena omena;
    private boolean alkaa;

    public Matopeli(int leveys, int korkeus) {
        super(1000, null);
        this.alkaa = false;
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuu = true;
        this.mato = new Mato(leveys/2, korkeus/2, Suunta.ALAS);
        this.omena = new Omena(new Random().nextInt(leveys), new Random().nextInt(korkeus));
        if(this.mato.osuu(omena)) {
            this.omena = new Omena(new Random().nextInt(leveys), new Random().nextInt(korkeus));
            if(this.mato.osuu(omena)) {
                this.omena = new Omena(0, 0);
            }
        }
        
        addActionListener(this);
        setInitialDelay(2000);
        

    }


    public void jatka() {
        this.jatkuu = true;
    }
    
    public boolean aloita() {
        this.alkaa = true;
        return this.alkaa;
    }

    public boolean isAlkaa() {
        return alkaa;
    }
    
    public boolean jatkuu() {
        return jatkuu;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(!jatkuu()) {
            restart();
        }
        this.mato.liiku();
        if(mato.osuu(omena)) {
            mato.kasva();
            omena = new Omena(new Random().nextInt(leveys), new Random().nextInt(korkeus));
        }
        if(mato.osuuItseensa()) {
            this.jatkuu = false;
        }
        
        if(mato.getPalat().get(mato.getPituus()-1).getX() == leveys+1 || mato.getPalat().get(mato.getPituus()-1).getX() == -1  || mato.getPalat().get(mato.getPituus()-1).getY() == korkeus+1 || mato.getPalat().get(mato.getPituus()-1).getY() == -1) {
            this.jatkuu = false;
        }
        
        paivitettava.paivita();
        setDelay(1000/mato.getPituus());

    }

    public Mato getMato() {
        return mato;
    }

    public void setMato(Mato mato) {
        this.mato = mato;
    }

    public Omena getOmena() {
        return omena;
    }

    public void setOmena(Omena omena) {
        this.omena = omena;
    }
    
    public void lopu() {
        this.alkaa = false;
    }
    
    public void reset() {
        this.jatkuu = true;
        this.mato = new Mato(leveys/2, korkeus/2, Suunta.ALAS);
        
    }

}
