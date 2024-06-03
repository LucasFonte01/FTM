package com.example.fitme;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;
import android.view.View; // Adicionada esta linha
import android.content.Intent; // Adicionada esta linha



public class cadastro extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextNumber;
    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
        editTextName = findViewById(R.id.editTextName);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        buttonSubmit = findViewById(R.id.button5);

        buttonSubmit.setOnClickListener(v -> {
            if (validateForm()) {
                Toast.makeText(cadastro.this, "Seja Bem Vindo!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(cadastro.this, home.class);
                startActivity(intent); // Novas linhas adicionadas
            }
        });
    }

    private boolean validateForm() {
        boolean isValid = true;

        // Validação do nome
        String name = editTextName.getText().toString();
        if (TextUtils.isEmpty(name) || !name.matches("[a-zA-Z\\s]+") || name.length() <= 1) {
            editTextName.setError("Nome inválido (somente letras e mais de um caractere)");
            isValid = false;
        }

        // Validação do número de celular
        String number = editTextNumber.getText().toString();
        if (TextUtils.isEmpty(number) || number.length() != 11 || !number.matches("[0-9]+")) {
            editTextNumber.setError("Número de celular inválido (deve conter 11 dígitos)");
            isValid = false;
        }
        // Validação do email
        String email = editTextTextEmailAddress.getText().toString();
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextTextEmailAddress.setError("E-mail inválido");
            isValid = false;
        }

        // Validação da senha
        String password = editTextTextPassword.getText().toString();
        if (!isValidPassword(password)) {
            editTextTextPassword.setError("Senha inválida (mínimo 8 caracteres, um número, uma letra maiúscula e um caractere especial)");
            isValid = false;
        }

        return isValid;
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        Pattern letter = Pattern.compile("[a-zA-Z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[^a-zA-Z0-9]");

        return letter.matcher(password).find() && digit.matcher(password).find() && special.matcher(password).find();
    }
}
