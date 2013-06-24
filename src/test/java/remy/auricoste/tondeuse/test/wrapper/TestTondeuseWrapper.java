package remy.auricoste.tondeuse.test.wrapper;

import junit.framework.TestCase;
import org.junit.Test;
import remy.auricoste.tondeuse.exception.TondeuseFormatException;
import remy.auricoste.tondeuse.wrapper.TondeuseWrapper;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class TestTondeuseWrapper extends TestCase {

    @Test
    public void testConstructeur() {
        new TondeuseWrapper("1 1 N");
        new TondeuseWrapper("1 5 S");

        testKoConstructeur("1  5 N");
        testKoConstructeur("1 5  N");
        testKoConstructeur("1 5 N ");
        testKoConstructeur(" 1 5 N");
        testKoConstructeur("1.0 5 N");
        testKoConstructeur("1 5 n");
        testKoConstructeur("1 5 s");
    }

    private void testKoConstructeur(String instruction) {
        try {
            new TondeuseWrapper(instruction);
        } catch (TondeuseFormatException e) {
            return;
        }
        fail();
    }

    @Test
    public void testToString() {
        testOkToString("1 1 N");
        testOkToString("1 1 O");
        testOkToString("1 1 S");
        testOkToString("1 1 E");
        testOkToString("1 10 E");
        testOkToString("10 1 E");
        testOkToString("3 6 E");
    }

    private void testOkToString(String instruction) {
        assertTrue(new TondeuseWrapper(instruction).toString().equals(instruction));
    }
}

