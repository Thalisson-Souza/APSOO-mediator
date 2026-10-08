package mediator.negociacao;

import mediator.conversor.ConversorDolar;
import mediator.participante.Comprador;
import mediator.participante.VendedorEUA;

public interface Mediator {
    void registrarComprador(Comprador comprador);

    void registrarVendedor(VendedorEUA vendedor);

    void registrarConversor(ConversorDolar conversor);

    boolean proporOferta(double quantia, String moeda);
}
