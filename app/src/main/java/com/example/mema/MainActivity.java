package com.example.mema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mema.models.User;

public class MainActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = new User("jarg@gmail.com","123",9.95);
    }



    public void goToMachine(View view) {
        //Log.v("User", user.toString());

        EditText editTextEmail = findViewById(R.id.edit_text_email);
        String emailInput = editTextEmail.getText().toString();

        EditText editTextPassword = findViewById(R.id.edit_text_password);
        String passwordInput = editTextPassword.getText().toString();

        if (user.getEmail().equals(emailInput) && user.getPassword().equals(passwordInput)) {
            //Log.v("Sucesso","Credenciais OK");
            Toast.makeText(this, "Bem-vindo "+this.user.getEmail(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MachineActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Credenciais Erradas", Toast.LENGTH_SHORT).show();
            //Log.v("Erro","Credenciais KO");
        }
    }

    public void goToRegister(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}