package com.example.tahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {
    private TextView textViewkalan,textViewyardim;
    private EditText editTextgirdi;
    private Button buttonoyna;
    private int rastgelesayi;
    private int hak =5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);

        textViewkalan=findViewById(R.id.textViewkalan);
        textViewyardim=findViewById(R.id.textViewyardim);
        editTextgirdi=findViewById(R.id.editTextgirdi);
        buttonoyna=findViewById(R.id.buttonoyna);

        Random random=new Random();
        rastgelesayi= random.nextInt(101);
        Log.e("Rastgele Sayı",String.valueOf(rastgelesayi));

        buttonoyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hak=hak-1;

                int tahmin=Integer.parseInt(editTextgirdi.getText().toString());

                if(hak!=0){
                    if(tahmin==rastgelesayi){

                        Intent ıntent=new Intent(TahminActivity.this,SonucActivity.class);
                        ıntent.putExtra("sonuc",true);
                        startActivity(ıntent);
                        finish();
                    }
                    if(tahmin>rastgelesayi){
                        textViewyardim.setText("Azalt");

                    }
                    if (tahmin<rastgelesayi){
                        textViewyardim.setText("Arttır");
                    }
                    textViewkalan.setText("Kalan Hak: "+hak);

                }
                else
                {
                    Intent ıntent=new Intent(TahminActivity.this,SonucActivity.class);
                    ıntent.putExtra("sonuc",false);
                    startActivity(ıntent);
                    finish();
                }
                editTextgirdi.setText("");



            }
        });

    }
}
