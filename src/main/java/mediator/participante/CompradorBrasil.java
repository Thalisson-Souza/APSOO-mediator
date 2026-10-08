package mediator.participante;

import mediator.negociacao.Mediator;

public class CompradorBrasil extends Participante {
    public CompradorBrasil(Mediator mediator) {
        super(mediator);
    }

    public boolean ofertar(double quantia) {
        return mediator.proporOferta(quantia, "BRL");
    }
}
