package com.example.applicationteste;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
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
    private EmailAdapter emailAdapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FakerConfig config = new FakerConfig.Builder().withLocale(new Locale("pt", "BR").toString()).build();
        fake = new Faker(config);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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
                .setDate("30 abril")
                .setStared(false)
                .setUnread(true)
                .setSelected(false)
                .build();

        emailAdapter.addEmail(newEmail);
        emailAdapter.notifyItemInserted(0);

    }
}