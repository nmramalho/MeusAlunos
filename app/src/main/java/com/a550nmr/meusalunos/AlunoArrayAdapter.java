package com.a550nmr.meusalunos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ramal on 14/03/2018.
 */

public class AlunoArrayAdapter extends ArrayAdapter<Aluno> {

    private int listaAlunosLayout;

    public AlunoArrayAdapter(@NonNull Context context, int resource, @NonNull List<Aluno> objects) {
        super(context, resource, objects);
        listaAlunosLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Obter os dados do item para a devida posição
        Aluno aluno = getItem(position);

        //verifica se uma view está a ser reutilizada, caso contrário preenche a view
        ViewHolder viewHolder; // procura se está em cache na view

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_aluno, parent, false);
            viewHolder.txtId = convertView.findViewById(R.id.textViewID);
            viewHolder.txtNumero = convertView.findViewById(R.id.textViewNumero);
            viewHolder.txtNome = convertView.findViewById(R.id.textViewNome);
            viewHolder.txtTurma = convertView.findViewById(R.id.textViewTurma);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Cploca os dados na view template utilizando os dados do objeto turma
        viewHolder.txtId.setText(String.valueOf(aluno.getId()));
        viewHolder.txtNumero.setText(String.valueOf(aluno.getNumero()));
        viewHolder.txtNome.setText(aluno.getNome());
        viewHolder.txtTurma.setText(aluno.getTurma());

        // Devolve a view completa para apresentar no ecra
        return convertView;
    }


    /**
     * Classe ViewHolder
     */
    static class ViewHolder
    {
        TextView txtId;
        TextView txtNumero;
        TextView txtNome;
        TextView txtTurma;
    }


}
