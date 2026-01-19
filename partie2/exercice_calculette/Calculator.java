package partie2.exercice_calculette;

public class Calculator {
    
    public int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Erreur : Division par zéro impossible.");
            return 0;
        }
        return a / b;
    }

    public int convertToNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("Erreur : '" + text + "' n'est pas un nombre valide");
            throw e; // Usually we rethrow or handle. Instruction says "Display ...".
                     // If I return 0, it might be confusing. 
                     // I will return 0 but the display requirement is met.
        }
    }

    public void calculate(String op, int a, int b) {
        switch (op) {
            case "+":
                System.out.println("Résultat : " + (a + b));
                break;
            case "-":
                System.out.println("Résultat : " + (a - b));
                break;
            case "*":
                System.out.println("Résultat : " + (a * b));
                break;
            case "/":
                if (b == 0) {
                     divide(a, b); // Will print error
                } else {
                     System.out.println("Résultat : " + divide(a, b));
                }
                break;
            default:
                System.out.println("Erreur : Opération '" + op + "' non supportée");
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("--- Tests ---");
        calc.calculate("+", 10, 5);
        calc.calculate("/", 10, 0);
        calc.calculate("&", 5, 5);
        
        System.out.println("Convert '123': " + calc.convertToNumber("123"));
        try {
            calc.convertToNumber("abc");
        } catch (Exception e) {
            // caught
        }
    }
}
