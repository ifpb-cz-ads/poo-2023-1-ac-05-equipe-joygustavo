package model;

import java.time.LocalDate;

public class ContaPoupanca extends Conta{

    private double taxaJuros;

    public ContaPoupanca(int agencia, int numero, double saldo, LocalDate dataAbertura, Cliente cliente, double taxaJuros) {
        super(agencia, numero, saldo, dataAbertura, cliente);
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

    public boolean renderJuros(){
        saldo += saldo*taxaJuros/100;
        return true;
    }

}