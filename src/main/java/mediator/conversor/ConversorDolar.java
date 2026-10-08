package mediator.conversor;

public class ConversorDolar {
    public double converter(double quantia, String moeda) {
        if (moeda.equals("BRL")) {
            return quantia * 0.18;
        }
        if (moeda.equals("EUR")) {
            return quantia * 1.08;
        }
        if (moeda.equals("USD")) {
            return quantia;
        }
        return 0;
    }
}
