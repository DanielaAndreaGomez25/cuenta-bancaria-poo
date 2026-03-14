package com.banco;

public class Main {

    public static void main(String[] args) {

        CuentaAhorros cuenta = new CuentaAhorros(15000, 5);

        cuenta.consignar(2000);
        cuenta.retirar(1000);
        cuenta.retirar(1000);
        cuenta.retirar(1000);
        cuenta.retirar(1000);
        cuenta.retirar(1000);

        cuenta.extractoMensual();

        cuenta.imprimir();
    }
}