package com.example.applicationteste;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.TouchDelegate;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.applicationteste.model.AllEmails;
import com.example.applicationteste.model.Email;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.github.serpro69.kfaker.Faker;
import io.github.serpro69.kfaker.FakerConfig;

public class MainActivity extends AppCompatActivity {
    private Faker fake;
    ItemTouchHelper longHandler;
    private EmailAdapter emailAdapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FakerConfig config = new FakerConfig.Builder().withLocale(new Locale("pt", "BR").toString()).build();
        fake = new Faker(config);

        final RecyclerView myRecyclerView = findViewById(R.id.recycler_view_main);
        emailAdapter = new EmailAdapter(new ArrayList<>(AllEmails.fakeEmails()));

        myRecyclerView.setAdapter(emailAdapter);
        listenerFab(myRecyclerView);
    }


    private void listenerFab(RecyclerView myRecyclerView){
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewEmail();
                myRecyclerView.scrollToPosition(0);
            }
        });
        longHandler = new ItemTouchHelper(
                new LongHandler(//0,
                        ItemTouchHelper.UP | ItemTouchHelper.DOWN,    //caso eu queira ordenar a lista
                        ItemTouchHelper.LEFT));
        longHandler.attachToRecyclerView(myRecyclerView);
    }

    private void addNewEmail() {
        StringBuilder preview = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            preview.append(fake.getLorem().words());
            preview.append(" ");
        }

        Email newEmail = Email.EmailBuilder.builder()
                .setUsuario(fake.getCompany().name())
                .setAssunto(fake.getLorem().words())
                .setPreview(preview.toString())
                .setDate("01 junho")
                .setStared(false)
                .setUnread(true)
                .setSelected(false)
                .build();

        emailAdapter.addEmail(newEmail);
        emailAdapter.notifyItemInserted(0);
    }

    private class LongHandler extends ItemTouchHelper.SimpleCallback {

        public LongHandler(int dragDirs, int swipeDirs) {
            super(dragDirs, swipeDirs);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int from = viewHolder.getAdapterPosition();
            int to = target.getAdapterPosition();

            //troca a posicao da lista logica/List
            Collections.swap(emailAdapter.getEmails(), from, to);
            //troca/notifica a posicao da lista visual, meu recyclerView
            emailAdapter.notifyItemMoved(from, to);

            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            emailAdapter.getEmails().remove(position);
            emailAdapter.notifyItemRemoved(position);
        }
    }
}