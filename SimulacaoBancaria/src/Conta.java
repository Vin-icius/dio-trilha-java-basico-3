import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Conta implements IConta{
    protected double saldo;
    protected int agencia;
    protected int numero;
    protected Fisica cliente;
    protected List<Transacoes> transacoes;

    public Conta(double saldo, int agencia, int numero, Fisica cliente, Transacoes transacoes) {
        this.saldo = saldo;
        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
    }

    public Conta() {
        this(0L,0,0,null,null);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            Transacoes t = new Transacoes(cliente,numero,LocalDate.now(),saldo,(saldo -= valor),"Saque.");
            saldo -= valor;
            transacoes.add(t);

            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            Transacoes t = new Transacoes(cliente,numero,LocalDate.now(),saldo,(saldo += valor),"Deposito.");
            saldo += valor;
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        Transacoes t = new Transacoes(cliente,numero,LocalDate.now(),saldo,(saldo -= valor),"Transferencia.");
        contaDestino.depositar(valor);
        saldo -= valor;
    }

    @Override
    public void imprimirExtrato() {
        for(Transacoes e:transacoes) {
            System.out.println("Cliente: ["+e.getCliente().getNome()+"]");
            System.out.println("Data: ["+e.getData().toString()+"]");
            System.out.println("Movimento: [" + e.getDescricao() + "]");
            System.out.println("Saldo anterior: ["+e.getSaldoAnterior()+"]");
            System.out.println("Saldo atualizado: ["+e.getSaldoAtualizado()+"]");
        }
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }
}
