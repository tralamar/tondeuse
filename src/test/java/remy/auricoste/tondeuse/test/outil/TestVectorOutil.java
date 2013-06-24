package remy.auricoste.tondeuse.test.outil;

import junit.framework.TestCase;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.junit.*;
import remy.auricoste.tondeuse.outil.VectorOutil;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class TestVectorOutil extends TestCase {

    @Test
    public void testConstructeur() {
        assertNotNull(new VectorOutil());
    }

    @Test
    public void testIdPositif() {
        assertTrue(VectorOutil.isPositif(new Vector2D(0d, 0d)));
        assertTrue(VectorOutil.isPositif(new Vector2D(1d, 3d)));
        assertTrue(VectorOutil.isPositif(new Vector2D(0d, 10d)));
        assertTrue(!VectorOutil.isPositif(new Vector2D(0d, -1d)));
        assertTrue(!VectorOutil.isPositif(new Vector2D(-10d, 2d)));
    }
}
