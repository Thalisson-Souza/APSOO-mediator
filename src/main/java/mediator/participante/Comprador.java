package mediator.participante;

import mediator.negociacao.Mediator;

public abstract class Comprador extends Participante {
    protected Comprador(Mediator mediator) {
        super(mediator);
    }

    public abstract String nome();

    public abstract String moeda();

    public boolean ofertar(double quantia) {
        return mediator.proporOferta(quantia, moeda());
    }
}
