package com.devalfaro.agendacontactosdevio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class EditarDatos extends AppCompatActivity {
    TextView verNombre;
    TextView verfecha;
    TextView vertelefono;
    TextView veremail;
    TextView verdescripcion;
    Button btnvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_datos);
        Intent intent = getIntent();

        String nombreRecibido = intent.getStringExtra("nombre");
        String fechaRecibido = intent.getStringExtra("fecha");
        String telefonoRecibido = intent.getStringExtra("telefono");
        String emailRecibido = intent.getStringExtra("email");
        String descripcionRecibido = intent.getStringExtra("descripcion");

        verNombre = (TextView) findViewById(R.id.txtfornombre);
        verfecha = (TextView) findViewById(R.id.txtforfecha);
        vertelefono = (TextView) findViewById(R.id.txtfortel);
        veremail = (TextView) findViewById(R.id.txtformail);
        verdescripcion = (TextView) findViewById(R.id.txtfordescrip);

        verNombre.append(nombreRecibido);
        verfecha.append(fechaRecibido);
        vertelefono.append(telefonoRecibido);
        veremail.append(emailRecibido);
        verdescripcion.append(descripcionRecibido);

        Bundle reicieveParams = getIntent().getExtras();
        final int opcion=reicieveParams.getInt("opcion");

        btnvolver = (Button) findViewById(R.id.botonvolver);
        btnvolver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Intent intent = new Intent(EditarDatos.this,MainActivity.class);
                //startActivity(intent);
                onBackPressed();
            }
        });



    }
}
