package com.example.marronlucia1eva;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class Principal extends AppCompatActivity {

    private TextView miTextView;
    private ImageButton miBoton;
    private ImageButton miBoton2;
    private ImageView menu;
    String url, url2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        url = "https://web2.0calc.es";
        url2 = "https://www.google.com/intl/es/gmail/about/";
        miTextView = (TextView) findViewById(R.id.textViewAnimado);
        registerForContextMenu(miTextView);
        miTextView.setSelected(true);
        miBoton = (ImageButton) findViewById(R.id.imagebuttonnew);
        miBoton2 = (ImageButton) findViewById(R.id.imagebuttonnew2);
        menu = (ImageView)findViewById(R.id.menu);
        registerForContextMenu(menu);

        miBoton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Calculadora.class);
                startActivity(intent);
            }
        });

        miBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Contacto.class);
                startActivity(intent);
            }
        });
    }

    public void onBackPressed() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir de la aplicación?").setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            builder.show();
        }


    @Override
    public boolean onContextItemSelected(MenuItem item){
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

