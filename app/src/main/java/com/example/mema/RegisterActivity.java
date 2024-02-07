package com.example.mema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mema.models.User;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void goToLogin(View view){
        EditText editTextEmail = findViewById(R.id.edit_text_email);
        String emailInput = editTextEmail.getText().toString();

        EditText editTextPassword = findViewById(R.id.edit_text_password);
        String passwordInput = editTextPassword.getText().toString();

        if (!emailInput.isEmpty() && !passwordInput.isEmpty()) {
            User user = new User(emailInput,passwordInput,0);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
            Toast.makeText(this, "Registro feito com sucesso", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Preencha os campos superiores", Toast.LENGTH_SHORT).show();
        }
    }

    public void goBackToLogin(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}