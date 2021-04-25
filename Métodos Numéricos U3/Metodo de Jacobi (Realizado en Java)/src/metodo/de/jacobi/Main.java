
/*
* EQUIPO:
* MARCO ANTONIO TUZ PECH
* RODRIGO ÁNGEL POOT POOT
* JOSÉ MAURICIO CANUL CHUC
*/

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        boolean salir = false;
        
        while (salir != true){
            try{    
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "     BIENVENIDO A ESTE PROGRAMA\n"
                                                                          + "                 MÉTODO DE JACOBI\n\n"
                                                                          + "1. Resolver Sistemas de Ecuacion Lineal\n"
                                                                          + "2. Integrantes del Equipo\n"
                                                                          + "3. Cerrar Programa\n\n"
                                                                          + "Ingrese la opción que desee\n\n"
                                                                           ,"Métodos Numéricos",JOptionPane.INFORMATION_MESSAGE));
            
                switch(opcion){
                    case 1:
                        int dimension = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                        "Ingrese la dimensión de la matriz: ","Jacobi",JOptionPane.INFORMATION_MESSAGE));
                        double A[][] = new double[dimension][dimension];
                        Jacobi matriz = new Jacobi(A);
                        matriz.llenarMatriz();
                        System.out.println("\nLa matriz ingresada A es: \n" );
                        matriz.imprimirMatriz();
                        double b[] = new double[dimension];
                        JOptionPane.showMessageDialog(null, "Ingrese el vector b: ", "Datos del Vector",JOptionPane.INFORMATION_MESSAGE);
                        matriz.llenarVector(b);
                        matriz.imprimirvector(b);
                        double tolerancia = Double.parseDouble(JOptionPane.showInputDialog(null, "\nIngrese tolerancia: "
                                                                                          ,"Tolerancia",JOptionPane.INFORMATION_MESSAGE));
                        JOptionPane.showMessageDialog(null, "El vector de aproximación se define con ceros por default\n"
                                                          + "Aproximando la solución del sistema de ecuaciones por el Método de Jacobi"
                                                           ,"Resolviendo...",JOptionPane.INFORMATION_MESSAGE);
                        matriz.jacobi(b, tolerancia);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "     Métodos Numéricos\n"
                                                        +   "              Unidad 3\n\n"
                                                        +   "           Integrantes\n\n"
                                                        +   "  Marco Antonio Tuz Pech\n"
                                                        +   "  Rodrigo Ángel Poot Poot\n"
                                                        +   " José Mauricio Canul Chuc\n"
                                                        ,   "Equipo",JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La opción ingresada no es correcta"
                                                          , "Error",JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(NumberFormatException a){
                JOptionPane.showMessageDialog(null, "La opción ingresada no es válida",
                                    "Error",JOptionPane.INFORMATION_MESSAGE);
            }catch(NullPointerException a){
                
            }
        }
    }
}
