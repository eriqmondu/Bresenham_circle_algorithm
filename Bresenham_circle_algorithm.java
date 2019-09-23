import java.util.*;
 
/**
 *
 * @author Erik Valdez Mondragón
 * Facultad de Ingeniería, UNAM
 * Computación Gráfica e Interacción Humano-Computadora
 * septiembre 22, 2019
 */
 
 
public class Bresenham_circle_algorithm{
    //coordenadas del centro, coordenadas actuales y el radio del círculo
    static int xc, yc, x, y, radio;
 
    //Listas dinámicas para almacenar lar coordenadas de los 8 arcos
    static List<Integer> arco1 = new ArrayList<>();
    static List<Integer> arco2 = new ArrayList<>();
    static List<Integer> arco3 = new ArrayList<>();
    static List<Integer> arco4 = new ArrayList<>();
    static List<Integer> arco5 = new ArrayList<>();
    static List<Integer> arco6 = new ArrayList<>();
    static List<Integer> arco7 = new ArrayList<>();
    static List<Integer> arco8 = new ArrayList<>();
 
    public static void main(String[] args) {
 
        System.out.println("ALGORITMO DE BRESENHAM PARA DIBUJAR CIRCUNFERENCIAS");
        System.out.println("Introduce las coordenadas del centro de la circunferencia");
        Scanner sc = new Scanner(System.in);
 
        //Lectura de las coordenadas del centro
        System.out.print("X: ");  
        xc = sc.nextInt();
        System.out.print("Y: ");         
        yc = sc.nextInt();
 
        System.out.print("Radio: ");  
        radio = sc.nextInt();
 
        //Inicio en (r, 0)
        bresenham(radio, 0, radio);
 
        System.out.print("Los pixeles a dibujar, por arco, son los siguientes:\n");
 
        System.out.println("Arco (X, Y)");
        imprimirArcos(arco1);
        System.out.println("Arco (-X, Y)");        
        imprimirArcos(arco2);
        System.out.println("Arco (X, -Y)"); 
        imprimirArcos(arco3);
        System.out.println("Arco (-X, -Y)"); 
        imprimirArcos(arco4);
        System.out.println("Arco (Y, X)"); 
        imprimirArcos(arco5);
        System.out.println("Arco (-Y, X)"); 
        imprimirArcos(arco6);
        System.out.println("Arco (Y, -X)"); 
        imprimirArcos(arco7);
        System.out.println("Arco (-Y, -X)"); 
        imprimirArcos(arco8);
 
    }
 
    public static void bresenham(int x,int y,int r){
        double e, es, ed;
        //Mientras X sea mayor o igual a Y, dibujar
        if(x>=y){
                //(x, y)
            arco1.add(xc+(x));
            arco1.add(yc+(y));
 
            //(-x, y)
            arco2.add(xc-(x));
            arco2.add(yc+(y));
 
            //(x, -y)
            arco3.add(xc+(x));
            arco3.add(yc-(y));
 
            //(-x, -y)
            arco4.add(xc-(x));
            arco4.add(yc-(y));                
 
            //(y, x)
            arco5.add(xc+(y));
            arco5.add(yc+(x));
 
            //(-y, x)
            arco6.add(xc-(y));
            arco6.add(yc+(x));
 
            //(y, -x)
            arco7.add(xc+(y));
            arco7.add(yc-(x));
 
            //(-y, -x)
            arco8.add(xc-(y));
            arco8.add(yc-(x));
 
            //Calculo de error, error superior y error diagonal
            e = Math.pow(x, 2) + Math.pow(y, 2) - Math.pow(r, 2);
            es = e + 2*y + 1;
            ed = es - 2*x + 1;
            //Si el error superior es mayor al error diagonal
            if (Math.abs(es)>Math.abs(ed)){
                //Decrementa X, incrementa Y
                bresenham(x-1, y+1, r);
            }
            //Si el error superior es menor o igual al error diagonal
            else{
                //Solo incrementa Y
                bresenham(x, y+1, r);
            }
        }
        else{
            System.out.println("¡Finalizado!");
        }
    }
 
    public static void imprimirArcos(List arco){
        for(int i = 0; i < arco.size(); i = i+2){
            System.out.println("[" + arco.get(i) + ", " + arco.get(i+1) + "]");
        };
    }    
 
}
