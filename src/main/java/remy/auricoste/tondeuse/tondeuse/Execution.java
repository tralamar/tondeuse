package remy.auricoste.tondeuse.tondeuse;

import remy.auricoste.tondeuse.tondeuse.modele.Pelouse;
import remy.auricoste.tondeuse.tondeuse.wrapper.PelouseWrapper;
import remy.auricoste.tondeuse.tondeuse.wrapper.TondeuseWrapper;
import remy.auricoste.tondeuse.tondeuse.exception.TondeuseFormatException;
import remy.auricoste.tondeuse.tondeuse.modele.Tondeuse;

import java.util.ArrayList;
import java.util.List;

/**
 * Commentaire
 *
 * @version $Revision$ $Date$
 */
public class Execution {

    private static Execution instance;

    // contexte
    private PelouseWrapper pelouseWrapper;
    private TondeuseWrapper tondeuseWrapper;

    public static Execution instance() {
        if (instance == null) {
            instance = new Execution();
        }
        return instance;
    }

    private Execution() {
    }

    public void ordonner(String instruction) {
        String regexp = "[GDA]+";
        if (!instruction.matches(regexp)) {
            throw new TondeuseFormatException("L'instruction " + instruction + " n'est pas un ordre valide. Une suite de G, D ou A sont attendus");
        }
        Pelouse pelouse = pelouseWrapper.getPelouse();
        Tondeuse tondeuse = tondeuseWrapper.getTondeuse();
        for (int i = 0; i < instruction.length(); i++) {
            char ordre = instruction.charAt(i);
            switch (ordre) {
                case 'A':
                    pelouse.avancer(tondeuse);
                    break;
                case 'G':
                    pelouse.rotationGauche(tondeuse);
                    break;
                case 'D':
                    pelouse.rotationDroite(tondeuse);
                    break;
                default:
                    // ne devrait pas arriver
                    throw new TondeuseFormatException("Ordre inconnu : " + ordre);
            }
        }
    }

    public List<String> executer(List<String> instructionsParam) {
        List<String> instructions = new ArrayList<String>(instructionsParam);
        if (instructions.size() <= 1) {
            return null;
        }
        List<String> retour = new ArrayList<String>();
        String instructionPelouse = instructions.remove(0);
        pelouseWrapper = new PelouseWrapper(instructionPelouse);
        boolean pair = false;
        for (String instruction : instructions) {
            pair = !pair;
            if (pair) {
                tondeuseWrapper = new TondeuseWrapper(instruction);
            } else {
                ordonner(instruction);
                retour.add(tondeuseWrapper.toString());
            }
        }
        return retour;
    }
}
