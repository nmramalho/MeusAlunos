package com.a550nmr.meusalunos;

/**
 * Created by ramal on 07/03/2018.
 */

public class Aluno {

    private long Id;
    private long numero;
    private String nome;
    private String turma;

    public long getId() {
        return Id;
    }

    public Aluno() {
    }

    public Aluno(long id, long numero, String nome, String turma) {
        Id = id;
        this.numero = numero;
        this.nome = nome;
        this.turma = turma;
    }

    public Aluno(long numero, String nome, String turma) {
        this.numero = numero;
        this.nome = nome;
        this.turma = turma;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
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
