package com.banco;

public class CuentaCorriente extends Cuenta {

    private float sobregiro;

    public CuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa);
        sobregiro = 0;
    }

    @Override
    public void retirar(float cantidad) {

        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            sobregiro += cantidad - saldo;
            saldo = 0;
        }

        numeroRetiros++;
    }

    @Override
    public void consignar(float cantidad) {

        if (sobregiro > 0) {

            if (cantidad >= sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;
                saldo += cantidad;
            } else {
                sobregiro -= cantidad;
            }

        } else {
            saldo += cantidad;
        }

        numeroConsignaciones++;
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public void imprimir() {

        System.out.println("Saldo: " + saldo);
        System.out.println("Comision mensual: " + comisionMensual);
        System.out.println("Numero de transacciones: " + (numeroConsignaciones + numeroRetiros));
        System.out.println("Sobregiro: " + sobregiro);
    }
}