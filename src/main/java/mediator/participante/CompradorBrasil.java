package mediator.participante;

import mediator.negociacao.Mediator;

public class CompradorBrasil extends Comprador {
    public CompradorBrasil(Mediator mediator) {
        super(mediator);
    }

    @Override
    public String nome() {
        return "Brasil";
    }

    @Override
    public String moeda() {
        return "BRL";
    }
}
