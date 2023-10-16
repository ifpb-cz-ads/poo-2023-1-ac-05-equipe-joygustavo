package model;

public class PessoaJuridica extends Cliente{

    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica(double limiteCredito, Endereco endereco, String cnpj, String razaoSocial) {
        super(limiteCredito, endereco);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
