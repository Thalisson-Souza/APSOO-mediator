package mediator.participante;

import mediator.negociacao.Mediator;

public class CompradorFranca extends Comprador {
    public CompradorFranca(Mediator mediator) {
        super(mediator);
    }

    @Override
    public String nome() {
        return "França";
    }

    @Override
    public String moeda() {
        return "EUR";
    }
}
