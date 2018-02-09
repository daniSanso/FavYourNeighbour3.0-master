package com.danielsanso.favyourneighbour12;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    ImageView imagen;
    FloatingActionButton buttonFloating;
    TextView backb,txtlike,txtunlike,numlik,numunlik;
    LinearLayout butlike,butunlike;
    boolean clck=false;
    boolean clck2=false;

    int likea, unlikea;

    ListView listaDatos;
    public static ArrayList<DatosPerfil> Lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        EditText back=null;

        //  back=(EditText) findViewById(R.id.backid);
        imagen=(ImageView)findViewById(R.id.idimagen);
        backb=(TextView)findViewById(R.id.backid);
        txtlike=(TextView)findViewById(R.id.textlike);
        txtunlike=(TextView)findViewById(R.id.textunlike);
        butlike=(LinearLayout) findViewById(R.id.clicklike);
        butunlike=(LinearLayout)findViewById(R.id.clickunlike);
        numlik=(TextView)findViewById(R.id.numlike1) ;
        numunlik=(TextView)findViewById(R.id.numunlike1) ;




        buttonFloating=(FloatingActionButton) findViewById(R.id.floatingActionButton);

        listaDatos=(ListView) findViewById(R.id.lstDatosComentario);

        Lista= new ArrayList<DatosPerfil>();

        Lista.add(new DatosPerfil(1,"Conejo","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(2,"Rana","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(3,"Pez","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(4,"Pez","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(5,"Pinguino","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(6,"Pez Payaso","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(7,"Koala","Animal en peligro de extincion",R.drawable.profile_img));

        Lista.add(new DatosPerfil(8,"Conejo","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(9,"Rana","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(10,"Pez","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(11,"Pinguino","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(12,"Pez Payaso","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(13,"Koala","Animal en peligro de extincion",R.drawable.profile_img));


        Lista.add(new DatosPerfil(14,"Conejo","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(15,"Rana","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(16,"Pez","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(17,"Pinguino","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(18,"Pez Payaso","Animal en peligro de extincion",R.drawable.profile_img));
        Lista.add(new DatosPerfil(19,"Koala","Animal en peligro de extincion",R.drawable.profile_img));

        Adaptador miadaptador= new Adaptador(getApplicationContext(),Lista);
        listaDatos.setAdapter(miadaptador);

       /* listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {//new O + enter en el parentesis
            @Override                                                           //obtener el onjeto seleccionado
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Datos obj =(Datos) parent.getItemAtPosition(position);//retorna el onbj de la posicion indicada

                Intent paso = new Intent(getApplicationContext(),DetalleActivity.class);
                paso.putExtra("objeto",(Serializable) obj); //guardamos el obj con la clave objeto
                //cuando trabajamos con clases, para pasar datos lo mejopr es
                //serializar el obj complerto, cargarlo dentro de la intencion y pasarlo a la segunda pantala
                startActivity(paso);
            }
        });*/

      /* imagen.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });*/
        buttonFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int obj =(int) Lista.size();
                Intent intent= new Intent(getApplicationContext(),comentarioActivity.class);
                intent.putExtra("objeto",(Serializable) obj); //guardamos el obj con la clave objeto
                //cuando trabajamos con clases, para pasar datos lo mejopr es
                //serializar el obj complerto, cargarlo dentro de la intencion y pasarlo a la segunda pantala
                startActivity(intent);
            }
        });
        backb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        butlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clck2==true){unlikea=Integer.parseInt(numunlik.getText().toString());
                    unlikea--;
                    numunlik.setText(String.valueOf(unlikea));
                    Drawable img = getResources().getDrawable(R.drawable.ic_thumb_down);

                    txtunlike.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
                    clck2=false;

                }

                if(clck==false) {
                    likea=Integer.parseInt(numlik.getText().toString());
                    likea++;
                    numlik.setText(String.valueOf(likea));
                    Drawable img = getResources().getDrawable(R.drawable.ic_thumb_up2);
                    txtlike.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
                    clck=true;
                }
                else {Drawable img = getResources().getDrawable(R.drawable.ic_thumb_up);
                    likea=Integer.parseInt(numlik.getText().toString());
                    likea--;
                    numlik.setText(String.valueOf(likea));
                    txtlike.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
                    clck=false;

                }
            }
        });
        butunlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clck==true){
                    likea=Integer.parseInt(numlik.getText().toString());
                    likea--;
                    numlik.setText(String.valueOf(likea));
                    Drawable img = getResources().getDrawable(R.drawable.ic_thumb_up);
                    txtlike.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
                    clck=false;


                }
                if(clck2==false) {
                    unlikea=Integer.parseInt(numunlik.getText().toString());
                    unlikea++;
                    numunlik.setText(String.valueOf(unlikea));
                    Drawable img = getResources().getDrawable(R.drawable.ic_thumb_down2);
                    txtunlike.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
                    clck2=true;
                }
                else {Drawable img = getResources().getDrawable(R.drawable.ic_thumb_down);
                    unlikea=Integer.parseInt(numunlik.getText().toString());
                    unlikea--;
                    numunlik.setText(String.valueOf(unlikea));
                    txtunlike.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
                    clck2=false;

                }

            }
        });
    }
}