package com.a550nmr.meusalunos;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by ramal on 13/03/2018.
 */
@Database(entities = {AlunoEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract AlunoDAO alunoDAO();
}
