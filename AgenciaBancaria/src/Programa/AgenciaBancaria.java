package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println(" Agencia bancaria: Selecione uma opcao");
        System.out.println("|  Opcao 1 - Criar conta |");
        System.out.println("|  Opcao 2 - Depositar   |");
        System.out.println("|  Opcao 3 - Sacar       |");
        System.out.println("|  Opcao 4 - Transferir  |");
        System.out.println("|  Opcao 5 - Listar      |");
        System.out.println("|  Opcao 6 - Sair        |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("numero invalido!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Cliente cliente = new Cliente(nome, cpf, email);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta c: contasBancarias) {
                if(c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Valor que deseja depositar: ");
            Double valorDeposito = input.nextDouble();

            conta.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso!");
        } else {
            System.out.println("Conta nao foi encontrada!");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Valor que deseja sacar: ");
            Double valorSaque = input.nextDouble();

            conta.sacar(valorSaque);
            System.out.println("Valor sacado com sucesso!");
        } else {
            System.out.println("Conta nao foi encontrada!");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Numero da sua conta: ");
        int numeroContaRemetente = input.nextInt();
        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("Numero da conta para transferencia: ");
            int numeroContaDestinatario = input.nextInt();
            Conta contaDestinario = encontrarConta(numeroContaDestinatario);

            if(contaDestinario != null) {
                System.out.println("Valor da transferencia: ");
                Double valor = input.nextDouble();

                contaRemetente.transferir(contaDestinario, valor);
                System.out.println(valor + " transferido com sucesso!");
            }
        } else {
            System.out.println("Conta nao foi encontrada!");
        }
        operacoes();
    }

    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for (Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("nao ha contas cadastradas!");
        }
        operacoes();
    }

}
