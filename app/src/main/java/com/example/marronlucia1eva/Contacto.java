package com.example.marronlucia1eva;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class Contacto extends AppCompatActivity {

    Button enviar;
    EditText correo,asunto,mensaje,puntu;
    SeekBar mibarra;
    TextView recuentopuntuacion;
    Snackbar mySnackbar;
    String url, url2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        url = "https://web2.0calc.es";
        url2 = "https://www.google.com/intl/es/gmail/about/";
        correo = findViewById(R.id.correo);
        asunto = findViewById(R.id.asunto);
        mensaje = findViewById(R.id.mensaje);
        enviar = findViewById(R.id.button);
        mibarra = findViewById(R.id.seekBar);
        mibarra.setMax(10);
        mibarra.setProgress(0);
        recuentopuntuacion = findViewById(R.id.puntuacionnum);
        mySnackbar = Snackbar.make(findViewById(R.id.milayout), R.string.aviso, Snackbar.LENGTH_SHORT);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enviarcorreo = correo.getText().toString();
                String enviarasunto = asunto.getText().toString();
                String enviarmensaje = mensaje.getText().toString();
                String enviarpuntuacion =recuentopuntuacion.getText().toString();
                String content = "PUNTUACIÓN: " + enviarpuntuacion + "\n" + enviarmensaje;
                Intent intent = new Intent(Intent.ACTION_SEND);

                    if (enviarcorreo.equals("") || enviarasunto.equals("") || enviarmensaje.equals("")) {
                        mySnackbar.show();
                    } else {
                        intent.setType("message/rfc822");
                        intent.putExtra(Intent.EXTRA_SUBJECT, enviarasunto);
                        intent.putExtra(Intent.EXTRA_TEXT, content);
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{
                                enviarcorreo
                        });
                        startActivity(Intent.createChooser(intent, "Elige por donde enviar el correo:"));
                    }
            }
        });


        mibarra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                recuentopuntuacion.setText(String.valueOf(mibarra.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent volver = new Intent(getApplicationContext(), Principal.class);
        startActivity(volver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.xmlmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String mensaje = "";
        switch (item.getItemId()){
            case R.id.Menu1:
                Intent intent = new Intent(getApplicationContext(), Principal.class);
                startActivity(intent);
                return true;
            case R.id.Calculadora:
                Intent intent2 = new Intent(getApplicationContext(), Calculadora.class);
                startActivity(intent2);
                return true;

            case R.id.Calculadoraonline:
                Uri uri = Uri.parse(url);
                Intent intent4 = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent4);
                return true;

            case R.id.Contacto:
                Intent intent3 = new Intent(getApplicationContext(), Contacto.class);
                startActivity(intent3);
                return true;

            case R.id.Gmail:
                Uri uri2 = Uri.parse(url2);
                Intent intent5 = new Intent(Intent.ACTION_VIEW,uri2);
                startActivity(intent5);
                return true;

            default:return super.onOptionsItemSelected(item);
        }
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.xmlmenu,menu);

    }

}
