package com.cimatic.lector_rfid.application.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.cimatic.lector_rfid.application.mappers.Activo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.cimatic.lector_rfid.R;

import java.util.ArrayList;
import java.util.List;

public class ActivoAdapter extends RecyclerView.Adapter<ActivoAdapter.ActivoViewHolder> {

    private final List<Activo> activos; // Lista de activos mostrados

    public ActivoAdapter(List<Activo> activos) {
        this.activos = new ArrayList<>(activos); // Evita la referencia directa
    }

    @NonNull
    @Override
    public ActivoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activo, parent, false);
        return new ActivoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivoViewHolder holder, int position) {
        Activo activo = activos.get(position);
        holder.bind(activo);
    }

    @Override
    public int getItemCount() {
        return activos.size();
    }

    // Método para actualizar la lista de activos

    public void updateList(List<Activo> nuevosActivos) {
        activos.clear();
        activos.addAll(nuevosActivos);
        notifyDataSetChanged();
    }

    public static class ActivoViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvCodigoRFID;
        private final TextView tvTipoActivo;
        private final TextView tvDescripcion;
        private final TextView tvResponsable;
        private final TextView tvCategoria;
        private final TextView tvUbicacion;
        private final TextView tvEstado;

        public ActivoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCodigoRFID = itemView.findViewById(R.id.tv_codigo_rfid);
            tvTipoActivo = itemView.findViewById(R.id.tv_tipo_activo);
            tvDescripcion = itemView.findViewById(R.id.tv_descripcion);
            tvResponsable = itemView.findViewById(R.id.tv_responsable);
            tvCategoria = itemView.findViewById(R.id.tv_categoria);
            tvUbicacion = itemView.findViewById(R.id.tv_ubicacion);
            tvEstado = itemView.findViewById(R.id.tv_estado);
        }

        public void bind(Activo activo) {
            tvCodigoRFID.setText(activo.getCodigoRFID());
            tvTipoActivo.setText(activo.getTipoActivo());
            tvDescripcion.setText(activo.getDescripcion());
            tvResponsable.setText(activo.getResponsable());
            tvCategoria.setText(activo.getCategoria());
            tvUbicacion.setText(activo.getUbicacion());
            tvEstado.setText(activo.getEstado());
        }
    }

}
