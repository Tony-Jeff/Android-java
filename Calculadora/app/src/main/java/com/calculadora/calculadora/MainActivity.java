package com.calculadora.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button BtnZero, BtnUm, BtnDois, BtnTres, BtnQuatro,
            BtnCinco, BtnSeis, BtnSete, BtnOito, BtnNove,
            BtnSoma, BtnSubtracao, BtnMultiplicacao, BtnDivisao,
            BtnPonto, BtnIgual, BtnLimpar, BtnApagar;

    TextView display1, display2, display3;


    @Override
    protected void onCreate(Bundle savedInstanceState) { //criação da tela
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declarando os botões

        display1 = (TextView) findViewById(R.id.mainDisplay1);
        display2 = (TextView) findViewById(R.id.mainDisplay2);
        display3 = (TextView) findViewById(R.id.mainDisplay3);


        BtnZero = findViewById(R.id.mainBtnZero);
        BtnUm = (Button) findViewById(R.id.mainBtnUm);
        BtnDois = (Button) findViewById(R.id.mainBtnDois);
        BtnTres = (Button) findViewById(R.id.mainBtnTres);
        BtnQuatro = (Button) findViewById(R.id.mainBtnQuatro);
        BtnCinco = (Button) findViewById(R.id.mainBtnCinco);
        BtnSeis = (Button) findViewById(R.id.mainBtnSeis);
        BtnSete = (Button) findViewById(R.id.mainBtnSete);
        BtnOito = (Button) findViewById(R.id.mainBtnOito);
        BtnNove = (Button) findViewById(R.id.mainBtnNove);

        BtnSoma = (Button) findViewById(R.id.mainBtnSoma);
        BtnSubtracao = (Button) findViewById(R.id.mainBtnSubtracao);
        BtnMultiplicacao = (Button) findViewById(R.id.mainBtnMultiplicacao);
        BtnDivisao = (Button) findViewById(R.id.mainBtnDivisao);

        BtnPonto = (Button) findViewById(R.id.mainBtnPonto);
        BtnIgual = (Button) findViewById(R.id.mainBtnIgual);

        BtnApagar = (Button) findViewById(R.id.mainBtnApagar);
        BtnLimpar = (Button) findViewById(R.id.mainBtnLimpar);
    }

    /*-instanciando o click do botão, se for diferente de falso, o botão precionado irá setar o display 1 ou 2(depende de qual display ja esta setado)
    e será mostrado no display o numero que foi clicado nesse caso do 0 até 9 -*/


        boolean bool = false;
        public void  BtnZero (View v){
            if (!bool) {
                String strZero = display1.getText().toString();
                display1.setText(strZero + "0");
            } else {
                String strZero = display2.getText().toString();
                display2.setText(strZero + "0");
            }
        }

        public void BtnUm (View v){
            if (!bool) {
                String strUm = display1.getText().toString();
                display1.setText(strUm + "1");
            } else {
                String strUm = display2.getText().toString();
                display2.setText(strUm + "1");
            }
        }

        public void BtnDois (View v){
            if (!bool) {
                String strDois = display1.getText().toString();
                display1.setText(strDois + "2");
            } else {
                String strDois = display2.getText().toString();
                display2.setText(strDois + "2");
            }
        }

        public void BtnTres (View v){
            if (!bool) {
                String strTres = display1.getText().toString();
                display1.setText(strTres + "3");
            } else {
                String strTres = display2.getText().toString();
                display2.setText(strTres + "3");
            }
        }

        public void BtnQuatro (View v){
            if (!bool) {
                String strQuatro = display1.getText().toString();
                display1.setText(strQuatro + "4");
            } else {
                String strQuatro = display2.getText().toString();
                display2.setText(strQuatro + "4");
            }
        }

        public void BtnCinco (View v){
            if (!bool) {
                String strCinco = display1.getText().toString();
                display1.setText(strCinco + "5");
            } else {
                String strCinco = display2.getText().toString();
                display2.setText(strCinco + "5");
            }
        }

        public void BtnSeis (View v){
            if (!bool) {
                String strSeis = display1.getText().toString();
                display1.setText(strSeis + "6");
            } else {
                String strSeis = display2.getText().toString();
                display2.setText(strSeis + "6");
            }
        }

        public void BtnSete (View v){
            if (!bool) {
                String strSete = display1.getText().toString();
                display1.setText(strSete + "7");
            } else {
                String strSete = display2.getText().toString();
                display2.setText(strSete + "7");
            }
        }

        public void BtnOito (View v){
            if (!bool) {
                String strOito = display1.getText().toString();
                display1.setText(strOito + "8");
            } else {
                String strOito = display2.getText().toString();
                display2.setText(strOito + "8");
            }
        }

        public void BtnNove (View v){
            if (!bool) {
                String strNove = display1.getText().toString();
                display1.setText(strNove + "9");
            } else {
                String strNove = display2.getText().toString();
                display2.setText(strNove + "9");
            }
        }

        /*-instanciando o click do botão, caso for verdadeiro o botão é chamado e exibe os operadores matematicos "+,-,*,/" no display3 -*/

        public void BtnSoma (View v){
            bool = true;
            display3.setText("+");
        }

        public void BtnSubtracao (View v){
            bool = true;
            display3.setText("-");
        }

        public void BtnMultiplicacao (View v){
            bool = true;
            display3.setText("x");
        }

        public void BtnDivisao (View v){
            bool = true;
            display3.setText("/");
        }
    /*-instanciando o click do botão PONTO(.) chama a aplicação no display que estiver instanciado display 1 ou 2,
    deixando o usuario colcar somente 1 ponto em cada display e exibe uma mensagem na tela de que o ponto ja foi adicionado-*/
        public void BtnPonto (View v){
            if (!bool) {
                String strPonto = display1.getText().toString();
                if (strPonto.contains(".")) {
                    Toast.makeText(MainActivity.this, "Ja existe Ponto", Toast.LENGTH_LONG).show();
                } else {
                    String str = display1.getText().toString();
                    display1.setText(str + ".");
                }
            } else {
                String strPonto = display2.getText().toString();
                if (strPonto.contains(".")) {
                    Toast.makeText(MainActivity.this, "Ja existe Ponto", Toast.LENGTH_LONG).show();
                } else {
                    String str = display2.getText().toString();
                    display2.setText(str + ".");
                }
            }
        }
/*-faz a chamada do botão APAGAR no display que está selecionado, ele apaga a string uma a uma até mesmo o ponto adicionado,-*/
        public void BtnApagar (View v){
            if (!bool) {
                String str_display1 = display1.getText().toString();

                if (str_display1.length() > 1) {
                    String str_Apagar = str_display1.substring(0, str_display1.length() - 1);
                    display1.setText(str_Apagar);
                } else {
                    display1.setText("");
                }
            } else {
                String str_display2 = display2.getText().toString();
                if (str_display2.length() > 1) {
                    String str_Apagar = str_display2.substring(0, str_display2.length() - 1);
                    display2.setText(str_Apagar);
                } else {
                    display2.setText("");
                }
            }
        }
/*-chama o botão que limpa todas as telas displays 1,2 e 3-*/
        public void BtnLimpar (View v){
            bool = false;
            display1.setText("");
            display2.setText("");
            display3.setText("");
        }
/*- faz a chamada do botão igual que faz o calculo, capturando as strings dos displays 1 e 2 e transformando em inteiros,
o display 3 e verificado qual operador foi selecionado, por exemplo,
se foi selecionado o botão de + ele irá capturar os dados em string nos displays 1 e 2
e converte-los em inteiros, o resultado é exibido em forma de TOAST longo na tela -*/
        public void BtnIgual (View v){
            String str_display1 = display1.getText().toString();
            String str_display2 = display2.getText().toString();
            String str_display3 = display3.getText().toString();

            if (display2.length() > 0) {
                int txt1 = Integer.parseInt(str_display1);
                int txt2 = Integer.parseInt(str_display2);
                if (str_display3.contains("+")) {
                    int resultado = txt1 + txt2;
                    String str = Integer.toString(resultado);
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();

                } else if (str_display3.contains("-")) {
                    int resultado = txt1 - txt2;
                    String str = Integer.toString(resultado);
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();

                } else if (str_display3.contains("x")) {
                    int resultado = txt1 * txt2;
                    String str = Integer.toString(resultado);
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();

                } else if (str_display3.contains("/")) {
                    int resultado = txt1 / txt2;
                    String str = Integer.toString(resultado);
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Operação invádida.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


