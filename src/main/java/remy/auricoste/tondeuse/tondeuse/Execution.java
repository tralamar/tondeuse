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

    private void ordonner(String instruction) {
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
            }
        }
    }

    public List<String> executer(List<String> instructionsParam) {
        List<String> instructions = new ArrayList<String>(instructionsParam);
        if (instructions.size() < 3) {
            throw new TondeuseFormatException("Il doit y avoir au moins 3 instructions : initialisation de la pelouse, initialisation de la tondeuse, deplacement de la tondeuse");
        }
        if (instructions.size() % 2 != 1) {
            throw new TondeuseFormatException("Il doit y avoir un nombre impair d'instructions : initialisation de la pelouse, puis des paires d'instructions (initialisation de la tondeuse, deplacement de la tondeuse)");
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
