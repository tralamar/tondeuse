package remy.auricoste.tondeuse.wrapper;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import remy.auricoste.tondeuse.exception.TondeuseFormatException;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class VectorWrapper {

    private Vector2D vecteur;

    public VectorWrapper(Vector2D vecteur) {
        this.vecteur = vecteur;
    }

    public VectorWrapper(String instruction) {
        String regexp = "(\\-)?[0-9]+ (\\-)?[0-9]+";
        if (!instruction.matches(regexp)) {
            throw new TondeuseFormatException("L'instruction " + instruction + " n'est pas valide. 2 nombres séparés par 1 espace sont attendus");
        }
        String[] elements = instruction.split(" ");
        Integer x = Integer.valueOf(elements[0]);
        Integer y = Integer.valueOf(elements[1]);
        vecteur = new Vector2D(x.doubleValue(), y.doubleValue());
    }

    @Override
    public String toString() {
        return ((int) vecteur.getX()) + " " + ((int) vecteur.getY()) + "";
    }

    public Vector2D getVecteur() {
        return vecteur;
    }
}
