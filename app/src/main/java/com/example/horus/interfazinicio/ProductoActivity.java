package com.example.horus.interfazinicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProductoActivity extends AppCompatActivity {

    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        Bundle extras = getIntent().getExtras();
        String cadena = extras.getString("id");

        output = (TextView) findViewById(R.id.output);
        output.setText(cadena);
    }
}
