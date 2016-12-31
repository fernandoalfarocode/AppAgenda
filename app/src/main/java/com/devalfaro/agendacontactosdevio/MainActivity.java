package com.devalfaro.agendacontactosdevio;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //DECLARACION DE VARIABLES PARA FECHA
    private int año;
    private int mes;
    private int dia;
    private EditText campoFecha;
    private Button btnFecha;
    private static final int TIPO_DIALOGO = 0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;
    //FINAL DECLARACION DE VARIABLES PARA FECHA


    private View btn;
    EditText nombre;
    EditText fecha;
    EditText telefono;
    EditText mail;
    EditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //DECLARACION DE ICONO DE LA APP
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.red_hat_96);
        //FINAL DE DECLARACION DE ICONO DE LA APP

        //DECLRACION DE PICKER DE FECHA
        campoFecha = (EditText) findViewById(R.id.verFecha);
        btnFecha = (Button) findViewById(R.id.btnfecha);
       java.util.Calendar calendario = java.util.Calendar.getInstance();
        año = calendario.get(java.util.Calendar.YEAR);
        mes = calendario.get(java.util.Calendar.MONTH);
        dia = calendario.get(java.util.Calendar.DAY_OF_MONTH);
        mostrarFecha();

        //DATOS A PASAR

        nombre = (EditText) findViewById(R.id.editdenombre);
        fecha = (EditText) findViewById(R.id.verFecha);
        telefono = (EditText) findViewById(R.id.editdetelefono);
        mail = (EditText) findViewById(R.id.editdecorreo);
        descripcion = (EditText) findViewById(R.id.editdedescripcion);

        //BOTON DE SIGUIENTE ACTIVIDAD
        btn = (Button) findViewById(R.id.btnsiguiente);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String nombreuser = nombre.getText().toString();
                String fechauser = fecha.getText().toString();
                String telefonouser = telefono.getText().toString();
                String emailuser = mail.getText().toString();
                String descripcionuser = descripcion.getText().toString();
                Intent intent = new Intent(MainActivity.this,EditarDatos.class);
                intent.putExtra("nombre",nombreuser);
                intent.putExtra("fecha",fechauser);
                intent.putExtra("telefono",telefonouser);
                intent.putExtra("email",emailuser);
                intent.putExtra("descripcion",descripcionuser);
                startActivity(intent);
            }
        });
        //FINAL DE BOTON DE SIGUIENTE




        oyenteSelectorFecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                año = i;
                mes = i1;
                dia = i2;
                mostrarFecha();
            }
        };



    }


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case 0:
                return new DatePickerDialog(this,oyenteSelectorFecha,año,mes,dia);
        }
        return null;
    }

    public void mostrarCalendario(View control){
        showDialog(TIPO_DIALOGO);
    }

    public void mostrarFecha(){
        campoFecha.setText(dia +"/"+(mes+1)+"/"+año);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item2:
                Snackbar.make(getWindow().getDecorView(),getResources().getString(R.string.autorSnackBar),Snackbar.LENGTH_LONG)
                        .setAction("Contacto", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                    String Email = "fernandoalfarop13@gmail.com";
                                    Intent EmailIntent = new Intent((Intent.ACTION_SEND));
                                    EmailIntent.setData(Uri.parse("mailto: "));
                                    EmailIntent.putExtra(Intent.EXTRA_EMAIL,Email);
                                    EmailIntent.setType("message/rfc822");
                                    startActivity(Intent.createChooser(EmailIntent,"Email "));
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
                default:
                    return super.onOptionsItemSelected(item);
            }
    }


}
