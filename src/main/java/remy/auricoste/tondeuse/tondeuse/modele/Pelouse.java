package remy.auricoste.tondeuse.tondeuse.modele;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import remy.auricoste.tondeuse.tondeuse.exception.TondeusePositionException;
import remy.auricoste.tondeuse.tondeuse.outil.VectorOutil;

import java.util.ArrayList;
import java.util.List;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class Pelouse {

    private Vector2D taille;
    private List<Tondeuse> tondeuses;

    public Pelouse(Vector2D taille) {
        this.taille = taille;
        tondeuses = new ArrayList<Tondeuse>();
    }

    public void ajouterTondeuse(Tondeuse tondeuse) throws TondeusePositionException {
        if (isPositionValide(tondeuse.getPosition())) {
            tondeuses.add(tondeuse);
        } else {
            throw new TondeusePositionException();
        }
    }

    public void avancer(Tondeuse tondeuse) {
        Vector2D nouvellePosition = tondeuse.getPosition().add(tondeuse.getOrientation().getVecteurUnitaire());
        if (isPositionValide(nouvellePosition)) {
            tondeuse.setPosition(nouvellePosition);
        }
    }

    private boolean isPositionValide(Vector2D position) {
        for (Tondeuse tondeuseIte : tondeuses) {
            if (position.equals(tondeuseIte.getPosition())) {
                return false;
            }
        }
        return VectorOutil.isPositif(position) && VectorOutil.isPositif(taille.add(-1d, position));
    }

    public void rotationDroite(Tondeuse tondeuse) {
        tondeuse.setOrientation(tondeuse.getOrientation().getSuivante());
    }

    public void rotationGauche(Tondeuse tondeuse) {
        tondeuse.setOrientation(tondeuse.getOrientation().getPrecedente());
    }

    public Vector2D getTaille() {
        return taille;
    }
}
