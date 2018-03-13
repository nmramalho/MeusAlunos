package com.a550nmr.meusalunos;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class NovoAlunoActivity extends AppCompatActivity {

    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_aluno);

        // Observação: As referencias à base de dados não devem estar dentro de uma Activity
        //             Colocamos aqui para facilitar o exemplo
        appDatabase = Room.databaseBuilder(this, AppDatabase.class, "db-alunos")
                .allowMainThreadQueries()   //permite o funcionanemnto de Room na main thread
                .build();
    }

    public void GuardarNovoAluno(View view) {

        // aceder aos elementos do layout
        EditText editTextNumero = findViewById(R.id.editTextNumero);
        EditText editTextNome = findViewById(R.id.editTextNome);
        EditText editTextTurma = findViewById(R.id.editTextTurma);

        // ler os valores provenientes dos elementos do layout
        int numero = Integer.parseInt(editTextNumero.getText().toString());
        String nome = editTextNome.getText().toString();
        String turma = editTextTurma.getText().toString();

        // criar uma nova instância da classe Aluno
        Aluno aluno = new Aluno(numero, nome, turma);

        String msg = "ALUNO CRIADO:\n - Nº: " + aluno.getNumero() +
                     "\n - Nome:" + aluno.getNome() +
                     "\n - Turma " + aluno.getTurma();

        // Mostar alunos no visor recorrendo a uma Toast
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();


        // Inserir aluno da base de dados
        AlunoEntity alunoEntity = new AlunoEntity();
        alunoEntity.setNumero(aluno.getNumero());
        alunoEntity.setNome(aluno.getNome());
        alunoEntity.setTurma(aluno.getTurma());

        AlunoDAO alunoDAO = appDatabase.alunoDAO();
        alunoDAO.insert(alunoEntity);


        // verificar em log os alunos introduzidos

        List<AlunoEntity> alunoEntities = alunoDAO.getAlunos();


        Log.d("NovoAlunoActivity"," ------  LISTA DE ALUNOS ---------");

        for (AlunoEntity alunoE : alunoEntities){
            Log.d("NovoAlunoActivity", " -> " + Long.toString(alunoE.getId())
                                                + " / " + Integer.toString(alunoE.getNumero())
                                                + " / " + alunoE.getNome()
                                                + " / " + alunoE.getTurma()
                        );
        }

        Log.d("NovoAlunoActivity"," --------------------------------------");
    }
}
