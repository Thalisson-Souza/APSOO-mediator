package mediator.negociacao;

import mediator.conversor.ConversorDolar;
import mediator.participante.CompradorBrasil;
import mediator.participante.CompradorFranca;
import mediator.participante.VendedorEUA;

public class MediatorNegociacao implements Mediator {
    private CompradorBrasil compradorBrasil;
    private CompradorFranca compradorFranca;
    private VendedorEUA vendedor;
    private ConversorDolar conversor;

    @Override
    public void registrarCompradorBrasil(CompradorBrasil comprador) {
        this.compradorBrasil = comprador;
    }

    @Override
    public void registrarCompradorFranca(CompradorFranca comprador) {
        this.compradorFranca = comprador;
    }

    @Override
    public void registrarVendedor(VendedorEUA vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public void registrarConversor(ConversorDolar conversor) {
        this.conversor = conversor;
    }

    @Override
    public boolean proporOferta(double quantia, String moeda) {
        double dolares = conversor.converter(quantia, moeda);
        return vendedor.avaliarOferta(dolares);
    }
}
