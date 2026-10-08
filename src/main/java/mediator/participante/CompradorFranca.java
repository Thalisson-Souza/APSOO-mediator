package mediator.participante;

import mediator.negociacao.Mediator;

public class CompradorFranca extends Participante {
    public CompradorFranca(Mediator mediator) {
        super(mediator);
    }

    public boolean ofertar(double quantia) {
        return mediator.proporOferta(quantia, "EUR");
    }
}
