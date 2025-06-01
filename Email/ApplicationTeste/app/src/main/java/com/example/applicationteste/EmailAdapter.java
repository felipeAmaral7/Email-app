package com.example.applicationteste;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationteste.model.Email;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder>{
    private final List<Email> emails;

    public EmailAdapter(List<Email> emails) {
        this.emails = emails;
    }

    public List<Email> getEmails() {
        return emails;
    }

    class EmailViewHolder extends RecyclerView.ViewHolder{

        TextView textUser;
        TextView textIcon;
        TextView textAssunto;
        TextView textPreview;
        TextView date;
        ImageView stared;
        EmailViewHolder(@NonNull View itemView){
            super(itemView);
            textUser = itemView.findViewById(R.id.text_user);
            textIcon = itemView.findViewById(R.id.text_icon);
            textAssunto = itemView.findViewById(R.id.text_assunto);
            textPreview = itemView.findViewById(R.id.text_preview);
            date = itemView.findViewById(R.id.text_date);
            stared = itemView.findViewById(R.id.img_star);
        }

        void bind(Email email) {
            int hash = email.getAssunto().hashCode();
            textUser.setText(email.getUsuario());
            textIcon.setText(String.valueOf(email.getUsuario().charAt(0)));
            textIcon.setBackground(oval(Color.rgb(hash, hash/2, 0), textIcon));
            textAssunto.setText(email.getAssunto());
            textPreview.setText(email.getPreview());
            date.setText(email.getDate());

            textUser.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
            textAssunto.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
            date.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
            stared.setImageResource(email.isStared() ? R.drawable.baseline_star_24 : R.drawable.baseline_star_border_24);

        }
    }

    private static ShapeDrawable oval(@ColorInt int color, View view){
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(view.getHeight());
        shapeDrawable.setIntrinsicWidth(view.getWidth());
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.email_item, parent, false);

        return new EmailViewHolder(view);
    }

    //quando houver necessidade de reciclar uma view, ele que atribui cada elemento (podemos fazer
    //algum tipo de atribuicao aqui dentro)
    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        Email email = emails.get(position);
        holder.bind(email);

    }

    //Quantidade de elementos que a minha lista tem (quantas linhas ele vai ter que construir
    @Override
    public int getItemCount() {
        return this.emails.size();
    }

    public void addEmail(Email email){
        emails.add(0, email);
    }
}
