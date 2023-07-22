package com.example.homework_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatButton signInBtn = findViewById(R.id.signIn_btn);
        TextView description = findViewById(R.id.tv_description);
        TextView signInTv = findViewById(R.id.signIn_tv);
        EditText emailEd = findViewById(R.id.ed_email);
        EditText passEd = findViewById(R.id.ed_pass);
        LinearLayout edContainer = findViewById(R.id.ed_container);
        signInBtn.setEnabled(false);


        emailEd.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                signInBtn.setBackgroundResource(R.drawable.ic_btn_rectangle);
                signInBtn.setEnabled(true);
            }
        });

        signInBtn.setOnClickListener(v -> {
            String emailText = emailEd.getText().toString();
            String passText = passEd.getText().toString();
            if(!emailText.isEmpty() && !passText.isEmpty()) {
                if (emailText.equals("admin") || passText.equals("admin")) {
                 edContainer.setVisibility(View.GONE);
                 description.setVisibility(View.INVISIBLE);
                 signInTv.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this,"Вы успешно авторизовались", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Неверные логин или пароль", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(MainActivity.this,"Заполните все поля", Toast.LENGTH_SHORT).show();
            }
        });
    }
}