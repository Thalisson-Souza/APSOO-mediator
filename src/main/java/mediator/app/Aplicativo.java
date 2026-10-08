package mediator.app;

import mediator.conversor.ConversorDolar;
import mediator.negociacao.MediatorNegociacao;
import mediator.participante.CompradorBrasil;
import mediator.participante.CompradorFranca;
import mediator.participante.VendedorEUA;

import java.util.Scanner;

public class Aplicativo {
    public static void main(String[] args) {
        MediatorNegociacao mediator = new MediatorNegociacao();
        CompradorBrasil brasil = new CompradorBrasil(mediator);
        CompradorFranca franca = new CompradorFranca(mediator);
        VendedorEUA vendedor = new VendedorEUA(mediator, "Notebook", 1000);

        mediator.registrarCompradorBrasil(brasil);
        mediator.registrarCompradorFranca(franca);
        mediator.registrarVendedor(vendedor);
        mediator.registrarConversor(new ConversorDolar());

        Scanner entrada = new Scanner(System.in);
        System.out.println("Produto: " + vendedor.getProduto() + " por US$ " + vendedor.getPrecoEmDolar());

        while (true) {
            System.out.println();
            System.out.print("Comprador (1 - Brasil, 2 - França, 0 - sair): ");
            if (!entrada.hasNextLine()) {
                return;
            }
            String opcao = entrada.nextLine().trim();
            if (opcao.equals("0")) {
                return;
            }
            System.out.print("Valor da oferta: ");
            double valor = Double.parseDouble(entrada.nextLine().trim());

            boolean aceita;
            if (opcao.equals("1")) {
                aceita = brasil.ofertar(valor);
            } else {
                aceita = franca.ofertar(valor);
            }
            System.out.println(aceita ? "Oferta aceita." : "Oferta recusada.");
        }
    }
}
