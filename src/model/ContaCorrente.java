package model;

import java.time.LocalDate;

import intefaces.Transferivel;


public class ContaCorrente extends Conta implements Transferivel{

    private double taxaManutencao;

    public ContaCorrente(int agencia, int numero, double saldo, LocalDate dataAbertura, Cliente cliente, int variacao, double taxaManutencao) {
        super(agencia, numero, saldo, dataAbertura, cliente, variacao);
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
    
    public boolean transferir(Conta destino, double valor) {
        if (valor <= getSaldo() + getCliente().getLimiteCredito()) {
            this.sacar(valor);
            destino.depositar(valor);
            return true;
        } else {
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
