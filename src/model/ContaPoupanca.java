package model;

import java.time.LocalDate;

import intefaces.Transferivel;

public class ContaPoupanca extends Conta implements Transferivel{

    private double taxaJuros;

    public ContaPoupanca(int agencia, int numero, double saldo, LocalDate dataAbertura, Cliente cliente, double taxaJuros, int variacao) {
        super(agencia, numero, saldo, dataAbertura, cliente, variacao);
        this.taxaJuros = taxaJuros;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    @Override
    public boolean sacar(double valor) {
        //TODO: verificar as restrições
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean transferir(Conta destino, double valor) {
        if (valor <= getSaldo()) {
            this.sacar(valor);
            destino.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean renderJuros(){
        saldo += saldo*taxaJuros/100;
        return true;
    }
}