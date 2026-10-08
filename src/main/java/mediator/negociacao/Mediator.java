package mediator.negociacao;

import mediator.conversor.ConversorDolar;
import mediator.participante.CompradorBrasil;
import mediator.participante.CompradorFranca;
import mediator.participante.VendedorEUA;

public interface Mediator {
    void registrarCompradorBrasil(CompradorBrasil comprador);

    void registrarCompradorFranca(CompradorFranca comprador);

    void registrarVendedor(VendedorEUA vendedor);

    void registrarConversor(ConversorDolar conversor);

    boolean proporOferta(double quantia, String moeda);
}
