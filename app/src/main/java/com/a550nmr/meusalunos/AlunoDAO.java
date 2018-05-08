package com.a550nmr.meusalunos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by ramal on 13/03/2018.
 */
@Dao
public interface AlunoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AlunoEntity... aluno);

    @Query("SELECT * FROM Aluno")
    LiveData<List<AlunoEntity>> getTodosAlunos();

    @Query("DELETE FROM Aluno")
    void deleteAll();

}
