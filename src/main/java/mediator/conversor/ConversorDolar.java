package mediator.conversor;

import java.util.HashMap;
import java.util.Map;

public class ConversorDolar {
    private final Map<String, Double> taxas = new HashMap<>();

    public ConversorDolar() {
        taxas.put("USD", 1.0);
    }

    public void adicionarTaxa(String moeda, double taxaParaDolar) {
        if (moeda == null || moeda.isBlank()) {
            throw new IllegalArgumentException("A moeda é obrigatória.");
        }
        if (taxaParaDolar <= 0) {
            throw new IllegalArgumentException("A taxa deve ser maior que zero.");
        }
        taxas.put(moeda, taxaParaDolar);
    }

    public double converter(double quantia, String moeda) {
        Double taxa = taxas.get(moeda);
        if (taxa == null) {
            throw new IllegalArgumentException("Moeda " + moeda + " não suportada.");
        }
        return quantia * taxa;
    }
}
