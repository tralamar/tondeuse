package remy.auricoste.tondeuse.tondeuse.wrapper;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import remy.auricoste.tondeuse.tondeuse.modele.Orientation;
import remy.auricoste.tondeuse.tondeuse.modele.Tondeuse;
import remy.auricoste.tondeuse.tondeuse.exception.TondeuseFormatException;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class TondeuseWrapper {

    private Tondeuse tondeuse;

    public TondeuseWrapper(Tondeuse tondeuse) {
        this.tondeuse = tondeuse;
    }

    public TondeuseWrapper(String instruction) {
        String regexp = "[0-9]+ [0-9]+ [NOES]";
        if (!instruction.matches(regexp)) {
            throw new TondeuseFormatException("L'instruction " + instruction + " n'est pas valide pour initialiser la tondeuse. 2 nombres et une orientation (N, O, E ou S) séparés par des espaces sont attendus");
        }
        String[] elements = instruction.split(" ");
        Orientation orientation = Orientation.valueOf(elements[2]);
        Vector2D position = new VectorWrapper(elements[0] + " " + elements[1]).getVecteur();
        tondeuse = new Tondeuse(orientation, position);
    }

    @Override
    public String toString() {
        return new VectorWrapper(tondeuse.getPosition()) + " " + tondeuse.getOrientation().name();
    }

    public Tondeuse getTondeuse() {
        return tondeuse;
    }
}
