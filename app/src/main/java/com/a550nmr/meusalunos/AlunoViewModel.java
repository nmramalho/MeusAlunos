package com.a550nmr.meusalunos;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by ramal on 15/03/2018.
 */

public class AlunoViewModel extends AndroidViewModel{

    private AlunoRepository alunoRepository;

    private LiveData<List<AlunoEntity>> todosAlunos;

    public AlunoViewModel (Application application) {
        super(application);
        alunoRepository = new AlunoRepository(application);
        todosAlunos = alunoRepository.getTodosAlunos();
    }

    LiveData<List<AlunoEntity>> getTodosAlunos() {
        return todosAlunos;
    }

    public void insert(AlunoEntity alunoEntity) {
        alunoRepository.insert(alunoEntity);
    }

}
