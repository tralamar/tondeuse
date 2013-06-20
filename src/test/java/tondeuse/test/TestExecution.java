package tondeuse.test;

import org.junit.Test;
import remy.auricoste.tondeuse.tondeuse.Execution;

import java.util.Arrays;
import java.util.List;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class TestExecution {

    @Test
    public void testTondeuses() {
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
        for (String position : positions) {
            System.out.println(position);
        }
    }
}
