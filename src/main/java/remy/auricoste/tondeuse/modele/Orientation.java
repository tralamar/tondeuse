package remy.auricoste.tondeuse.modele;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public enum Orientation {
    //nord
    N(new Vector2D(0d, 1d)),
    //est
    E(new Vector2D(1d, 0d)),
    //sud
    S(new Vector2D(0d, -1d)),
    //ouest
    O(new Vector2D(-1d, 0d));

    private Vector2D vecteurUnitaire;

    Orientation(Vector2D vecteurUnitaire) {
        this.vecteurUnitaire = vecteurUnitaire;
    }

    public Vector2D getVecteurUnitaire() {
        return vecteurUnitaire;
    }

    public Orientation getSuivante() {
        return valueOf(ordinal() + 1);
    }

    public Orientation getPrecedente() {
        return valueOf(ordinal() - 1);
    }

    public static Orientation valueOf(int position) {
        int nbreElements = Orientation.values().length;
        int positionFinale = position;
        while (positionFinale < 0) {
            positionFinale += nbreElements;
        }
        positionFinale = positionFinale % nbreElements;
        return Orientation.values()[positionFinale];
    }
}
