package model;

import java.time.LocalDate;

import intefaces.Debitavel;

public abstract class Conta implements Debitavel {

    private int agencia;
    private int numero;
    protected double saldo;
    private LocalDate dataAbertura;
    private Cliente cliente;
    private int variacao;

    
    public Conta(int agencia, int numero, double saldo, LocalDate dataAbertura, Cliente cliente, int variacao) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.cliente = cliente;
        this.variacao = variacao;
    }

    public boolean depositar(double valor){
        //TODO: Verificar problemas no preenchimento
        saldo += valor;
        return true;
    }

    public abstract boolean sacar(double valor);
    
    public int getAgencia() {
        return agencia;
    }
    

    public int getVariacao() {
		return variacao;
	}

	public void setVariacao(int variacao) {
		this.variacao = variacao;
	}

	public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
