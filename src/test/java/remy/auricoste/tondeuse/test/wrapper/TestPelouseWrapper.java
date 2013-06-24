package remy.auricoste.tondeuse.test.wrapper;

import junit.framework.TestCase;
import org.junit.Test;
import remy.auricoste.tondeuse.wrapper.PelouseWrapper;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class TestPelouseWrapper extends TestCase {

    @Test
    public void testConstructeur() {
        PelouseWrapper pelouseWrapper = new PelouseWrapper("5 5");
        assertNotNull(pelouseWrapper);
    }

    @Test
    public void testToString() {
        assertEquals("5 5", new PelouseWrapper("5 5").toString());
    }
}
