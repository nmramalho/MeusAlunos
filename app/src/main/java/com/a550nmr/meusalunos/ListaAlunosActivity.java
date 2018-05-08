package com.a550nmr.meusalunos;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    private AlunoViewModel alunoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ListaAlunosAdapter adapter = new ListaAlunosAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        alunoViewModel = ViewModelProviders.of(this).get(AlunoViewModel.class);

        // Adicionar observer na LiveData returned by getTodosAlunos.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        alunoViewModel.getTodosAlunos().observe(this, new Observer<List<AlunoEntity>>() {
            @Override
            public void onChanged(@Nullable final List<AlunoEntity> alunoEntities) {
                // Update the cached copy of the alunos in the adapter.
                adapter.setAlunoEntities(alunoEntities);
            }
        });


    }
}
