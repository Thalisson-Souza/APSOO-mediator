package mediator.participante;

import mediator.negociacao.Mediator;

public class CompradorJapao extends Comprador {
    public CompradorJapao(Mediator mediator) {
        super(mediator);
    }

    @Override
    public String nome() {
        return "Japão";
    }

    @Override
    public String moeda() {
        return "JPY";
    }
}
