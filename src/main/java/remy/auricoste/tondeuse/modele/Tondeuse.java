package remy.auricoste.tondeuse.modele;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class Tondeuse {

    private Vector2D position;
    private Orientation orientation;

    public Tondeuse(Orientation orientation, Vector2D position) {
        this.orientation = orientation;
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }
}
