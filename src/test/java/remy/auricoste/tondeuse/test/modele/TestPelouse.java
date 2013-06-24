package remy.auricoste.tondeuse.test.modele;

import junit.framework.TestCase;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.junit.*;
import remy.auricoste.tondeuse.tondeuse.exception.TondeusePositionException;
import remy.auricoste.tondeuse.tondeuse.modele.Orientation;
import remy.auricoste.tondeuse.tondeuse.modele.Pelouse;
import remy.auricoste.tondeuse.tondeuse.modele.Tondeuse;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class TestPelouse extends TestCase {

    private Pelouse pelouse;

    public TestPelouse() {
        testConstructeur();
    }

    @Test
    public void testConstructeur() {
        pelouse = new Pelouse(new Vector2D(5d, 5d));
    }

    @Test
    public void testAjouterTondeuse() {
        // tests de positions valides
        testOkAjouterTondeuse(0d, 0d);
        testOkAjouterTondeuse(0d, 1d);
        testOkAjouterTondeuse(1d, 1d);
        testOkAjouterTondeuse(5d, 5d);
        testOkAjouterTondeuse(5d, 0d);

        // tests de positions invalides
        testFailAjouterTondeuse(5d, 6d);
        testFailAjouterTondeuse(6d, 5d);
        testFailAjouterTondeuse(6d, 6d);
        testFailAjouterTondeuse(2d, 10d);
        testFailAjouterTondeuse(2d, -1d);
        testFailAjouterTondeuse(2d, -10d);
        testFailAjouterTondeuse(-1d, 0d);

        // tests de collisions
        testFailAjouterTondeuse(5d, 5d);
        testFailAjouterTondeuse(1d, 1d);
    }

    private void testOkAjouterTondeuse(double x, double y) {
        try {
            pelouse.ajouterTondeuse(new Tondeuse(Orientation.N, new Vector2D(x, y)));
        } catch (TondeusePositionException e) {
            fail();
        }
    }

    private void testFailAjouterTondeuse(double x, double y) {
        try {
            pelouse.ajouterTondeuse(new Tondeuse(Orientation.N, new Vector2D(x, y)));
        } catch (TondeusePositionException e) {
            return;
        }
        fail();
    }

    @Test
    public void testRotationDroite() {
        testConstructeur();
        Tondeuse tondeuse = new Tondeuse(Orientation.N, new Vector2D(1d, 1d));
        pelouse.rotationDroite(tondeuse);
        assertTrue(tondeuse.getOrientation() == Orientation.E);
        pelouse.rotationDroite(tondeuse);
        assertTrue(tondeuse.getOrientation() == Orientation.S);
        pelouse.rotationDroite(tondeuse);
        assertTrue(tondeuse.getOrientation() == Orientation.O);
        pelouse.rotationDroite(tondeuse);
        assertTrue(tondeuse.getOrientation() == Orientation.N);
    }

    @Test
    public void testRotationGauche() {
        testConstructeur();
        Tondeuse tondeuse = new Tondeuse(Orientation.N, new Vector2D(1d, 1d));
        pelouse.rotationGauche(tondeuse);
        assertTrue(tondeuse.getOrientation() == Orientation.O);
        pelouse.rotationGauche(tondeuse);
        assertTrue(tondeuse.getOrientation() == Orientation.S);
        pelouse.rotationGauche(tondeuse);
        assertTrue(tondeuse.getOrientation() == Orientation.E);
        pelouse.rotationGauche(tondeuse);
        assertTrue(tondeuse.getOrientation() == Orientation.N);
    }
}
