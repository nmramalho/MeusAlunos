package com.a550nmr.meusalunos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ramal on 15/03/2018.
 */

public class ListaAlunosAdapter extends RecyclerView.Adapter<ListaAlunosAdapter.AlunoViewHolder> {

    class AlunoViewHolder extends RecyclerView.ViewHolder {

        private final TextView txtId;
        private final TextView txtNumero;
        private final TextView txtNome;
        private final TextView txtTurma;

        private AlunoViewHolder(View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.textViewID);
            txtNumero = itemView.findViewById(R.id.textViewNumero);
            txtNome = itemView.findViewById(R.id.textViewNome);
            txtTurma = itemView.findViewById(R.id.textViewTurma);

        }
    }

    private final LayoutInflater mInflater;
    private List<AlunoEntity> alunoEntities; // Dados em cache

    ListaAlunosAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public AlunoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_aluno, parent, false);
        return new AlunoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlunoViewHolder holder, int position) {

        if (alunoEntities != null) {
            AlunoEntity alunoEntity = alunoEntities.get(position);
            holder.txtId.setText(String.valueOf(alunoEntity.getId()));
            holder.txtNumero.setText(String.valueOf(alunoEntity.getNumero()));
            holder.txtNome.setText(alunoEntity.getNome());
            holder.txtTurma.setText(alunoEntity.getTurma());


        } else {
            // No caso dos dados ainda não estarem disponíveis.
            holder.txtId.setText(" Sem dados ");
            holder.txtNumero.setText(" Sem dados ");
            holder.txtNome.setText(" Sem dados ");
            holder.txtTurma.setText(" Sem dados ");
        }
    }


    void setAlunoEntities(List<AlunoEntity> words){
        alunoEntities = words;
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        if (alunoEntities != null)
            return alunoEntities.size();
        else return 0;
    }
}
