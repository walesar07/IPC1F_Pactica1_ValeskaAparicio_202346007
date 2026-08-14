
package com.mycompany.practica1;

 import java.util.Scanner;

public class Practica1 {
    
    //arreglo representa estacionamiento
    static char [][] estacionamiento = new char [10][10];
    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    inicializarEstacionamiento();
    mostrarEstacionamiento();
    mostrarMenu (sc);
    }
    
//método para mostrar menú
    public static void mostrarMenu(Scanner sc){
   
    System.out.println("======SISTEMA DE ESTACIONAMIENTO======");
    System.out.println("1. Ingrese Vehículo");
    System.out.println("2. Retirar Vehículo");
    System.out.println("3. Mostrar estacionamiento");
    System.out.println("4. Buscar vehículo por placa");
    System.out.println("5. Mostrar ruta más corta entre entrada y salida");
    System.out.println("6. Mostrar ingresos");
    System.out.println("7. Salir");
    }
    //método para inicializar estacionamiento
    public static void inicializarEstacionamiento(){
        for (int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                
               if ( i==0 || i==9 ||j==0 ||j==9 ){
                   estacionamiento[i][j] = '=';
                    
               } else {
                    estacionamiento [i][j ]= 'L';
               }
            }
        }

    }
    //metodo para mostrar estacionamiento
    public static void mostrarEstacionamiento(){
        for (int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.print(estacionamiento[i][j]+" ");         
            } 
            System.out.println();
        } 
    }

}   
