package org.example;

import java.io.IOException;
import java.util.Scanner;

public class FipeApiConsumer {
    public void executar() throws IOException {

        Scanner scanner = new Scanner(System.in);

        // Listar marcas de carros
        FipeService.listarMarcas();
        System.out.print("Digite o ID da marca desejada: ");
        String idMarca = scanner.nextLine();

        // Listar modelos da marca escolhida
        FipeService.listarModelos(idMarca);
        System.out.print("Digite o ID do modelo desejado: ");
        String idModelo = scanner.nextLine();

        // Listar anos disponíveis para o modelo escolhido
        FipeService.listarAnos(idMarca, idModelo);
        System.out.print("Digite o ano desejado: ");
        String ano = scanner.nextLine();

        // Obter o preço do veículo escolhido
        FipeService.obterPreco(idMarca, idModelo, ano);
    }
}
