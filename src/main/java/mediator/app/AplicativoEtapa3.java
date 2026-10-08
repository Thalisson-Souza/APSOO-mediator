package mediator.app;

import mediator.conversor.ConversorDolar;
import mediator.negociacao.MediatorNegociacao;
import mediator.participante.CompradorBrasil;
import mediator.participante.CompradorFranca;
import mediator.participante.CompradorJapao;
import mediator.participante.VendedorEUA;

public class AplicativoEtapa3 {
    public static void main(String[] args) {
        MediatorNegociacao mediator = new MediatorNegociacao();

        ConversorDolar conversor = new ConversorDolar();
        conversor.adicionarTaxa("BRL", 0.18);
        conversor.adicionarTaxa("EUR", 1.08);
        conversor.adicionarTaxa("JPY", 0.0067);

        mediator.registrarConversor(conversor);
        VendedorEUA vendedor = new VendedorEUA(mediator, "Notebook", 1000);
        mediator.registrarVendedor(vendedor);
        mediator.registrarComprador(new CompradorBrasil(mediator));
        mediator.registrarComprador(new CompradorFranca(mediator));
        mediator.registrarComprador(new CompradorJapao(mediator));

        Aplicativo.executar(mediator, vendedor);
    }
}
