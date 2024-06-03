package com.example.fitme;

import android.content.Intent; // Adicionada esta linha
import android.os.Bundle;
import android.view.View; // Adicionada esta linha
import android.widget.Button; // Adicionada esta linha
import androidx.appcompat.app.AppCompatActivity;

public class entrar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrar);

        // Adicionando comportamento de clique no botão "Entrar"
        Button buttonEntrar = findViewById(R.id.button9); // ID do botão "Entrar"
        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(entrar.this, home.class);
                startActivity(intent);
            }
        }); // Novas linhas adicionadas
    }
}
