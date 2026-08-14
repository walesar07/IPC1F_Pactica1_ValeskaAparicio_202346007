
package com.mycompany.practica1;

 import java.util.Scanner;

public class Practica1 {
    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    menu (sc);
}

//método para mostrar menú
    public static void menu(Scanner sc){
   
    System.out.println("======SISTEMA DE ESTACIONAMIENTO======")
    System.out.println("1. Ingrese Vehículo")
    System.out.println("2. Retirar Vehículo")
    System.out.println("3. Mostrar estacionamiento")
    System.out.println("4. Buscar vehículo por placa")
    System.out.println("5. Mostrar ruta más corta entre entrada y salida") 
    System.out.println("6. Mostrar ingresos")
    System.out.println("7. Salir")
    }
}
