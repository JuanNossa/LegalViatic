package com.example.legalviatic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


import de.hdodenhof.circleimageview.CircleImageView;

public class adapteListaUsuarios extends FirebaseRecyclerAdapter<modelListaUsuarios, adapteListaUsuarios.myViewHolder>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public adapteListaUsuarios(@NonNull FirebaseRecyclerOptions<modelListaUsuarios> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull modelListaUsuarios model) {
        holder.name.setText(model.getNombres());
        holder.documento.setText(model.getDocumento());
        holder.saldo.setText(model.getSaldo());
        holder.correo.setText(model.getCorreo());
        holder.tipoUser.setText(model.getTipoUsuario());

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_item,parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView name, documento, saldo, correo, tipoUser;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.img1);
            name = (TextView)itemView.findViewById(R.id.nombreText);
            documento = (TextView)itemView.findViewById(R.id.documentoText);
            saldo = (TextView)itemView.findViewById(R.id.saldoText);
            correo = (TextView)itemView.findViewById(R.id.correoText);
            tipoUser = (TextView)itemView.findViewById(R.id.tipoUsuarioText);
        }
    }
}
