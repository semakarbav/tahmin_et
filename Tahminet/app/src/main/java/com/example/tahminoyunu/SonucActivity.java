package com.example.tahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {
    private ImageView imageViewsonuc;
    private TextView textViewsonuc;
    private Button buttontekrar;
    private boolean sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        imageViewsonuc=findViewById(R.id.imageViewsonuc);
        textViewsonuc=findViewById(R.id.textViewsonuc);
        buttontekrar=findViewById(R.id.buttontekrar);

        sonuc=getIntent().getBooleanExtra("sonuc",false);

        if(sonuc){
            imageViewsonuc.setImageResource(R.drawable.mood);
            textViewsonuc.setText("Kazandınız");
        }
        else{
            imageViewsonuc.setImageResource(R.drawable.dissatisfied);
            textViewsonuc.setText("Kaybettiniz");
            textViewsonuc.setTextColor(Color.BLACK);
        }

        buttontekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ıntent=new Intent(SonucActivity.this,TahminActivity.class);
                startActivity(ıntent);
                finish();
            }
        });
    }
}
