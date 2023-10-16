package model;

public abstract class Cliente {

    private double limiteCredito;
    private Endereco endereco;

    public Cliente(double limiteCredito, Endereco endereco) {
        this.limiteCredito = limiteCredito;
        this.endereco = endereco;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
