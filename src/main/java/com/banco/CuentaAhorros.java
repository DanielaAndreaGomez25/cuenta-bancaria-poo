package com.banco;

public class CuentaAhorros extends Cuenta {

    private boolean activa;

    public CuentaAhorros(float saldo, float tasa) {
        super(saldo, tasa);
        activa = saldo >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
        }
    }

    @Override
    public void extractoMensual() {

        if (numeroRetiros > 4) {
            int retirosExtra = numeroRetiros - 4;
            comisionMensual += retirosExtra * 1000;
        }

        super.extractoMensual();

        activa = saldo >= 10000;
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comision mensual: " + comisionMensual);
        System.out.println("Numero de transacciones: " + (numeroConsignaciones + numeroRetiros));
        System.out.println("Cuenta activa: " + activa);
    }
}