package com.example.horus.interfazinicio;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MenuActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    private ZXingScannerView escanerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    protected void onPause() {
        super.onPause();
        escanerView.stopCamera();
    }

    public void EscanerQR(View view){
        escanerView = new ZXingScannerView(this);
        setContentView(escanerView);
        escanerView.setResultHandler(this);
        escanerView.startCamera();
    }

    @Override
    public void handleResult(Result result) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultados del escaner");
        builder.setMessage("Resultado "+result.getText()+"\n"+"formato "+result.getBarcodeFormat());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        escanerView.resumeCameraPreview(this);
        Intent intent = new Intent(this, ProductoActivity.class);
        intent.putExtra("id",result.getText());
        startActivity(intent);
    }
}
