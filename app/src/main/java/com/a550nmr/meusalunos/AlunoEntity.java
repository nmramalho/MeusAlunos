package com.a550nmr.meusalunos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ramal on 13/03/2018.
 */
@Entity(tableName = "Aluno")
public class AlunoEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "numero")
    private int numero;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "turma")
    private String turma;

   public AlunoEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
