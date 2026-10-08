package mediator.negociacao;

import mediator.conversor.ConversorDolar;
import mediator.participante.Comprador;
import mediator.participante.VendedorEUA;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class MediatorNegociacao implements Mediator {
    private final Map<String, Comprador> compradores = new LinkedHashMap<>();
    private VendedorEUA vendedor;
    private ConversorDolar conversor;

    @Override
    public void registrarComprador(Comprador comprador) {
        if (comprador == null) {
            throw new IllegalArgumentException("O comprador é obrigatório.");
        }
        compradores.put(comprador.moeda(), comprador);
    }

    @Override
    public void registrarVendedor(VendedorEUA vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public void registrarConversor(ConversorDolar conversor) {
        this.conversor = conversor;
    }

    public Collection<Comprador> getCompradores() {
        return compradores.values();
    }

    @Override
    public boolean proporOferta(double quantia, String moeda) {
        if (vendedor == null || conversor == null) {
            throw new IllegalStateException("Vendedor e conversor precisam estar registrados.");
        }
        if (!compradores.containsKey(moeda)) {
            throw new IllegalArgumentException("Nenhum comprador registrado com a moeda " + moeda + ".");
        }
        if (quantia <= 0) {
            throw new IllegalArgumentException("A oferta deve ser maior que zero.");
        }
        double dolares = conversor.converter(quantia, moeda);
        return vendedor.avaliarOferta(dolares);
    }
}
