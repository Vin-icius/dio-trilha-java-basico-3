//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Criar o banco
        Banco banco = new Banco("Banco Simulação");

        // Criar clientes
        Fisica cliente1 = new Fisica("João Silva", "123.456.789-00","13/07/2004","Masculino");
        Fisica cliente2 = new Fisica("Maria Oliveira", "987.654.321-00","28/04/2000","Feminino");

        // Adicionar clientes ao banco
        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);

        // Criar contas para os clientes
        banco.criarContaCorrente(500.0, 1, 2, cliente1, null, 300.0, 5.00,2.00,5,true);
        banco.criarContaCorrente(500.0, 2, 3, cliente2, null, 300.0, 5.00,2.00,5,true);

        // Depositar valores nas contas
        Conta contaJoao = banco.buscarContaPorNumero(2);
        Conta contaMaria = banco.buscarContaPorNumero(3);

        contaJoao.depositar(1000.0);
        contaMaria.depositar(2000.0);

        // Exibir contas e saldos iniciais
        System.out.println("Contas e saldos iniciais:");
        banco.exibirContas();

        // Transferir dinheiro de João para Maria
        banco.transferir(2, 3, 200.0);

        // Exibir contas e saldos após transferência
        System.out.println("\nContas e saldos após transferência:");
        banco.exibirContas();

        // Sacar valores das contas
        contaJoao.sacar(150.0);
        contaMaria.sacar(100.0);

        // Exibir contas e saldos após saques
        System.out.println("\nContas e saldos após saques:");
        banco.exibirContas();

    }
}