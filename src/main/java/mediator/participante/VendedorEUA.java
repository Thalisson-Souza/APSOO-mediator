package mediator.participante;

import mediator.negociacao.Mediator;

public class VendedorEUA extends Participante {
    private final String produto;
    private final double precoEmDolar;

    public VendedorEUA(Mediator mediator, String produto, double precoEmDolar) {
        super(mediator);
        if (precoEmDolar <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        this.produto = produto;
        this.precoEmDolar = precoEmDolar;
    }

    public String getProduto() {
        return produto;
    }

    public double getPrecoEmDolar() {
        return precoEmDolar;
    }

    public boolean avaliarOferta(double dolares) {
        return dolares >= precoEmDolar;
    }
}
