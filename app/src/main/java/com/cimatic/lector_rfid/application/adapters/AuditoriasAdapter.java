package com.cimatic.lector_rfid.application.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cimatic.lector_rfid.R;
import com.cimatic.lector_rfid.domain.entities.Auditoria;

import java.util.List;

public class AuditoriasAdapter extends RecyclerView.Adapter<AuditoriasAdapter.ViewHolder> {

    private final List<Auditoria> auditorias;

    public AuditoriasAdapter(List<Auditoria> auditorias) {
        this.auditorias = auditorias;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_auditoria, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Auditoria auditoria = auditorias.get(position);
        holder.tvAuditoriaName.setText(auditoria.getName());
        holder.tvAuditoriaCount.setText(String.valueOf(auditoria.getCount()));
    }

    @Override
    public int getItemCount() {
        return auditorias.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAuditoriaName, tvAuditoriaCount;

        ViewHolder(View itemView) {
            super(itemView);
            tvAuditoriaName = itemView.findViewById(R.id.tv_auditoria_name);
            tvAuditoriaCount = itemView.findViewById(R.id.tv_auditoria_count);
        }
    }
}
