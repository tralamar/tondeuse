package remy.auricoste.tondeuse.test.wrapper;

import junit.framework.TestCase;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.junit.*;
import remy.auricoste.tondeuse.exception.TondeuseFormatException;
import remy.auricoste.tondeuse.wrapper.VectorWrapper;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class TestVectorWrapper extends TestCase {

    @Test
    public void testConstructeur() {
        new VectorWrapper("5 5");
        new VectorWrapper("2 -1");
        new VectorWrapper("-10 0");
    }

    @Test
    public void testKoConstructeur() {
        testKoConstructeur("5.0 52");
        testKoConstructeur("5 2.1");
        testKoConstructeur("5a 5");
        testKoConstructeur("fe 15");
        testKoConstructeur("5/5");
        testKoConstructeur("5+5 5");
    }

    private void testKoConstructeur(String instruction) {
        try {
            new VectorWrapper(instruction);
        } catch (TondeuseFormatException e) {
            return;
        }
        fail();
    }

    @Test
    public void testGetVecteur() {
        assertTrue(new VectorWrapper("5 5").getVecteur().equals(new Vector2D(5d, 5d)));
        assertTrue(new VectorWrapper("2 -1").getVecteur().equals(new Vector2D(2d, -1d)));
        assertTrue(new VectorWrapper("-10 0").getVecteur().equals(new Vector2D(-10, 0d)));
    }

    @Test
    public void testToString() {
        assertTrue(new VectorWrapper("5 5").toString().equals("5 5"));
        assertTrue(new VectorWrapper("2 -1").toString().equals("2 -1"));
        assertTrue(new VectorWrapper("-10 0").toString().equals("-10 0"));        
    }
}
