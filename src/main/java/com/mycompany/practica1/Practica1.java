
package com.mycompany.practica1;

 import java.util.Scanner;
 import java.util.Random;

public class Practica1 {
    
    //arreglo representa estacionamiento
    static char [][] estacionamiento = new char [10][10];
    //arreglo para guardar placas
    static String[][] placas = new String [10][10];
    
    //variables 
    static int entradafila;
    static int entradacolumna;
    static int salidafila;
    static int salidacolumna;
    
    static Random random = new Random();
    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    inicializarEstacionamiento();
    generarEntradaSalida();
    mostrarEstacionamiento();
    
    System.out.println(validarPlaca("P123ABC"));
    System.out.println(validarPlaca("P12ABCD"));
    System.out.println(validarPlaca("A123ABC"));
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
    //método para generar entrada y salida
    public static void generarEntradaSalida(){
        
        //utilizamos random para generar la entrada y salida (laterales)
         int ladoentrada = random.nextInt(4);
        
        switch (ladoentrada){
            
            case 0:
                entradafila = 0;
                entradacolumna = random.nextInt(8)+ 1;
                break;
            case 1: 
                entradafila = 9;
                entradacolumna = random.nextInt(8)+1;
                break;
            case 2:
                entradafila = random.nextInt(8)+1;
                entradacolumna= 0;
                break;
            case 3:
                entradafila = random.nextInt(8)+1;
                entradacolumna= 9;
                break;                                
        }
        
        int ladosalida = random.nextInt(4);
        
        switch (ladosalida){
            
            case 0:
                salidafila = 0;
                salidacolumna = random.nextInt(8)+ 1;
                break;
            case 1: 
                salidafila = 9;
                salidacolumna = random.nextInt(8)+1;
                break;
            case 2:
                salidafila = random.nextInt(8)+1;
                salidacolumna= 0;
                break;
            case 3:
                salidafila = random.nextInt(8)+1;
                salidacolumna= 9;
                break;                                
        }
        //agregamos un bucle while para que la entrada y salida no puedan ser las mismas
        while (entradafila == salidafila && entradacolumna == salidacolumna){
            
            ladosalida = random.nextInt(4);
            
           switch (ladosalida){
               
            case 0:
                salidafila = 0;
                salidacolumna = random.nextInt(8)+ 1;
                break;
            case 1: 
                salidafila = 9;
                salidacolumna = random.nextInt(8)+1;
                break;
            case 2:
                salidafila = random.nextInt(8)+1;
                salidacolumna= 0;
                break;
            case 3:
                salidafila = random.nextInt(8)+1;
                salidacolumna= 9;
                break;  
           }
        }
    //colocar entrada y salida en estacionamiento
    estacionamiento[entradafila][entradacolumna] = 'E';
    estacionamiento[salidafila][salidacolumna] = 'S';
    
   
        
    }
    
    //método para validar placa
    public static boolean validarPlaca (String placa){
        if (placa.length()!= 7){
            return false;
        }
        if (placa.charAt(0)!= 'P'){
            return false;
        }
        if (!Character.isDigit(placa.charAt(1))||
            !Character.isDigit(placa.charAt(2))||
            !Character.isDigit(placa.charAt(3))){
            return false;
        }
        if (!Character.isUpperCase(placa.charAt(4))||
            !Character.isUpperCase(placa.charAt(5))||
            !Character.isUpperCase(placa.charAt(6))){
            return false;
    }
    return true;
    
   
    
}
    //método buscar placa
    public static boolean buscarPlaca(String placa){
        for (int i=1; i<9; i++){
            for (int j=1; j<9; j++){
                if (placas[i][j] != null && placas [i][j].equals(placas)){
                    return true;
                }
            }
        
        }
        
        return false;
    }
    //método para ingreso de vehículos
    public static void ingresoVehiculos(Scanner sc){
        System.out.print("Ingrese la placa del vehículo: ");
        String placa = sc.nextLine();
        
        if (!validarPlaca(placa)){
            System.out.println("Placa Inválida.");
            return;
            
        }
        
        if (buscarPlaca(placa)){
            System.out.println("La placa ya está registrada.");
            return;
        }
        
    }
    


}   
