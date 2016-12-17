
package matopeli.domain;

public class Pala {
    
    private int x;
    private int y;

    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean osuu(Pala pala) {
        if(this.x == pala.getX() && this.y == pala.getY()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }
    
    
}
