package com.a550nmr.meusalunos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Método para abrir a interface relativa à activity NovoAlunoActivity
     * @param view Objeto View que foi clicado
     */
    public void AbrirInterfaceNovoAluno(View view){
        Intent intent = new Intent(this, NovoAlunoActivity.class);
        startActivity(intent);
    }

    public void AbrirInterfaceListaAlunos(View view) {
        Intent intent = new Intent(this, ListaAlunosActivity.class);
        startActivity(intent);
    }

}
