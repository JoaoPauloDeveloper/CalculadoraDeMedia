package com.example.primeiroapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private EditText rEditNota1, rEditNota2, rEditNota3, rEditNota4;
    private TextView rTextResultado;
    private int correctFields = 1;


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

        rEditNota1 = findViewById(R.id.editNota1);
        rEditNota2 = findViewById(R.id.editNota2);
        rEditNota3 = findViewById(R.id.editNota3);
        rEditNota4 = findViewById(R.id.editNota4);

        rTextResultado  = findViewById(R.id.textResultado);
    }

    public void calcular(View view){
        double nota1, nota2, nota3, nota4, media;


        if (validarFormulario()) {
            nota1 = Double.parseDouble(rEditNota1.getText().toString());
            nota2 = Double.parseDouble(rEditNota2.getText().toString());
            nota3 = Double.parseDouble(rEditNota3.getText().toString());
            nota4 = Double.parseDouble(rEditNota4.getText().toString());

            media = (nota1 + nota2 + nota3 + nota4) / 4;

            rTextResultado.setText(String.valueOf(media));
        }

    }

    private boolean validarFormulario() {
        EditText[] fields = {rEditNota1, rEditNota2, rEditNota3, rEditNota4};
        for (EditText field : fields) {
            if (TextUtils.isEmpty(field.getText().toString())) {
                field.setError("preencha esse campo");
                field.requestFocus();
                return false;
            }
        }
        return true;
    }

}