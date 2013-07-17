package remy.auricoste.tondeuse.test.modele;

import junit.framework.TestCase;
import org.junit.*;
import remy.auricoste.tondeuse.modele.Orientation;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class TestOrientation extends TestCase {

    @Test
    public void testValueOf() {
        assertTrue(Orientation.valueOf(0) == Orientation.N);
        assertTrue(Orientation.valueOf(1) == Orientation.E);
        assertTrue(Orientation.valueOf(2) == Orientation.S);
        assertTrue(Orientation.valueOf(3) == Orientation.O);
        assertTrue(Orientation.valueOf(-1) == Orientation.valueOf(3));
        assertTrue(Orientation.valueOf(-5) == Orientation.valueOf(3));
        assertTrue(Orientation.valueOf(4) == Orientation.valueOf(0));
        assertTrue(Orientation.valueOf(8) == Orientation.valueOf(0));
    }

    @Test
    public void testGetSuivante() {
        assertTrue(Orientation.N.getSuivante() == Orientation.E);
        assertTrue(Orientation.E.getSuivante() == Orientation.S);
        assertTrue(Orientation.S.getSuivante() == Orientation.O);
        assertTrue(Orientation.O.getSuivante() == Orientation.N);
    }

    @Test
    public void testGetPrecedente() {
        assertTrue(Orientation.N.getPrecedente() == Orientation.O);
        assertTrue(Orientation.O.getPrecedente() == Orientation.S);
        assertTrue(Orientation.S.getPrecedente() == Orientation.E);
        assertTrue(Orientation.E.getPrecedente() == Orientation.N);        
    }
}
