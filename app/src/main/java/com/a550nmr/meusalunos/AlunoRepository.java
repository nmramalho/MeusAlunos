package com.a550nmr.meusalunos;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by ramal on 15/03/2018.
 */

public class AlunoRepository {
    private AlunoDAO alunoDAO;
    private LiveData<List<AlunoEntity>> listaAlunos;

    AlunoRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        alunoDAO = db.alunoDAO();
        listaAlunos = alunoDAO.getTodosAlunos();
    }


    LiveData<List<AlunoEntity>> getTodosAlunos() {
        return listaAlunos;
    }


    public void insert (AlunoEntity word) {
        new insertAsyncTask(alunoDAO).execute(word);
    }


    private static class insertAsyncTask extends AsyncTask<AlunoEntity, Void, Void> {

        private AlunoDAO mAsyncTaskDao;

        insertAsyncTask(AlunoDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final AlunoEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
