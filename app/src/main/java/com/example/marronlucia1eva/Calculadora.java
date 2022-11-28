package com.example.marronlucia1eva;

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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;

public class Calculadora extends AppCompatActivity {

    TextView resultado;
    boolean punt = true;
    boolean operacion2 = false;
    Button cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,multiplicacion,division,suma,resta,punto,inv,borrar,igual,elevado;
    Float numero1,numero2;
    String operacion = "";
    String url, url2;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        url = "https://web2.0calc.es";
        url2 = "https://www.google.com/intl/es/gmail/about/";
        TextView resultado = (TextView) findViewById(R.id.resultado);
        Button cero = (Button) findViewById(R.id.cero);
        Button uno = (Button) findViewById(R.id.uno);
        Button dos = (Button) findViewById(R.id.dos);
        Button tres = (Button) findViewById(R.id.tres);
        Button cuatro = (Button) findViewById(R.id.cuatro);
        Button cinco = (Button) findViewById(R.id.cinco);
        Button seis = (Button) findViewById(R.id.seis);
        Button siete = (Button) findViewById(R.id.siete);
        Button ocho = (Button) findViewById(R.id.ocho);
        Button nueve = (Button) findViewById(R.id.nueve);
        Button punto = (Button) findViewById(R.id.punto);
        Button multiplicacion = (Button) findViewById(R.id.multiplicacion);
        Button division = (Button) findViewById(R.id.division);
        Button suma = (Button) findViewById(R.id.suma);
        Button resta = (Button) findViewById(R.id.resta);
        Button borrar = (Button) findViewById(R.id.borrar);
        Button inv = (Button) findViewById(R.id.inv);
        Button igual = (Button)findViewById(R.id.igual);
        Button elevado = (Button)findViewById(R.id.elevado);


        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = (String) resultado.getText().toString();
                resultado.setText(numero+=0);

            }
        });

        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = (String) resultado.getText().toString();
                resultado.setText(numero+=1);
            }
        });

        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = (String) resultado.getText().toString();
                resultado.setText(numero+=2);
            }
        });

        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = (String) resultado.getText().toString();
                resultado.setText(numero+=3);
            }
        });

        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = (String) resultado.getText().toString();
                resultado.setText(numero+=4);
            }
        });

        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = (String) resultado.getText().toString();
                resultado.setText(numero+=5);
            }
        });

        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = (String) resultado.getText().toString();
                resultado.setText(numero+=6);
            }
        });

        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = (String) resultado.getText().toString();
                resultado.setText(numero+=7);
            }
        });

        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = (String) resultado.getText().toString();
                resultado.setText(numero+=8);
            }
        });

        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = (String) resultado.getText().toString();
                resultado.setText(numero+=9);
            }
        });

        punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (punt == true) {
                    if (resultado.getText().equals("")) {
                        resultado.setText("0.");
                    } else {
                        String numero = (String) resultado.getText().toString();
                        resultado.setText(numero += ".");
                    }
                }
                punt = false;

            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = (String) resultado.getText().toString();
                resultado.setText(numero);
            }
        });

        elevado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero1 = (String) resultado.getText().toString();
                String r = "";
                r = elevado(numero1);
                String resultadofinal = r;
                resultado.setText(resultadofinal);

            }
        });

        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operacion2 == false) {
                    String numero1 = (String) resultado.getText().toString();
                    String numero11 = numero1 + "*";
                    String vacio = "";
                    resultado.setText(vacio);

                    char[] ultimos = numero11.toCharArray();
                    char ultimo = ultimos[ultimos.length - 1];

                    if (ultimo == '-' || ultimo == '+' || ultimo == '/' || ultimo == '*') {
                        operacion2 = true;
                    } else {
                        operacion2 = false;
                    }

                    igual.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            operacion2=false;
                            String numero2 = (String) resultado.getText().toString();
                            if(numero2.equals("")){
                                resultado.setText(numero1);
                            }else {
                                String r = "";
                                r = multiplicacion(numero1, numero2);
                                String resultadofinal = r;
                                resultado.setText(resultadofinal);
                            }
                        }
                    });

                    punt = true;
                }
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operacion2 == false) {
                    String numero1 = (String) resultado.getText().toString();
                    String numero11 = numero1 + "/";
                    String vacio = "";
                    resultado.setText(vacio);
                    char[] ultimos = numero11.toCharArray();
                    char ultimo = ultimos[ultimos.length - 1];

                    if (ultimo == '-' || ultimo == '+' || ultimo == '/' || ultimo == '*') {
                        operacion2 = true;
                    } else {
                        operacion2 = false;
                    }

                    igual.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String numero2 = (String) resultado.getText().toString();
                            String r = "";
                            double entre = 0.0;
                            double num1 = Double.parseDouble(numero1);
                            double num2 = Double.parseDouble(numero2);
                            entre = num1 / num2;
                            r = String.valueOf(entre);

                            if(numero2.equals("")){
                                resultado.setText(numero1);
                            }else{

                                if (num2 == 0.0) {
                                    Toast.makeText(Calculadora.this, "NO ES POSIBLE DIVIDIR ENTRE CERO", Toast.LENGTH_LONG).show();
                                } else {
                                    resultado.setText(r);

                                }
                            }


                        }
                    });

                    punt = true;
                }
            }
        });

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operacion2 == false) {
                    String numero1 = (String) resultado.getText().toString();
                    String numero11 = numero1 + "+";
                    String vacio = "";
                    resultado.setText(vacio);
                    char[] ultimos = numero11.toCharArray();
                    char ultimo = ultimos[ultimos.length -1];

                    if (ultimo == '-' || ultimo == '+' || ultimo == '/' || ultimo =='*'){
                        operacion2 = true;
                    } else{
                        operacion2 = false;
                    }
                    igual.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            operacion2 = false;
                            String numero2 = (String) resultado.getText().toString();

                            if(numero2.equals("")) {
                                resultado.setText(numero1);
                            }else{
                                String r = "";
                                r = suma(numero1, numero2);
                                String resultadofinal = r;
                                resultado.setText(resultadofinal);
                            }

                        }
                    });

                    punt = true;
                }
            }
        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operacion2 == false) {
                    String numero1 = (String) resultado.getText().toString();
                    String numero11 = numero1 + "-";
                    String vacio = "";
                    resultado.setText(vacio);

                    char[] ultimos = numero11.toCharArray();
                    char ultimo = ultimos[ultimos.length - 1];

                    if (ultimo == '-' || ultimo == '+' || ultimo == '/' || ultimo == '*') {
                        operacion2 = true;
                    } else {
                        operacion2 = false;
                    }
                    igual.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String numero2 = (String) resultado.getText().toString();
                            if(numero2.equals("")){
                                resultado.setText(numero1);
                            }else {
                                String r = "";
                                r = resta(numero1, numero2);
                                String resultadofinal = r;
                                resultado.setText(resultadofinal);
                            }
                        }
                    });

                    punt = true;
                }
            }
        });



        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("");
                numero1 = 0.0f;
                numero2 = 0.0f;
                operacion = "";

                punt = true;
                operacion2 = false;
            }
        });

        inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numerosininv = resultado.getText().toString();
                String numeroinv = "";


                for(int x = resultado.length() -1; x>=0;x--){
                    numeroinv = numeroinv + numerosininv.charAt(x);
                }

                resultado.setText(numeroinv);

            }
        });
    }

    public static String suma (String numero1, String numero2){
        double suma = 0;
        double numeroentero1 = Double.parseDouble(numero1);
        double numeroentero2 = Double.parseDouble(numero2);
        suma = numeroentero1 + numeroentero2;

        String numero = String.valueOf(suma);
        return numero;
    }

    public static String resta (String numero1, String numero2){
        double resta = 0;
        double numeroentero1 = Double.parseDouble(numero1);
        double numeroentero2 = Double.parseDouble(numero2);
        resta = numeroentero1 - numeroentero2;

        String numero = String.valueOf(resta);
        return numero;
    }

    public static String multiplicacion (String numero1, String numero2){
        double multiplicacion = 0;
        double numeroentero1 = Double.parseDouble(numero1);
        double numeroentero2 = Double.parseDouble(numero2);
        multiplicacion = numeroentero1 * numeroentero2;

        String numero = String.valueOf(multiplicacion);
        return numero;
    }

    public static String division (String numero1, String numero2){
        double division = 0;
        double numeroentero1 = Double.parseDouble(numero1);
        double numeroentero2 = Double.parseDouble(numero2);
        division = numeroentero1 / numeroentero2;

        String numero = String.valueOf(division);
        return numero;
    }

    public static String elevado(String numero1){
        double elevado = 0;
        double numeroentero1 = Double.parseDouble(numero1);
        elevado = numeroentero1 * numeroentero1;

        String numero = String.valueOf(elevado);
        return numero;
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



