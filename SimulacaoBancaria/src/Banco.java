import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Fisica> clientes;
    private List<Conta> contas;

    // Construtor
    public Banco(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    // Métodos para gerenciar clientes
    public void adicionarCliente(Fisica cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            System.out.println("Cliente [" + cliente.getNome() + "] adicionado com sucesso.");
        } else {
            System.out.println("Cliente já existe.");
        }
    }

    public Fisica buscarClientePorCPF(String cpf) {
        for (Fisica cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    // Métodos para gerenciar contas
    public void criarContaCorrente(double saldo, int agencia, int numero,
                                   Fisica cliente,Transacoes transacoes,
                                   double limiteChequeEspecial, double taxaManutencao,
                                   double taxaJurosChequeEspecial, int numeroCheques,
                                   boolean cartaoDebito) {

        ContaCorrente contaCorrente = new ContaCorrente(saldo,agencia,numero,cliente,transacoes,limiteChequeEspecial,taxaManutencao,
                taxaJurosChequeEspecial,numeroCheques,cartaoDebito);
        contas.add(contaCorrente);
        System.out.println("Conta Corrente criada com sucesso para [" + cliente.getNome()+"]");
    }

    public void criarContaPoupanca(double saldo, int agencia, int numero,
                                   Fisica cliente, Transacoes transacoes,int numeroSaquesGratuitos) {
        ContaPoupanca contaPoupanca = new ContaPoupanca(saldo,agencia,numero,cliente,transacoes,numeroSaquesGratuitos);
        contas.add(contaPoupanca);
        System.out.println("Conta Poupança criada com sucesso para [" + cliente.getNome()+"]");
    }

    public Conta buscarContaPorNumero(int numeroConta) {
        for (Conta conta : contas) {
            if(conta instanceof ContaCorrente) {
                if (conta.numero==numeroConta) {
                    return conta;
                }
            }
        }
        return null;
    }

    // Métodos para operações bancárias
    public boolean transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        Conta contaOrigem = buscarContaPorNumero(numeroContaOrigem);
        Conta contaDestino = buscarContaPorNumero(numeroContaDestino);

        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.sacar(valor)) {
                contaDestino.depositar(valor);
                System.out.println("Transferência de " + valor + " realizada com sucesso de " + contaOrigem.numero + " para " + contaDestino.numero);
                return true;
            } else {
                System.out.println("Saldo insuficiente para transferência.");
            }
        } else {
            System.out.println("Uma das contas não foi encontrada.");
        }
        return false;
    }

    // Exibe todas as contas e seus saldos
    public void exibirContas() {
        for (Conta conta : contas) {
            System.out.println("Conta Número: " + conta.numero + ", Titular: " + conta.cliente.getNome() + ", Saldo: "
                    + conta.consultarSaldo());
        }
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Fisica> getClientes() {
        return clientes;
    }

    public void setClientes(List<Fisica> clientes) {
        this.clientes = clientes;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
