import java.util.Scanner;

class Caixa {
    double valorProduto;
    double valorPago;

    // Construtor
    Caixa(double valorProduto, double valorPago) {
        this.valorProduto = valorProduto;
        this.valorPago = valorPago;
    }

    // Método para calcular o troco
    double calcularTroco() {
        return valorPago - valorProduto;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        System.out.println("|Cadastro|");
        System.out.println("Digite seu nome: ");
        String cadastro = sc.nextLine();
        System.out.println("Digite sua senha: ");
        int password = sc.nextInt();

        System.out.println("\nOlá, serei seu assistente!");
        System.out.print("Digite o valor do produto: ");
        double valorProduto = sc.nextDouble();

        System.out.print("Digite o valor entregue pelo cliente: ");
        double valorPago = sc.nextDouble();

        if (valorPago < valorProduto) {
            System.out.println("O cliente entregou valores errados para efetuar o pagamento.");
        } else {
            Caixa caixa = new Caixa(valorProduto, valorPago);
            double troco = caixa.calcularTroco();
            System.out.println("O troco a ser entregue é: R$ " + troco);
        }

        do {
            System.out.println("\nDeseja efetuar alguma outra operação?");
            System.out.println("1 - Registrar nota fiscal");
            System.out.println("2 - Cadastrar produto");
            System.out.println("3 - Cadastrar novo usuário");
            System.out.println("4 - Tirar orçamento");
            System.out.println("5 - Fechar programa");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o valor da NF: ");
                    double NF_valor = sc.nextDouble();
                    System.out.print("Digite o número da NF: ");
                    int numero_NF = sc.nextInt();
                    sc.nextLine();

                    System.out.println("NF registrada: Valor R$" + NF_valor + " | Número: " + numero_NF);
                }

                case 2 -> {
                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = sc.nextLine();

                    System.out.print("Digite o imposto (051) dentro de SP ou (054) fora de SP: ");
                    int imposto = sc.nextInt();

                    System.out.print("Digite o preço do produto: ");
                    double preco = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Produto \"" + nomeProduto + "\" cadastrado com imposto " + imposto + " e valor R$" + preco);
                }

                case 3 -> {
                    System.out.print("Digite o nome do usuário: ");
                    String nomeUsuario = sc.nextLine();

                    System.out.print("Digite a idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Digite a nacionalidade: ");
                    String nacionalidade = sc.nextLine();

                    System.out.println("Usuário \"" + nomeUsuario + "\" cadastrado com sucesso!");
                    System.out.println("Idade: " + idade + " | Nacionalidade: " + nacionalidade);
                }

                case 4 -> {
                    System.out.print("Digite o número do orçamento: ");
                    int orcamento = sc.nextInt();
                    System.out.println("Orçamento nº " + orcamento + " registrado com sucesso!");
                }

                case 5 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida, tente novamente!");
            }

        } while (opcao != 5);

        sc.close();
    }
}
