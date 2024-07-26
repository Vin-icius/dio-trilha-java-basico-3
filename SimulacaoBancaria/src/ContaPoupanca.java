public class ContaPoupanca extends Conta {
    private int numeroSaquesGratuitos;
    private int saquesRealizados;

    public ContaPoupanca(double saldo, int agencia, int numero,
                         Fisica cliente, Transacoes transacoes,int numeroSaquesGratuitos) {
        super(saldo, agencia, numero, cliente,transacoes);
        this.numeroSaquesGratuitos = numeroSaquesGratuitos;
        this.saquesRealizados = 0;
    }

    public int getNumeroSaquesGratuitos() {
        return numeroSaquesGratuitos;
    }

    public void setNumeroSaquesGratuitos(int numeroSaquesGratuitos) {
        this.numeroSaquesGratuitos = numeroSaquesGratuitos;
    }

    public int getSaquesRealizados() {
        return saquesRealizados;
    }

    public void setSaquesRealizados(int saquesRealizados) {
        this.saquesRealizados = saquesRealizados;
    }

    //METODOS

    @Override
    public boolean sacar(double valor) {
        if (super.sacar(valor)) {
            saquesRealizados++;
            if (saquesRealizados > numeroSaquesGratuitos) {
                saldo -= 2.00; // Taxa por saque adicional
            }
            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor) {
        super.depositar(valor);
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        super.transferir(valor, contaDestino);
    }

    @Override
    public void imprimirExtrato() {
        super.imprimirExtrato();
    }
}
