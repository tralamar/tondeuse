package remy.auricoste.tondeuse.wrapper;

import remy.auricoste.tondeuse.modele.Pelouse;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class PelouseWrapper {

    private Pelouse pelouse;

    public PelouseWrapper(String instruction) {
        pelouse = new Pelouse(new VectorWrapper(instruction).getVecteur());
    }

    @Override
    public String toString() {
        return new VectorWrapper(pelouse.getTaille()).toString();
    }

    public Pelouse getPelouse() {
        return pelouse;
    }
}
