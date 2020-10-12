import java.util.Scanner;

public class Principal {

    private String [] cadena;
    private String entrada;

    private Grafo grafo =new Grafo(1);;

    public void entrada(){
        Scanner entradaScanner = new Scanner(System.in);
        System.out.println("Ingrese la expresion:");
        entrada = entradaScanner.nextLine();
        System.out.println(entrada);
        cadena=separador(entrada);
        //cadena=agregarA(cadena);
        for (int i=0;i<cadena.length;i++) {
            System.out.println(cadena[i]);
        }
    }

    private String[] agregarA(String[] cadena) {
        String[] tmp=new String[cadena.length+1];
        for (int i=0;i<cadena.length;i++){
            tmp[i]=cadena[i];
        }
        tmp[cadena.length]="a";
        return tmp;
    }

    private String[] separador(String a){
        String[] salida = a.split("");
        return salida;
    }



    private static void run() {
        Principal prueba = new Principal();
        prueba.entrada();

        prueba.grafo.dato= prueba.cadena;
        prueba.grafo.añadir("(",")");
        prueba.grafo.añadir("[","]");
        prueba.grafo.añadir("{","}");

        boolean aaa= prueba.grafo.probar();
        if(aaa){
            System.out.println("Con la entrada:\n"+ prueba.entrada+"\nSI es valida");
        }else {System.out.println("Con la entrada:\n"+ prueba.entrada+"\nNO es valida");}
    }

    public void crearGrafo(){
        grafo=new Grafo(1);
    }

    public static void main(String[] args) {
        run();

    }



}
