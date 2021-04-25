
/*
* EQUIPO:
* MARCO ANTONIO TUZ PECH
* RODRIGO ÁNGEL POOT POOT
* JOSÉ MAURICIO CANUL CHUC
*/

import java.util.Scanner;
import javax.swing.*;

public class Jacobi{
    int filas;
    int columnas;
    double matriz[][];

    public Jacobi(double matriz[][]) {
        this.matriz = matriz;
        this.filas = matriz.length;
        this.columnas = matriz[0].length;
    }

    public void  setFilas(int filas) {
        this.filas = filas;
    }

    public void  setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return this.filas;
    }

    public int getColumnas() {
        return this.columnas;
    }

    public void  imprimirMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] >= 0) {
                    System.out.printf("\t%s%.2f", " ", matriz[i][j]);
                }
                else{
                    System.out.printf("\t%.2f", matriz[i][j]);
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void imprimirvector(double v[]){
        System.out.println("Los elementos del Vector b son:\n");
        for (int i=0; i < v.length; i++) {
            System.out.println(v[i]);
        }
    }

    public void  llenarMatriz() {
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el elemento [" + (i + 1) + "," + (j + 1) + "]: "
                                                                                   ,"Matriz del Sistema",JOptionPane.INFORMATION_MESSAGE));
            }
        }
    }
    
    public void llenarVector(double v[]) {
        Scanner teclado = new Scanner(System.in);
        for (int i=0; i <v.length; i++) {
            v[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el elemento ["+(i+1)+"]: "
                                                                       ,"Vector b",JOptionPane.INFORMATION_MESSAGE));
        }
        System.out.println("");
        
    }

    public double[] restaVectores(double v1[], double v2[]) {
        double resta[] = new double[v1.length];
        for(int i=0; i <resta.length; i++) {
            resta[i] = v1[i] - v2[i];
        }
        return resta;
    }
    
    public double normaVector(double v[]) {
        double norma = 0.0;
        double suma = 0.0;
        for(int i=0; i <v.length; i++) {
            suma += Math.pow(v[i], 2);
        }       
        norma = Math.sqrt(suma);
        return norma;
    }
    
    /*
    * Método que resuelve un sistema de ecuaciones mediante el método de Jacobi
    * b - Vector columna b.
    * tolerancia - Criterio de detención.
    * return - El vector de solución aproximado.
    */

    public double[] jacobi(double b[], double tolerancia) {
        int N = matriz.length;
        //Inicializamos en vector de aproximacion inicial en 0.0.
        double X_Anterior[] = new double[N];
        for(int i=0; i <X_Anterior.length; i++) {
            X_Anterior[i] = 0.0;
        }
        double X_Actual[] = new double[N];
        for(int i=0; i <X_Actual.length; i++) {
            X_Actual[i] = 0.0;
        }
        double norma = 1.0;
        double sumaAux;
        int contadorIteraciones = 0;
        //Revisa si se cumple con el criterio de detención
        while((norma/normaVector(X_Actual)) >= tolerancia) {
            String r = "";
            sumaAux = 0.0;
            contadorIteraciones++;
            //Actualizamos el vector de aproximación inicial
            for(int i=0; i <X_Anterior.length; i++) {
                X_Anterior[i] = X_Actual[i];
            }
            for(int i=0; i <=N-1; i++) {
                for(int j=0; j <=N-1; j++) {
                    if(j != i) {
                        sumaAux += matriz[i][j]*X_Anterior[j];
                    }
                }
                X_Actual[i] = (b[i] - sumaAux)/matriz[i][i];
                r += ("Iteración: " + contadorIteraciones + "  |  X["+(i+1)+"]: " + X_Actual[i]);
                sumaAux = 0.0;
            }
            norma = normaVector(restaVectores(X_Actual, X_Anterior));
            System.out.println(r + "  |  Error: " + norma);
        }
        System.out.println("");
        return X_Actual;
    }
}
