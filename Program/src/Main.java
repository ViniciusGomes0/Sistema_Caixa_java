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

        // Cadastro inicial
        System.out.println("| CADASTRO |");
        System.out.print("Digite seu nome: ");
        String cadastro = sc.nextLine();
        System.out.print("Digite sua senha (somente números): ");
        int password = sc.nextInt();

        System.out.println("\nOlá, " + cadastro + "! Serei seu assistente virtual.");
        System.out.print("Digite o valor do produto: R$ ");
        double valorProduto = sc.nextDouble();

        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("[1] Débito");
        System.out.println("[2] PIX");
        System.out.println("[3] Crédito");
        System.out.println("[4] Dinheiro");
        System.out.print("Opção: ");
        int pagamento = sc.nextInt();

        switch (pagamento) {
            case 1 -> {
                System.out.print("Digite o valor na maquininha (R$): ");
                double maquininha = sc.nextDouble();
                System.out.print("Digite a senha do cartão: ");
                int cartao = sc.nextInt();
                System.out.println("Pagamento de R$" + maquininha + " aprovado no débito!");
            }

            case 2 -> {
                System.out.print("Digite o valor do PIX (R$): ");
                double valorPix = sc.nextDouble();
                System.out.print("Digite a chave PIX (número ou CPF): ");
                String chavePix = sc.next();
                System.out.println("PIX de R$" + valorPix + " enviado para " + chavePix + " com sucesso!");
            }

            case 3 -> {
                System.out.print("Digite o valor total no crédito (R$): ");
                double valorCredito = sc.nextDouble();
                System.out.print("Digite o número de parcelas: ");
                int parcelas = sc.nextInt();
                System.out.println("Pagamento em " + parcelas + "x de R$" + (valorCredito / parcelas) + " aprovado!");
            }

            case 4 -> {
                System.out.print("Digite o valor entregue pelo cliente: R$ ");
                double valorPago = sc.nextDouble();

                if (valorPago < valorProduto) {
                    System.out.println("O cliente entregou um valor insuficiente.");
                } else {
                    Caixa caixa = new Caixa(valorProduto, valorPago);
                    double troco = caixa.calcularTroco();
                    System.out.println("Troco a ser entregue: R$ " + troco);
                }
            }

            default -> System.out.println("Opção de pagamento inválida!");
        }

        // Menu de operações
        do {
            System.out.println("\n| MENU DE OPERAÇÕES |");
            System.out.println("1 - Registrar Nota Fiscal");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Cadastrar Novo Usuário");
            System.out.println("4 - Tirar Orçamento");
            System.out.println("5 - Fechar Programa");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o valor da NF: R$ ");
                    double NF_valor = sc.nextDouble();
                    System.out.print("Digite o número da NF: ");
                    int numero_NF = sc.nextInt();
                    sc.nextLine();

                    System.out.println("NF registrada: Valor R$" + NF_valor + " | Número: " + numero_NF);
                }

                case 2 -> {
                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = sc.nextLine();

                    System.out.print("Digite o imposto (051 dentro de SP ou 054 fora de SP): ");
                    int imposto = sc.nextInt();

                    System.out.print("Digite o preço do produto: R$ ");
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
