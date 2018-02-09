package com.danielsanso.favyourneighbour12;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class comentarioActivity extends AppCompatActivity {
FloatingActionButton fab;
Button enviarBut;
String titulo, comentario;
EditText edText,comText;
    int obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario);
        fab=(FloatingActionButton)findViewById(R.id.floatingActionButtonCancel) ;
        enviarBut=(Button)findViewById(R.id.buttonEnviar) ;
        edText=(EditText)findViewById(R.id.idLblTituloComentario) ;
        comText=(EditText)findViewById(R.id.idLblComentario) ;

        obj= (int) getIntent().getExtras().getSerializable("objeto");
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*1),(int)(height*1));

        WindowManager.LayoutParams params= getWindow().getAttributes();
        params.gravity= Gravity.CENTER;
        params.x=0;
        params.y=-20;

        getWindow().setAttributes(params);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        enviarBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titulo=edText.getText().toString();
                comentario=comText.getText().toString();
                int id=obj+1;
                DatosPerfil a= new DatosPerfil(id,titulo,comentario,R.drawable.profile_img);
                ProfileActivity.Lista.add(a);
                synchronized (a){
                    a.notify();
                }

               // ProfileActivity.notifyDataSetChanged();

                finish();


            }
        });

    }
}
