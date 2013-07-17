package remy.auricoste.tondeuse.test;

import junit.framework.TestCase;
import org.junit.Test;
import remy.auricoste.tondeuse.Execution;
import remy.auricoste.tondeuse.exception.TondeuseFormatException;

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
    public void testExecuterExceptionPosition() {
        String[] ordres = new String[]{
                "5 5",
                "1 1 N",
                "DD",
                "1 1 N",
                "GA"
        };
        try {
            Execution.instance().executer(Arrays.asList(ordres));
        } catch (RuntimeException e) {
            return;
        }
        fail();
    }

    @Test
    public void testExecuter() {
        String[] ordres = new String[]{
                "5 5",
                "1 1 N",
                "GGDDAADDAAGA",
                "1 1 N",
                "GA",
                "1 2 S",
                "AAAAAAAA"
        };
        List<String> positions = Execution.instance().executer(Arrays.asList(ordres));
        List<String> attendu = new ArrayList<String>();
        attendu.add("2 1 E");
        attendu.add("0 1 O");
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

    @Test
    public void testMainExecute() {
        testMainFail(null);
        testMainFail(new String[]{});
        testMainFail(new String[]{"test"});
        testMainFail(new String[]{"1", "2", "3", "4", "N"});
        try {
            Execution.main(new String[]{"5", "5", "3", "4", "N", "AGDDGA"});
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    private void testMainFail(String[] args) {
        try {
            Execution.main(args);
        } catch (TondeuseFormatException e) {
            return;
        }
        fail();
    }
}
