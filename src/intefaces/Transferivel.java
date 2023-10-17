package intefaces;

import model.Conta;

public interface Transferivel {
    boolean transferir(Conta destino, double valor);
}
