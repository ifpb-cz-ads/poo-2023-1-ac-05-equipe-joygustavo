package model;

import java.time.LocalDate;

public class ContaCorrente extends Conta{

    private double taxaManutencao;

    public ContaCorrente(int agencia, int numero, double saldo, LocalDate dataAbertura, Cliente cliente, double taxaManutencao) {
        super(agencia, numero, saldo, dataAbertura, cliente);
        this.taxaManutencao = taxaManutencao;
    }

    @Override
    public boolean sacar(double valor){
        //TODO: Verificar as restrições
        if(valor <= saldo+getCliente().getLimiteCredito()){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }

    public boolean aplicarTaxa(){
        saldo -= taxaManutencao;
        return true;
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(double taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }
}
