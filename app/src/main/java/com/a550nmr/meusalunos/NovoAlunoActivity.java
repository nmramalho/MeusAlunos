package com.a550nmr.meusalunos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NovoAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_aluno);
    }

    public void GuardarNovoAluno(View view) {

        // aceder aos elementos do layout
        EditText editTextNumero = findViewById(R.id.editTextNumero);
        EditText editTextNome = findViewById(R.id.editTextNome);
        EditText editTextTurma = findViewById(R.id.editTextTurma);

        // ler os valores provenientes dos elementos do layout
        long numero = Long.parseLong(editTextNumero.getText().toString());
        String nome = editTextNome.getText().toString();
        String turma = editTextTurma.getText().toString();

        // criar uma nova instância da classe Aluno
        Aluno aluno = new Aluno(numero, nome, turma);

        String msg = "ALUNO CRIADO:\n - Nº: " + aluno.getNumero() +
                     "\n - Nome:" + aluno.getNome() +
                     "\n - Turma " + aluno.getTurma();

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }
}
