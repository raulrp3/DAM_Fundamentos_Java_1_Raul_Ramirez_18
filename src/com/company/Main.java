package com.company;

import java.util.Scanner;

public class Main {
    public static int validarEntero(Scanner sc) {
        int numeroValidado;
        while (!sc.hasNextInt()) {
            System.out.print("¡Introduce un valor numérico©rico entero! ");
            sc.next();
        }
        numeroValidado = sc.nextInt();
        return numeroValidado;
    }

    public static int daDias(int mes) {
        int numeroDias = 0;
        switch (mes) {
            case 4:
            case 6:
            case 9:
            case 11:
                numeroDias = 30;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numeroDias = 31;
                break;
            case 2:
                numeroDias = 28;
        }
        return numeroDias;
    }

    public static boolean validarFecha(int dia, int mes, int año, int numeroDias) {
        boolean validado = true;
        if ((dia < 0 || dia > numeroDias) || (mes < 0 || mes > 12) || año < 0) {
            validado = false;
        }
        return validado;
    }

    public static String nuevaFecha(int dia, int mes, int año, int numeroDias) {
        String fechaNueva;
        dia = dia + 1;
        if (dia > numeroDias) {
            dia = 1;
            mes = mes + 1;
            if (mes > 12) {
                mes = 1;
                año = año + 1;
            }
        }
        fechaNueva = String.format("La fecha de mañana será %d/%d/%d", dia, mes, año);
        return fechaNueva;
    }

    public static void main(String[] args) {
        int dia, mes, año, numeroDias;
        Scanner sc = new Scanner(System.in);
        System.out.println("¡Vamos a indicar si una fecha es correcta!");
        System.out.print("Introduce un día: ");
        dia = validarEntero(sc);
        System.out.print("Introduce un mes: ");
        mes = validarEntero(sc);
        System.out.print("Introduce un año: ");
        año = validarEntero(sc);
        sc.close();
        numeroDias = daDias(mes);
        if (validarFecha(dia, mes, año, numeroDias)) {
            System.out.println(nuevaFecha(dia, mes, año, numeroDias));
        } else {
            System.out.println("La fecha es INCORRECTA");
        }
    }
}

