package com.example.parcial1casa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

   private EditText nombre,codigo,valor,iva,categoria;
    TextView resultado;
   private Button btnguardar,btncostosos,btnenviar,btnbaratos, btnpromedio;
    private ArrayList<Productos> Listaproductos = new ArrayList<>();
    private ArrayList<Productos> ListaproductosIva = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.txtnombre);
        codigo = findViewById(R.id.txtcodigo);
        valor = findViewById(R.id.txtvalor);
        iva = findViewById(R.id.txtiva);
        categoria = findViewById(R.id.txtcategoria);
        btnguardar = findViewById(R.id.btnguardar);
        btncostosos = findViewById(R.id.btncostosos);
        btnbaratos= findViewById(R.id.btnbaratos);
        btnpromedio= findViewById(R.id.btnpromedio);
        btnenviar = findViewById(R.id.btnenviar);
        btnguardar.setOnClickListener(this);
        btncostosos.setOnClickListener(this);
        btnpromedio.setOnClickListener(this);
        btnbaratos.setOnClickListener(this);
        btnenviar.setOnClickListener(this);
        resultado = findViewById(R.id.txtresultado);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnguardar:
                agregarProductos();
                limpiarCampos();

                break;
            case R.id.btncostosos:
                MasCostosos();
               resultado.setText(Listaproductos.toString());
               limpiarCampos();
               break;

            case R.id.btnbaratos:
                MasBaratos();
                resultado.setText(Listaproductos.toString());
                limpiarCampos();
                break;

            case R.id.btnpromedio:

                resultado.setText("El Promedio de los Productos es: "+Promedio());
                limpiarCampos();
                break;

            case R.id.btnenviar:

             ProductosIva();
                limpiarCampos();
                break;
        }
    }


    private void agregarProductos(){

        String ednombre= nombre.getText().toString();
        int edcodigo= Integer.parseInt(codigo.getText().toString());
        int edvalor= Integer.parseInt(valor.getText().toString());
        String ediva= iva.getText().toString();
        String edcategoria= categoria.getText().toString();
        Productos productos = new Productos(ednombre, edcodigo, edvalor, ediva, edcategoria);
        Listaproductos.add(productos);

    }

    private  void MasCostosos(){
        Listaproductos.sort(Comparator.comparing(Productos::getValor).reversed());
    }

    private  void MasBaratos(){
        Listaproductos.sort(Comparator.comparing(Productos::getValor));
    }



    private double Promedio (){
        int contador = 0;
        double valor_producto=0;
        double promedio;
        for (Productos productos : Listaproductos){
            valor_producto += productos.getValor();
            contador++;
        }
        promedio = valor_producto / contador;
        return promedio;


    }


        private void ProductosIva(){
            for (Productos productos : Listaproductos){

                if(productos.getIva().equals("si")){
                    ListaproductosIva.add(productos);
                    Intent intent = new Intent(MainActivity.this, Productos_Iva.class);
                    intent.putExtra("proiva", productos);
                    startActivity(intent);
               }




            }

        }

    private void limpiarCampos(){
        nombre.getText().clear();
        codigo.getText().clear();
        valor.getText().clear();
        iva.getText().clear();
        categoria.getText().clear();
    }
    }
