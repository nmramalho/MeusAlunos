/**
 * Created by ramal on 07/03/2018.
 */

public class Aluno {

    private long Id;
    private String numero;
    private String nome;
    private String turma;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
