package intefaces;

import model.Conta;

public interface Transferivel {
    boolean transferir(Conta conta, double valor);
}
