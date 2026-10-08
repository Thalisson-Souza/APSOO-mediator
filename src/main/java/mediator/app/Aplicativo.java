package mediator.app;

import mediator.conversor.ConversorDolar;
import mediator.negociacao.MediatorNegociacao;
import mediator.participante.Comprador;
import mediator.participante.CompradorBrasil;
import mediator.participante.CompradorFranca;
import mediator.participante.VendedorEUA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicativo {
    public static void main(String[] args) {
        MediatorNegociacao mediator = new MediatorNegociacao();

        ConversorDolar conversor = new ConversorDolar();
        conversor.adicionarTaxa("BRL", 0.18);
        conversor.adicionarTaxa("EUR", 1.08);

        mediator.registrarConversor(conversor);
        VendedorEUA vendedor = new VendedorEUA(mediator, "Notebook", 1000);
        mediator.registrarVendedor(vendedor);
        mediator.registrarComprador(new CompradorBrasil(mediator));
        mediator.registrarComprador(new CompradorFranca(mediator));

        executar(mediator, vendedor);
    }

    static void executar(MediatorNegociacao mediator, VendedorEUA vendedor) {
        List<Comprador> compradores = new ArrayList<>(mediator.getCompradores());
        Scanner entrada = new Scanner(System.in);

        System.out.println("Produto: " + vendedor.getProduto() + " por " + String.format("US$ %.2f", vendedor.getPrecoEmDolar()));

        while (true) {
            System.out.println();
            for (int i = 0; i < compradores.size(); i++) {
                Comprador c = compradores.get(i);
                System.out.println((i + 1) + " - " + c.nome() + " (" + c.moeda() + ")");
            }
            System.out.print("Comprador (0 para sair): ");
            if (!entrada.hasNextLine()) {
                return;
            }
            String opcao = entrada.nextLine().trim();
            if (opcao.equals("0")) {
                return;
            }
            try {
                Comprador comprador = compradores.get(Integer.parseInt(opcao) - 1);
                System.out.print("Valor da oferta em " + comprador.moeda() + ": ");
                if (!entrada.hasNextLine()) {
                    return;
                }
                double valor = Double.parseDouble(entrada.nextLine().trim().replace(',', '.'));
                System.out.println(comprador.ofertar(valor) ? "Oferta aceita." : "Oferta recusada.");
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Opção ou valor inválido.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
