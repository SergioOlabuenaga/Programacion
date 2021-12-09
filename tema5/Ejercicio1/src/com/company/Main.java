package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Double> valor;
    public static void main(String[] args) {
	// write your code here
        int opcion = 0;
        valor = new ArrayList<Double>();
        llenadoarray();
        do {
            try {
                opcion = mostrarmenu();
                switch (opcion) {
                    case 1:
                        visualizar();
                        break;
                    case 2:
                        buscar();
                        break;
                    case 3:
                        buscarborrar();
                        break;
                    case 4:
                        convertir();
                        break;
                    case 5:
                        mostrar();
                        break;
                    case 6:
                        insertarfinal();
                        break;
                    case 7:
                        insertarposicion();
                        break;
                    case 8:
                        borrar();
                        break;
                    case 9:
                        calcular();
                        break;
                    case 10:
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Problemas: " + e.getClass());
            }
            }while (opcion!=10);
    }

    private static void llenadoarray() {
        String respuesta = "no";
        do {
            try {
                valor.add(Double.parseDouble(JOptionPane.showInputDialog("introduzca valores para el arraylist")));
                respuesta = JOptionPane.showInputDialog("¿Quieres introducir mas numeros?");
            }catch (NullPointerException e){
                JOptionPane.showMessageDialog(null, "No le des a la cerrar ventana o cancelar");
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Numero no valido");
            }
        }while(respuesta.equalsIgnoreCase("si"));

    }

    private static void visualizar() {
        int maximo = -1;
        int minimo = valor.size();

    }

    private static int mostrarmenu() {
        int opcion=0;
        boolean error;
        do
        {
            try
            {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(" 1. Visualizar el valor maximo y el minimo \n"
                        + "2. Solicitar un numero y buscarlo \n"
                        + "3. Solicitar un numero, buscarlo y borrarlo \n"
                        + "4. Convertir el arrayList en un array \n"
                        + "5. Si no esta vac´ıo, mostrar el numero de elementos que contiene \n"
                        + "6. Insertar un nuevo elemento por el final. \n"
                        + "7. Insertar un nuevo elemento en la posicion que te indique el usuario\n"
                        + "8. Borrar un elemento de una posicion concreta\n"
                        + "9. Calcular la suma y la media aritmetica de los valores contenidos\n"
                        + "10. Salir"));

                error = false;

            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Esta es una opción no valida");
                error = true;
            }
            catch (NullPointerException e)
            {
                JOptionPane.showMessageDialog(null,"No le des a cerrar ventana o cancelar");
                error = true;
            }
        }
        while(error);
        return opcion;
    }
}
