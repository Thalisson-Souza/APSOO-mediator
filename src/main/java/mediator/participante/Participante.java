package mediator.participante;

import mediator.negociacao.Mediator;

public abstract class Participante {
    protected final Mediator mediator;

    protected Participante(Mediator mediator) {
        this.mediator = mediator;
    }
}
