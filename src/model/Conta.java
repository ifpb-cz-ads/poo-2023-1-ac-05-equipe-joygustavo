package model;

import java.time.LocalDate;

public abstract class Conta {

    private int agencia;
    private int numero;
    protected double saldo;
    private LocalDate dataAbertura;
    private Cliente cliente;

    public Conta(int agencia, int numero, double saldo, LocalDate dataAbertura, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.cliente = cliente;
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
