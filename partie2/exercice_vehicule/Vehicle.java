package partie2.exercice_vehicule;

public class Vehicle {
    public Vehicle() {
        // Constructeur vide
    }

    public void testSpeed(int speed) throws TooFastException {
        if (speed > 90) {
            throw new TooFastException(speed);
        }
        System.out.println("Vitesse " + speed + " est OK.");
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        System.out.println("Test de vitesse 80 :");
        try {
            v.testSpeed(80);
        } catch (TooFastException e) {
            e.printStackTrace();
        }

        System.out.println("Test de vitesse 120 :");
        try {
            v.testSpeed(120);
        } catch (TooFastException e) {
            e.printStackTrace();
        }
    }
}
