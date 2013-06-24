package remy.auricoste.tondeuse.test;

import junit.framework.TestCase;
import org.junit.Test;
import remy.auricoste.tondeuse.tondeuse.Execution;
import remy.auricoste.tondeuse.tondeuse.exception.TondeuseFormatException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class TestExecution extends TestCase {

    @Test
    public void testConstructeur() {
        Execution execution = Execution.instance();
        assertNotNull(execution);
        assertEquals(execution, Execution.instance());
    }

    @Test
    public void testOrdonner() {

    }

    @Test
    public void testExecuter() {
        String[] ordres = new String[]{
                "5 5",
                "1 1 N",
                "GGDDAADDAAG",
                "1 1 N",
                "G",
                "1 1 S",
                "AAAAAAAA"
        };
        List<String> positions = Execution.instance().executer(Arrays.asList(ordres));
        List<String> attendu = new ArrayList<String>();
        attendu.add("1 1 E");
        attendu.add("1 1 O");
        attendu.add("1 0 S");
        assertEquals(attendu, positions);

        try {
            ordres = new String[]{
                    "5 5",
                    "1 1 N",
                    "GGDDAADDBAG"
            };
            Execution.instance().executer(Arrays.asList(ordres));
            fail();
        } catch (TondeuseFormatException e) {
        }
        try {
            ordres = new String[]{
                    "5 5",
                    "1 1 N"
            };
            Execution.instance().executer(Arrays.asList(ordres));
            fail();
        } catch (TondeuseFormatException e) {
        }
        try {
            ordres = new String[]{
                    "5 5",
                    "1 1 N",
                    "GGDDAADDAG",
                    "2 2 N"
            };
            Execution.instance().executer(Arrays.asList(ordres));
            fail();
        } catch (TondeuseFormatException e) {
        }

        ordres = new String[]{
                "5 5",
                "1 2 N",
                "GAGAGAGAA",
                "3 3 E",
                "AADAADADDA"
        };
        positions = Execution.instance().executer(Arrays.asList(ordres));
        attendu = new ArrayList<String>();
        attendu.add("1 3 N");
        attendu.add("5 1 E");
        assertEquals(attendu, positions);
    }
}
