package com.example.lector_rfid.application.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lector_rfid.R;

import java.util.List;

// Clase modelo para representar un Activo
public class ActivoAdapter extends RecyclerView.Adapter<ActivoAdapter.ActivoViewHolder> {

    private final List<Activo> activos;

    // Constructor
    public ActivoAdapter(List<Activo> activos) {
        this.activos = activos;
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

    // Clase ViewHolder
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

    // Clase modelo Activo
    public static class Activo {
        private final String codigoRFID;
        private final String tipoActivo;
        private final String descripcion;
        private final String responsable;
        private final String categoria;
        private final String ubicacion;
        private final String estado;

        public Activo(String codigoRFID, String tipoActivo, String descripcion, String responsable, String categoria, String ubicacion, String estado) {
            this.codigoRFID = codigoRFID;
            this.tipoActivo = tipoActivo;
            this.descripcion = descripcion;
            this.responsable = responsable;
            this.categoria = categoria;
            this.ubicacion = ubicacion;
            this.estado = estado;
        }

        public String getCodigoRFID() {
            return codigoRFID;
        }

        public String getTipoActivo() {
            return tipoActivo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getResponsable() {
            return responsable;
        }

        public String getCategoria() {
            return categoria;
        }

        public String getUbicacion() {
            return ubicacion;
        }

        public String getEstado() {
            return estado;
        }
    }
}
