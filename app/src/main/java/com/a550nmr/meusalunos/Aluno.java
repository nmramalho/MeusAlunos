package com.a550nmr.meusalunos;

/**
 * Created by ramal on 07/03/2018.
 */

public class Aluno {

    private long id;
    private int numero;
    private String nome;
    private String turma;

    public long getId() {
        return id;
    }

    public Aluno() {
    }

    public Aluno(long id, int numero, String nome, String turma) {
        this.id = id;
        this.numero = numero;
        this.nome = nome;
        this.turma = turma;
    }

    public Aluno(int numero, String nome, String turma) {
        this.numero = numero;
        this.nome = nome;
        this.turma = turma;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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
