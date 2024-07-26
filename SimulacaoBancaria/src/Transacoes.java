import java.time.LocalDate;

public class Transacoes {
    private Fisica cliente;
    private int numeroConta;
    private LocalDate data;
    private double saldoAnterior;
    private double saldoAtualizado;
    private String descricao;

    public Transacoes(Fisica cliente, int numeroConta, LocalDate data, double saldoAnterior, double saldoAtualizado, String descricao) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.data = data;
        this.saldoAnterior = saldoAnterior;
        this.saldoAtualizado = saldoAtualizado;
        this.descricao = descricao;
    }

    public Transacoes() {
        this(null,0,null,0L,0L,"");
    }

    public Fisica getCliente() {
        return cliente;
    }

    public void setCliente(Fisica cliente) {
        this.cliente = cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public double getSaldoAtualizado() {
        return saldoAtualizado;
    }

    public void setSaldoAtualizado(double saldoAtualizado) {
        this.saldoAtualizado = saldoAtualizado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
