package com.a550nmr.meusalunos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by ramal on 13/03/2018.
 */
@Dao
public interface AlunoDAO {
    @Insert
    public void insert(AlunoEntity... aluno);

    @Update
    public void update(AlunoEntity... aluno);

    @Delete
    public void delete(AlunoEntity... aluno);

    @Query("SELECT * FROM Aluno")
    public List<AlunoEntity> getAlunos();

    @Query("SELECT * FROM Aluno WHERE id = :id")
    public AlunoEntity getContactWithId(long id);

    @Query("SELECT * FROM Aluno WHERE turma = :turma")
    public AlunoEntity getAlunosPorTurma(String turma);

}
