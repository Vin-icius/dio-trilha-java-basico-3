public class Fisica extends Pessoa{

    private String cpf;
    private String data_nasc;
    private String genero;

    public Fisica(String nome, String cpf, String data_nasc, String genero) {
        super(nome);
        this.cpf = cpf;
        this.data_nasc = data_nasc;
        this.genero = genero;
    }

    public Fisica(String cpf, String data_nasc, String genero) {
        this.cpf = cpf;
        this.data_nasc = data_nasc;
        this.genero = genero;
    }

    public Fisica() {
        super("");
        this.cpf = "";
        this.data_nasc = "";
        this.genero = "";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
