package remy.auricoste.tondeuse.outil;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class VectorOutil {

    public VectorOutil() {
    }

    public static boolean isPositif(Vector2D vecteur) {
        return vecteur.getX() >= 0d && vecteur.getY() >= 0d;
    }
}
