package com.guamanpomadeayala.consultanotarios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private String URL = "http://192.168.1.5:3000/";
    private BottomNavigationView navigationView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        navigationView =findViewById(R.id.nav_view);
        navigationView.setSelectedItemId(R.id.inicio);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //Define WebViewClient() para poder leer eventos que ocurren durante el cargado de contenido en el WebView.
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //elimina ProgressBar.
                progressDialog.dismiss();
            }
        });
        webView.loadUrl(URL);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.inicio:
                        webView.loadUrl(URL);
                        break;
                    case R.id.contacto:
                        webView.loadUrl("https://guamanpoma.org");
                        break;

                }
                return true;
            }
        });

    }
}