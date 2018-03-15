package com.a550nmr.meusalunos;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView listView;
    private AppDatabase appDatabase;
    private List<AlunoEntity> listAlunoEntity;
    private AlunoDAO alunoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);


        // Observação: As referencias à base de dados não devem estar dentro de uma Activity
        //             Colocamos aqui para facilitar o exemplo
       appDatabase = Room.databaseBuilder(this, AppDatabase.class, "db-alunos")
                .allowMainThreadQueries()   //permite o funcionanemnto de Room na main thread
                .build();

        // Inicializar a ListVew com o Adapter criado
        ArrayList <Aluno> arrayListAluno = new ArrayList<>();
        AlunoArrayAdapter alunoArrayAdapter = new AlunoArrayAdapter(this, R.layout.activity_lista_alunos, arrayListAluno);
        listView = findViewById(R.id.listview_alunos);
        listView.setAdapter(alunoArrayAdapter);

        alunoDAO = appDatabase.alunoDAO();

        listAlunoEntity = alunoDAO.getAlunos();

        // Preencher a lista de alunos
        for ( int i=0; i<listAlunoEntity.size(); i++  ){
            Aluno aluno = new Aluno();
            aluno.setId(listAlunoEntity.get(i).getId());
            aluno.setNumero(listAlunoEntity.get(i).getNumero());
            aluno.setNome(listAlunoEntity.get(i).getNome());
            aluno.setTurma(listAlunoEntity.get(i).getTurma());
            arrayListAluno.add(aluno);
        }

    }
}
