package com.example.lector_rfid.application.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lector_rfid.domain.entities.Auditoria;

import java.util.List;

public class AuditoriasAdapter extends RecyclerView.Adapter<AuditoriasAdapter.AuditoriasViewHolder> {

    private final Context context;
    private final List<Auditoria> auditorias;

    public interface OnItemClickListener {
        void onItemClick(Auditoria auditoria);
    }

    private final OnItemClickListener listener;

    public AuditoriasAdapter(Context context, List<Auditoria> auditorias, OnItemClickListener listener) {
        this.context = context;
        this.auditorias = auditorias;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AuditoriasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(context).inflate(R.layout.item_auditoria, parent, false);
       // return new AuditoriasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AuditoriasViewHolder holder, int position) {
        Auditoria auditoria = auditorias.get(position);

        // Configurar nombre y contador
        holder.tvName.setText(auditoria.getName());
       // holder.tvCount.setText(String.valueOf(auditoria.getCount()));

        // Acción al hacer clic en el botón de flecha
        holder.btnArrow.setOnClickListener(v -> listener.onItemClick(auditoria));
    }

    @Override
    public int getItemCount() {
        return auditorias.size();
    }

    static class AuditoriasViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCount;
        ImageButton btnArrow;

        public AuditoriasViewHolder(@NonNull View itemView) {
            super(itemView);
           // tvName = itemView.findViewById(R.id.tv_auditoria_name);
           // tvCount = itemView.findViewById(R.id.tv_auditoria_count);
           // btnArrow = itemView.findViewById(R.id.btn_arrow);
        }
    }
}
