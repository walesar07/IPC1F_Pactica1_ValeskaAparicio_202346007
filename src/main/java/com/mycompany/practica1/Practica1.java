
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
    
    static final double TARIFA = 10.0;
    static double ingresos = 0;
    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    inicializarEstacionamiento();
    generarEntradaSalida();
    mostrarEstacionamiento();
    mostrarMenu (sc);
    sc.close();
    }
    
//método para mostrar menú
    public static void mostrarMenu(Scanner sc){
        
        int opcion;
        
        do{
   
    System.out.println("======SISTEMA DE ESTACIONAMIENTO======");
    System.out.println("1. Ingrese Vehículo");
    System.out.println("2. Retirar Vehículo");
    System.out.println("3. Mostrar estacionamiento");
    System.out.println("4. Buscar vehículo por placa");
    System.out.println("5. Mostrar ruta más corta entre entrada y salida");
    System.out.println("6. Mostrar ingresos");
    System.out.println("7. Salir");
    
    System.out.print("Seleccione una opción: ");
    opcion = sc.nextInt();
    sc.nextLine();
    
    switch (opcion){
        case 1: 
            ingresoVehiculos(sc);
            break;
        case 2: 
            retirarVehiculo(sc);
            break;
        case 3: 
            mostrarEstacionamiento();
            break;
        case 4: 
            buscarVehiculo(sc);
            break;
        case 5: 
            calcularRuta();
            break;
        case 6: 
            mostrarIngresos();
            break;
        case 7: 
            System.out.println("Opción inválida.");
            break;
        default:
            System.out.println("opción inválida.");
    }
     
    }while (opcion !=7);
    
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
   public static void mostrarEstacionamiento() {

    int libres = 0;
    int ocupados = 0;

    System.out.println("\n===== ESTACIONAMIENTO =====");

    // Encabezado de columnas
    System.out.print("    ");

    for (int j = 0; j < 10; j++) {
        System.out.printf("%3d ", j + 1);
    }

    System.out.println();

    for (int i = 0; i < 10; i++) {

        // Número de fila
        System.out.printf("%3d ", i + 1);

        for (int j = 0; j < 10; j++) {

            System.out.printf("[%c] ", estacionamiento[i][j]);

            if (estacionamiento[i][j] == 'L') {
                libres++;
            }

            if (estacionamiento[i][j] == 'A') {
                ocupados++;
            }
        }

        System.out.println();
    }

    System.out.println();
    System.out.println("Espacios libres: " + libres);
    System.out.println("Espacios ocupados: " + ocupados);

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
                if (placas[i][j] != null && placas [i][j].equals(placa)){
                    return true;
                }
            }
        
        }
        
        return false;
    }
    //método para buscar estacionamiento libre
    public static int[]buscarespaciolibre(){
        for (int i=1; i<9; i++) {
            for (int j=1; j<9; j++) {
                if (estacionamiento [i][j]== 'L'){
                    return new int[]{i,j};
                    
                }
            }
        }
        return null;
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
        int[] espacio = buscarespaciolibre();
        
        if (espacio== null){
            System.out.println("El estacionamiento está lleno.");
            return;
        }
        double pago;

do {
    System.out.print("Ingrese el monto a pagar: Q");
    pago = sc.nextDouble();
    sc.nextLine();

    if (pago < 0) {
        System.out.println("El monto no puede ser un número negativo.");
    } else if (pago < TARIFA) {
        System.out.println("Pago insuficiente. Ingrese nuevamente el monto.");
    }

} while (pago < TARIFA);
        
        double cambio = pago - TARIFA;

System.out.printf("Cambio: Q%.2f%n", cambio);
        
        
        estacionamiento[espacio[0]][espacio[1]] = 'A';
        placas[espacio[0]][espacio[1]] = placa;  
        
        ingresos += TARIFA;
        
        System.out.println("Vehículo ingresado correctamente.");
        System.out.println("Placa" + placa);
        System.out.println("Posición: ["+ espacio[0]+"]["+ espacio[1]+"]");
        
        System.out.println("Cambio: Q" + cambio);
        mostrarEstacionamiento();
         
        
        
        
    } 
    //método buscar posición de placa
    public static int[] buscarPosicionPlaca(String placa) {

    for (int i = 1; i < 9; i++) {

        for (int j = 1; j < 9; j++) {

            if (placas[i][j] != null &&
                placas[i][j].equals(placa)) {

                return new int[]{i, j};
            }
        }
    }

    return null;
}
    //método para retirar vehículos
    public static void retirarVehiculo(Scanner sc) {

    System.out.print("Ingrese la placa del vehículo a retirar: ");
    String placa = sc.nextLine();
    
     if (!validarPlaca(placa)) {
        System.out.println("Placa inválida.");
        return;
    }

    int[] posicion = buscarPosicionPlaca(placa);

    if (posicion == null) {
        System.out.println("Vehículo no encontrado.");
        return;
    }

    int fila = posicion[0];
    int columna = posicion[1];

    estacionamiento[fila][columna] = 'L';
    placas[fila][columna] = null;

    System.out.println("Vehículo retirado correctamente.");
    System.out.println("Placa: " + placa);
    System.out.println("Fila: " + fila);
    System.out.println("Columna: " + columna);

    mostrarEstacionamiento();
}
    //método para buscar vehículos
    public static void buscarVehiculo(Scanner sc) {

    System.out.print("Ingrese la placa a buscar: ");
    String placa = sc.nextLine();

    int[] posicion = buscarPosicionPlaca(placa);

    if (posicion == null) {
        System.out.println("Vehículo no encontrado.");
        return;
    }

    System.out.println("\nVehículo encontrado.");
    System.out.println("Placa: " + placa);
    System.out.println("Fila: " + posicion[0]);
    System.out.println("Columna: " + posicion[1]);
}
    //Método para ver los ingresos recaudados
    public static void mostrarIngresos() {

    System.out.println("\n===== INGRESOS =====");
    System.out.println("Ingresos acumulados: Q" + ingresos);
}
    public static int posicionPerimetro(int fila, int columna) {

    if (fila == 0) {
        return columna;
    }

    if (columna == 9) {
        return 9 + fila;
    }

    if (fila == 9) {
        return 27 - columna;
    }

    if (columna == 0) {
        return 36 - fila;
    }

    return -1;
}
    //método calcula la ruta más corta para salir 
    public static void calcularRuta() {
        int posicionEntrada =
        posicionPerimetro(entradafila, entradacolumna);

        int posicionSalida =
        posicionPerimetro(salidafila, salidacolumna);

        int distanciaHorario =
        (posicionSalida - posicionEntrada + 36) % 36;

        int distanciaAntihorario =
        (posicionEntrada - posicionSalida + 36) % 36;
System.out.println("\n===== RUTAS =====");

System.out.println("Distancia sentido horario: "
                   + distanciaHorario + " posiciones");

System.out.println("Distancia sentido antihorario: "
                   + distanciaAntihorario + " posiciones");

if (distanciaHorario < distanciaAntihorario) {

    System.out.println("Ruta recomendada: sentido horario ("
                       + distanciaHorario + " posiciones)");

} else if (distanciaAntihorario < distanciaHorario) {

    System.out.println("Ruta recomendada: sentido antihorario ("
                       + distanciaAntihorario + " posiciones)");

} else {

    System.out.println("Ambas rutas tienen la misma distancia.");
    System.out.println("Cualquiera de las dos puede utilizarse.");
}
   }
    


}   
