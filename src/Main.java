import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Endereco;
import model.PessoaFisica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista para armazenar contas corrente 
        ArrayList<ContaCorrente> contasCorrente = new ArrayList<ContaCorrente>();
        // Lista para armazenar contas poupança
        ArrayList<ContaPoupanca> contasPoupanca = new ArrayList<ContaPoupanca>();

        int opcaoConta;
        do {
            // Menu para criar nova conta corrente, poupança ou sair
            System.out.println("1- Nova conta corrente\n" +
                    "2- Nova conta poupança\n" +
                    "0 - Sair\n");
            opcaoConta = Integer.parseInt(scanner.nextLine());
            if (opcaoConta == 1) {
                // Cria uma nova conta corrente e a adiciona à lista
                Cliente cliente = new PessoaFisica(1000, new Endereco("Rua A", 30, "Cajazeiras"), "111.111.111-01", "João", LocalDate.of(1990, 1, 1));
                ContaCorrente contaCorrente = new ContaCorrente(1, 0, 0, LocalDate.now(), cliente, 26, 20);
                System.out.println("Sua agência é:" + contaCorrente.getAgencia());
                // Pede o numero da conta (devo adicionar um auto-increment)
                System.out.println("\n Qual será o número da conta?\n");
                contaCorrente.setNumero(Integer.parseInt(scanner.nextLine()));
              //adiciona no array list
                contasCorrente.add(contaCorrente);
            } else if (opcaoConta == 2) {
                // Cria uma nova conta poupança e a adiciona à lista
                Cliente cliente = new PessoaFisica(1000, new Endereco("Rua B", 20, "Cajazeiras"), "101.011.110-10", "Paulo", LocalDate.of(1999, 2, 3));
                ContaPoupanca contaPoupanca = new ContaPoupanca(1, 0, 0, LocalDate.now(), cliente, 0.10, 51);
                System.out.println("Sua agência é: \n" + contaPoupanca.getAgencia());
                // Pede o numero da conta (devo adicionar um auto-increment)
                System.out.println("Qual será o número da conta?\n");
                contaPoupanca.setNumero(Integer.parseInt(scanner.nextLine()));
                //adiciona no array list
                contasPoupanca.add(contaPoupanca);
            }
        } while (opcaoConta != 0);

        int opcao;
        do {
            int numeroConta;
            // Menu para realizar operações de depósito e saque em contas
            System.out.println("1--Depositar poupança--\n" +
                    "2--Depositar Corrente--\n" +
                    "3--Sacar Corrente--\n" +
                    "4--Sacar Poupança--\n" +
                    "0--Sair--\n");
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    System.out.println("Em qual conta deseja depositar?\n");
                    numeroConta = Integer.parseInt(scanner.nextLine());
                    for (ContaPoupanca contaPoupanca : contasPoupanca) {
                        if (numeroConta == contaPoupanca.getNumero()) {
                            System.out.println("Qual valor deseja depositar?\n");
                            double valor = Double.parseDouble(scanner.nextLine());
                            contaPoupanca.depositar(valor);
                            System.out.println("Valor depositado. Saldo da conta agora é:" + contaPoupanca.getSaldo());
                        } else {
                            System.out.println("Conta não encontrada");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Em qual conta deseja depositar?\n");
                    numeroConta = Integer.parseInt(scanner.nextLine());
                    for (ContaCorrente contaCorrente : contasCorrente) {
                        if (numeroConta == contaCorrente.getNumero()) {
                            System.out.println("Qual valor deseja depositar?\n");
                            double valor = Double.parseDouble(scanner.nextLine());
                            contaCorrente.depositar(valor);
                            System.out.println("Valor depositado. Saldo da conta agora é:" + contaCorrente.getSaldo());
                        } else {
                            System.out.println("Conta não encontrada");
                        }
                    }
                    break;
                case 3:
                    System.out.println("De qual conta deseja sacar?\n");
                    numeroConta = Integer.parseInt(scanner.nextLine());
                    for (ContaCorrente contaCorrente : contasCorrente) {
                        if (numeroConta == contaCorrente.getNumero()) {
                            System.out.println("Qual valor deseja sacar?\n");
                            double valor = Double.parseDouble(scanner.nextLine());
                            boolean sacado = contaCorrente.sacar(valor);
                            if (sacado) {
                                System.out.println("Valor sacado. Saldo da conta agora é:" + contaCorrente.getSaldo());
                            } else {
                                System.out.println("Saldo insuficiente");
                            }
                        } else {
                            System.out.println("Conta não encontrada");
                        }
                    }
                    break;
                case 4:
                    System.out.println("De qual conta deseja sacar?\n");
                    numeroConta = Integer.parseInt(scanner.nextLine());
                    for (ContaPoupanca contaPoupanca : contasPoupanca) {
                        if (numeroConta == contaPoupanca.getNumero()) {
                            System.out.println("Qual valor deseja sacar?\n");
                            double valor = Double.parseDouble(scanner.nextLine());
                            boolean sacado = contaPoupanca.sacar(valor);
                            if (sacado) {
                                System.out.println("Valor sacado. Saldo da conta agora é:" + contaPoupanca.getSaldo());
                            } else {
                                System.out.println("Saldo insuficiente");
                            }
                        } else {
                            System.out.println("Conta não encontrada");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    break;
            }
        } while (opcao != 0);

        // Código comentado para ajudar com formatação de datas
        /*
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd/MM/yyyy");
        String string = "29/02/2000";
        LocalDate localDate = LocalDate.parse(string, formatter);
        System.out.println(localDate.format(formatter));
        */
    }
}
