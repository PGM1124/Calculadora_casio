package com.example.calculadora2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    boolean resultadoMostrado = false;
    double primerNumero = 0;
    double memoria = 0;
    String operacion = "";
    boolean nuevaEntrada = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            return insets;

        });
        TextView pantalla = findViewById(R.id.pantalla);
        Button memoria1 = findViewById(R.id.memoria1);
        Button memoria2 = findViewById(R.id.memoria2);
        Button memoria3 = findViewById(R.id.memoria3);
        Button memoria4 = findViewById(R.id.memoria4);
        Button Reiniciar = findViewById(R.id.Reiniciar);
        Button Boton1 = findViewById(R.id.Boton1);
        Button porcentaje = findViewById(R.id.porcentaje);
        Button division = findViewById(R.id.division);

        Button nueve = findViewById(R.id.nueve);
        Button ocho = findViewById(R.id.ocho);
        Button siete = findViewById(R.id.siete);
        Button seis = findViewById(R.id.seis);
        Button cinco = findViewById(R.id.cinco);
        Button quatro = findViewById(R.id.quatro);
        Button tres = findViewById(R.id.tres);
        Button dos = findViewById(R.id.dos);
        Button uno = findViewById(R.id.uno);
        Button zero = findViewById(R.id.zero);
        Button igual = findViewById(R.id.igual);

        Button coma = findViewById(R.id.coma);
        Button suma = findViewById(R.id.suma);
        Button resta = findViewById(R.id.menos);
        Button multiplica = findViewById(R.id.multiplica);

        View.OnClickListener btnNum = v ->{
            Button btnPulsado = (Button) v;
            String numero = btnPulsado.getText().toString();
            String textoPantalla = pantalla.getText().toString();
            if (textoPantalla.equals("Syntax Error")) {
                pantalla.setText(numero);
                resultadoMostrado = false;
                nuevaEntrada = false;
            }
            else if (resultadoMostrado) {
                pantalla.setText(numero);
                resultadoMostrado = false;
                nuevaEntrada = false;
            }
            else if (nuevaEntrada) {
                pantalla.append(numero);
                nuevaEntrada = false;
            }
            else if (pantalla.getText().toString().equals("0")) {
                pantalla.setText(numero);
            } else {
                pantalla.append(numero);
            }
        };
        uno.setOnClickListener(btnNum);
        dos.setOnClickListener(btnNum);
        tres.setOnClickListener(btnNum);
        quatro.setOnClickListener(btnNum);
        cinco.setOnClickListener(btnNum);
        seis.setOnClickListener(btnNum);
        siete.setOnClickListener(btnNum);
        ocho.setOnClickListener(btnNum);
        nueve.setOnClickListener(btnNum);
        zero.setOnClickListener(btnNum);

        View.OnClickListener Operaciones = v -> {
            int id = v.getId();
            if (id == R.id.suma) {
                if (resultadoMostrado) {
                    primerNumero = Double.parseDouble(
                            pantalla.getText().toString().replace(",", ".")
                    );
                } else {
                    String texto = pantalla.getText().toString().trim();
                    if (!texto.isEmpty()) {
                        primerNumero = Double.parseDouble(texto.replace(",", "."));
                    }
                }
                operacion = "+";
                pantalla.setText(mostrarNumero(primerNumero) + " + ");
                nuevaEntrada = true;
                resultadoMostrado = false;
            }
            else if (id == R.id.menos) {
                if (resultadoMostrado) {
                    primerNumero = Double.parseDouble(
                            pantalla.getText().toString().replace(",", ".")
                    );
                } else {
                    String texto = pantalla.getText().toString().trim();
                    if (!texto.isEmpty()) {
                        primerNumero = Double.parseDouble(texto.replace(",", "."));
                    }
                }
                operacion = "-";
                pantalla.setText(mostrarNumero(primerNumero) + " - ");
                nuevaEntrada = true;
                resultadoMostrado = false;
            }
            else if (id == R.id.multiplica) {
                if (resultadoMostrado) {
                    primerNumero = Double.parseDouble(
                            pantalla.getText().toString().replace(",", ".")
                    );
                } else {
                    String texto = pantalla.getText().toString().trim();
                    if (!texto.isEmpty()) {
                        primerNumero = Double.parseDouble(texto.replace(",", "."));
                    }
                }
                operacion = "x";
                pantalla.setText(mostrarNumero(primerNumero) + " x ");
                nuevaEntrada = true;
                resultadoMostrado = false;
            }
            else if (id == R.id.division) {
                if (resultadoMostrado) {
                    primerNumero = Double.parseDouble(
                            pantalla.getText().toString().replace(",", ".")
                    );
                } else {
                    String texto = pantalla.getText().toString().trim();
                    if (!texto.isEmpty()) {
                        primerNumero = Double.parseDouble(texto.replace(",", "."));
                    }
                }
                operacion = "÷";
                pantalla.setText(mostrarNumero(primerNumero) + " ÷ ");
                nuevaEntrada = true;
                resultadoMostrado = false;
            }
            else if (id == R.id.igual) {
                String texto = pantalla.getText().toString();
                int posicionOperacion = texto.lastIndexOf(operacion);
                String segundoTexto = texto.substring(posicionOperacion + 1).trim();
                double segundoNumero = Double.parseDouble(
                        segundoTexto.replace(",", ".")
                );

                double resultado = 0;

                if (operacion.equals("+")) {
                    resultado = primerNumero + segundoNumero;
                }
                else if (operacion.equals("-")) {
                    resultado = primerNumero - segundoNumero;
                }
                else if (operacion.equals("x")) {
                    resultado = primerNumero * segundoNumero;
                }
                else if (operacion.equals("÷")) {
                    if (segundoNumero != 0) {
                        resultado = primerNumero / segundoNumero;
                    } else {
                        pantalla.setText("Syntax Error");
                        resultadoMostrado = true;
                        nuevaEntrada = false;
                        operacion = "";
                        return;
                    }
                }
                pantalla.setText(mostrarNumero(resultado));
                nuevaEntrada = true;
                resultadoMostrado = true;
                operacion = "";
            }
            else if(id == R.id.porcentaje) {
                double numero = Double.parseDouble(
                        pantalla.getText().toString()
                );
                numero = numero / 100;
                operacion = "%";
                pantalla.setText(String.valueOf(numero));
            }
            else if(id == R.id.Boton1) {
                String numero = pantalla.getText().toString();
                if (numero.length() > 1) {
                    pantalla.setText(numero.substring(0, numero.length() - 1));
                } else {
                    pantalla.setText("0");
                }
            }
            else if (id == R.id.Reiniciar) {
                primerNumero = 0;
                operacion = "";
                nuevaEntrada = false;
                resultadoMostrado = false;
                pantalla.setText("0");
            }
            else if (id == R.id.coma) {
                String numero = pantalla.getText().toString();
                if (!numero.contains(".")) {
                    pantalla.append(".");
                }
            }
            else if (id == R.id.memoria2) {
                memoria += Double.parseDouble(
                        pantalla.getText().toString()
                );
            }

            else if (id == R.id.memoria1) {
                memoria -= Double.parseDouble(
                        pantalla.getText().toString()
                );
            }

            else if (id == R.id.memoria3) {
                memoria = 0;
            }

            else if (id == R.id.memoria4) {
                pantalla.setText(
                        String.valueOf(memoria)
                );
            }
        };

        suma.setOnClickListener(Operaciones);
        resta.setOnClickListener(Operaciones);
        multiplica.setOnClickListener(Operaciones);
        division.setOnClickListener(Operaciones);

        igual.setOnClickListener(Operaciones);
        porcentaje.setOnClickListener(Operaciones);
        coma.setOnClickListener(Operaciones);

        Reiniciar.setOnClickListener(Operaciones);
        Boton1.setOnClickListener(Operaciones);

        memoria1.setOnClickListener(Operaciones);
        memoria2.setOnClickListener(Operaciones);
        memoria3.setOnClickListener(Operaciones);
        memoria4.setOnClickListener(Operaciones);

    };
    private String mostrarNumero(double numero) {
        if (numero == (long) numero) {
            return String.valueOf((long) numero);
        } else {
            return String.valueOf(numero);
        }
    }
}
