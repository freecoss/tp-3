package partie2.exercice_vehicule;

public class TooFastException extends Exception {
    public TooFastException(int speed) {
        super("C'est une exception de type TooFastException. Vitesse en cause : " + speed);
    }
}
