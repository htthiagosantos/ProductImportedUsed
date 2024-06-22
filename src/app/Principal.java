package app;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Produto> lista = new ArrayList<>();

        System.out.print("Entre com o numero de produtos: ");
        int numero = sc.nextInt();

        for (int i = 1; i <= numero; i++){
            System.out.println("Dados do produto n " + i + ":");
            System.out.println("Comum, Usado, Importado (c/u/i) ");
            char type = sc.next().charAt(0);

            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();

            System.out.print("Preço: ");
            double preco = sc.nextDouble();

            if (type == 'c'){
                lista.add(new Produto(nome, preco));
            } else if ( type == 'u') {
                System.out.println("Data de fabricação (DD/MM/YYYY): ");
                LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                lista.add(new ProdutoUsado(nome, preco, data));
            }
            else {
                System.out.print("Taxa de importação: ");
                double alfandegas = sc.nextDouble();
                lista.add(new ProdutoImportado(nome, preco, alfandegas));
            }
        }

        System.out.println();
        System.out.println("Etiquetas de preço: ");
        for (Produto produto : lista){
            System.out.println(produto.etiquetaDePreco());
        }




        sc.close();
    }
}
