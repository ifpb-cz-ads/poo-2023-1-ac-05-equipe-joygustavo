package model;

import java.time.LocalDate;

public class PessoaFisica extends Cliente{

    private String cpf;
    private String nome;
    private LocalDate nascimento;

    public PessoaFisica(double limiteCredito, Endereco endereco, String cpf, String nome, LocalDate nascimento) {
        super(limiteCredito, endereco);
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
