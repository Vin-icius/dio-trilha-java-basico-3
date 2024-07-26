public class ContaCorrente extends Conta {

    private double limiteChequeEspecial;
    private double taxaManutencao;
    private double taxaJurosChequeEspecial;
    private int numeroCheques;
    private boolean cartaoDebito;

    public ContaCorrente(double saldo, int agencia, int numero, Fisica cliente,Transacoes transacoes, double limiteChequeEspecial, double taxaManutencao, double taxaJurosChequeEspecial, int numeroCheques, boolean cartaoDebito) {
        super(saldo, agencia, numero, cliente,transacoes);
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.taxaManutencao = taxaManutencao;
        this.taxaJurosChequeEspecial = taxaJurosChequeEspecial;
        this.numeroCheques = numeroCheques;
        this.cartaoDebito = cartaoDebito;
    }

    public ContaCorrente(double limiteChequeEspecial, double taxaManutencao, double taxaJurosChequeEspecial, int numeroCheques, boolean cartaoDebito) {
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.taxaManutencao = taxaManutencao;
        this.taxaJurosChequeEspecial = taxaJurosChequeEspecial;
        this.numeroCheques = numeroCheques;
        this.cartaoDebito = cartaoDebito;
    }

    public ContaCorrente() {
        super(0L, 0, 0, null,null);
        this.limiteChequeEspecial = 0L;
        this.taxaManutencao = 0L;
        this.taxaJurosChequeEspecial = 0L;
        this.numeroCheques = 0;
        this.cartaoDebito = false;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(double taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }

    public double getTaxaJurosChequeEspecial() {
        return taxaJurosChequeEspecial;
    }

    public void setTaxaJurosChequeEspecial(double taxaJurosChequeEspecial) {
        this.taxaJurosChequeEspecial = taxaJurosChequeEspecial;
    }

    public int getNumeroCheques() {
        return numeroCheques;
    }

    public void setNumeroCheques(int numeroCheques) {
        this.numeroCheques = numeroCheques;
    }

    public boolean isCartaoDebito() {
        return cartaoDebito;
    }

    public void setCartaoDebito(boolean cartaoDebito) {
        this.cartaoDebito = cartaoDebito;
    }

    // METODOS

    public void calcularTarifaManutencao() {
        saldo -= taxaManutencao;
    }

    public boolean usarChequeEspecial(double valor) {
        if (valor > 0 && (saldo + limiteChequeEspecial) >= valor) {
            saldo -= valor;
            saldo -= valor * (taxaJurosChequeEspecial / 100); // Aplicando juros
            return true;
        }
        return false;
    }

    public boolean emitirCheque(double valor, String beneficiario) {
        if (valor > 0 && numeroCheques > 0 && super.sacar(valor)) {
            numeroCheques--;
            // Lógica para processar cheque
            return true;
        }
        return false;
    }

    @Override
    public boolean sacar(double valor) {
        return super.sacar(valor);
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
