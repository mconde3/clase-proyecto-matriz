//Programación: Miguel Alejandro Conde Suero
//Fecha: 10 de Noviembre

import java.util.Scanner; //Importación del código de la clase Scanner desde la biblioteca Java

public class matrices {

	public static void main(String[] args) {


		// Mostramos un titulo de presentación del proyecto			
		System.out.println("Estructura de datos T-01");
		System.out.println("Evaluación 1");
		
		//Pedir tamaño de la matriz
		
		//Declaramos las variables que contendran el tamaño de la matrizç
		int x = 0;	 
		int y = 0;

		//Solicitamos al usuario el tamaño de las filas de la matriz
		System.out.println ("Por favor introduzca X:");
            		
		Scanner xi = new Scanner (System.in); 
		String x2 = xi.nextLine (); 
			  
		//Solcitamos al usuario el tamaño de las columnas de la matriz
		System.out.println ("Por favor introduzca Y:");

		Scanner yi = new Scanner (System.in); 
		String y2 = yi.nextLine (); 
		  
		//Convertir en entero
		x  = Integer.parseInt(x2);
		y  = Integer.parseInt(y2); 
		
  		
		//Rellenar la matriz
		int [][] lamatriz1 = new int[x][y];
		int [][] lamatriz2 = new int[x][y];
		int [][] lamatriz3 = new int[x][y];

		lamatriz1 = RellenaMatriz(x,y);
		lamatriz2 = RellenaMatriz(x,y);
		lamatriz3 = RellenaMatriz(x,y);
		
		System.out.println (" ");
		System.out.println ("Rellenando matrices");
		System.out.println (" ");

		
		System.out.println ("Matriz 1:");
		imprimirmatriz(lamatriz1,x,y);
		
		System.out.println (" ");
		
		System.out.println ("Matriz 2:");
		imprimirmatriz(lamatriz2,x,y);
		
		System.out.println (" ");

		System.out.println ("Matriz 3:");
		imprimirmatriz(lamatriz3,x,y);

		System.out.println (" ");

		System.out.println ("Sumando matriz 1 y 2 ");
		
		//Sumo las dos primeras matriz
		int [][] matrizfinal = new int[x][y];
		matrizfinal = SumaMatriz(lamatriz1, lamatriz2,x,y);

		System.out.println (" ");
		
		imprimirmatriz(matrizfinal,x,y);
		
		//Multiplicar
		int [][] matrizfinal2 = new int[x][y];
		matrizfinal2 = MultiplicaMatriz(matrizfinal, lamatriz3,x,y);
		
		System.out.println (" ");
		System.out.println (" Multiplicando matriz resultado con matriz 3");
		System.out.println (" ");
		imprimirmatriz(matrizfinal2,x,y);		
	
		
		//Determinar si una matriz es identidad (Su diagonal es 1)	
		
		//Matriz para ejemplo
		int MatrizIdentidad[][] = {       
			{1, 0, 0, 0},    
			{0, 1, 0, 0},    
			{0, 0, 1, 0},
			{0, 0, 0, 1}    
		}; 
		System.out.println (" ");
		System.out.println (" Determinando matriz identidad"); 
		System.out.println (" ");
		imprimirmatriz(MatrizIdentidad,4,4);

		boolean respuesta = ValidaMatrizIdentidad(MatrizIdentidad,4,4);

		if( respuesta ){

			System.out.println ("La matriz es identidad:");

		}else{
			System.out.println ("La matriz no es identidad:");
		}
		

		//Determinar si la matriz es trinagular inferior

		//Matriz para ejemplo
		int MatrizTriangular[][] = { { 9, 0, 0, 0 }, 
                                     { 9, 9, 0, 0 }, 
                                     { 9, 9, 9, 0 }, 
									 { 0, 9, 9, 9 } };
									
		System.out.println (" ");
		System.out.println ("Determinando matriz trinagular inferior"); 
		System.out.println (" ");

		imprimirmatriz(MatrizTriangular,4,4);									 
		if( ValidaMatrizTriangular(MatrizTriangular,4,4) ){
			System.out.println ("La matriz es triangular inferior");
					
		}else{
			System.out.println ("La matriz no es triangular inferior");
		}
		
		
	}
	
	public static int[][] RellenaMatriz(int px,int py){
	
		int[][] tmp = new int[px][py];
	
		//variables string para concatenar los valores
		// luego las convierto a nuemrico integer para
		// para realizar las operaciones de suma y resta
		String sx;
		String sy;
	
		// imprimir matriz
		for (int x=0; x<px ; x++)
		{
		    for (int y=0; y < py ; y++){
		    
		        sx = "23" + String.valueOf(x) + "4"; 		    	
		    	sy = "20" + String.valueOf(y) + "3";
		    	
		    	//Covertimos a numerico para hacer el calculo matematico
		    	int valor = (Integer.parseInt(sx) + Integer.parseInt(sy)) - 3;		    
				tmp[x][y] = valor;
			}
		}
	
		 // retorno la matriz
	         return tmp;
        
	}
	
	
	public static int[][] SumaMatriz(int[][] matriz1, int[][] matriz2, int px, int py) {
		
		//Creamos La matriz resulante del tamaño introducido por el usuario
		int[][] matriz_resultado = new int[px][py];

		//Recorremos las matrices sumando sus celdas y metemos el resultado en la
		//la celda correspondiente de la matriz resultado
        for (int x=0; x < px; x++) {
			for (int y=0; y < py; y++) {				
				matriz_resultado[x][y] = matriz1[x][y] + matriz2[x][y];								
			}
		} 

		//Devolvemos la matriz resultado
		return matriz_resultado;
        
	}

	public static int[][] MultiplicaMatriz ( int[][] matriz1, int[][] matriz2, int px, int py) {

		//Creo la matriz resultante
		int[][] matriz_resultante = new int[px][py];
		
		//Recorro las matrices (En este proyecto considero las matrices creada con las mismas dimensiones)
		for (int x= 0; x < px; x++){
			for (int y=0; y < py; y++){
				//Recorro el indicador de la columna activa que apunta a la matrzi resultante
				//donde debo colocar el valor resultante
				for (int col = 0; col < px; col++){
					matriz_resultante[x][y] = matriz_resultante[x][y] + matriz1[x][col] * matriz2[col][y];
				}
			}
		}
		//Devolvemos la matriz resultado
		return matriz_resultante;
	 }
	
	
	
	public static boolean ValidaMatrizIdentidad(int[][] matriz1, int px, int py) {

		//Recorro las matrices (En este proyecto considero las matrices creada con las mismas dimensiones)
		//verifico si la diagonal es 1

		boolean es = true; 

        for(int x = 0; x < px; x++){    
            for(int y = 0; y < py; y++){    
              if(x == y){
				  if(matriz1[x][y] != 1){    
    				  es = false; 
    				  //Busco otra fila   
    				  break;    
				  }
              }    
              if(x != y){
			    if(matriz1[x][y] != 0){    
				  es = false;  
				  //Busco otra fila   
				  break;  
				}  
              }    
            }    
        } 
		 
		return es;
        
	}
	
	public static boolean ValidaMatrizTriangular(int[][] matriz1, int px, int py) {
         
        //Recorremos la matriz
		for (int x = 0; x < px; x++) {

			//
			for (int y = x + 1; y < x; y++) {

				//Verfico si las posiciones de la esquina superior tiene 0 y no es
				//una posición de la diagonal.
				if (matriz1[x][y] != 0) {
					return false; 
				}
			}
		}
	  
		return true; 
		 
	}
	
	
	public static void imprimirmatriz(int[][] matriz, int px, int py){
	
	       // imprimir matriz
		for (int x=0; x< px ; x++)
		{
		    for (int y=0; y < py ; y++)
		    
		        System.out.print(matriz[x][y] + " ");
	 
		    System.out.println();
		}
	
	}
	

}
