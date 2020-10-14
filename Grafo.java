import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Grafo {
    private ArrayList<ArrayList<Nodo>> grafo;
    private Stack pila;
    public String[] dato;

    public  String entrada;

    public Grafo(int v){
        grafo = new ArrayList<ArrayList<Nodo> >(v);
        for (int i = 0; i < v; i++){
            grafo.add(new ArrayList<Nodo>());
        }
        pila=new Stack();
        pila.add("I");
    }


    public boolean probar(){
        for(int i=0; i<dato.length;i++){
            boolean tmp1=false;
            for(int j=0;j<grafo.get(0).size() && !tmp1;j++) {
                Nodo tmp = grafo.get(0).get(j);
                if(comprobar(tmp,dato[i])){
                    tmp1=true;
                }
            }
            if(tmp1==false){
                return false;
            }
        }

        if(pila.peek().equals("F")){
            return true;
        }else {return false;}

    }

    private boolean comprobar(Nodo comprobar,String dato) {

        //caso inicial
        if(dato.equals(comprobar.caracter) && pila.peek().equals("I")){
            // System.out.println("1");
            pila.pop();
            pila.add("F");
            //System.out.println(dato+"---");
            pila.add(dato);
            return true;
        }
        //caso encontrar par
        else if(dato.equals(")") ||dato.equals("]") ||dato.equals("}") ){
            //else if(dato.equals(comprobar.caracter) && pila.peek()==comprobar.caracter){
            //System.out.println("2");
            //pila.pop();
            //return true;
            if(dato.equals(")") && pila.peek().equals("(")){
                //System.out.println("2");
                pila.pop();
                return true;
            }else if(dato.equals(")") && pila.peek().equals("[")){
                //System.out.println("3");
                return false;
            }else if(dato.equals(")") && pila.peek().equals("{")){
                return false;
            }
            else if(dato.equals("}") &&  pila.peek().equals("{")) {
                //System.out.println("2");
                pila.pop();
                return true;
            }else if(dato.equals("}") &&  pila.peek().equals("[")){
                //System.out.println("3");
                return false;
            }else if(dato.equals("}") &&  pila.peek().equals("(")) {
                //System.out.println("3");
                return false;
            }else if(dato.equals("]") &&  pila.peek().equals("[")) {
                //System.out.println("2");
                pila.pop();
                return true;
            }
            else if(dato.equals("]") &&  pila.peek().equals("(")) {
                //System.out.println("3");
                return false;
            }else if(dato.equals("]") &&  pila.peek().equals("{")) {
                //System.out.println("3");
                return false;
            }
            else if((dato.equals(")") || (dato.equals("]") || (dato.equals("}")) && pila.peek().equals("I")))){
                //System.out.println("3");
                return false;
            }
            return false;

        }
        //caso agregar
        else if(dato.equals(comprobar.caracter) && (pila.peek().equals("(") || pila.peek().equals("[") || pila.peek().equals("{")||pila.peek().equals("I"))){
            if(dato.equals("(") || dato.equals("[") || dato.equals("{")){
                //System.out.println("3");
                //  System.out.println(dato);
                pila.add(dato);
                return true;
            }
        }        //caso final
        else if(dato.equals(comprobar.caracter) && pila.peek().equals("F")) {
            //System.out.println("4");
            return true;
        }
        return false;

    }


    public void añadir(String dato1, String dato2) {
        //inicio, entra el dato y tiene coincidencia con vacio
        grafo.get(0).add(new Nodo(dato1, 0,"I"));
        //ecnotrar par entra del dato2 y si es
        grafo.get(0).add(new Nodo(dato2,0,dato1));
        //agregar
        grafo.get(0).add(new Nodo(dato1,0,dato1));
        //final
        grafo.get(0).add(new Nodo("",0,"F"));
    }



    public void imprimir(){
        for(int i=0;i<grafo.size();i++){
            System.out.println("Vertice:" + i);
            for (int j = 0; j < grafo.get(i).size(); j++) {
                System.out.println("  "+grafo.get(i).get(j).toString()+",");
            }
            System.out.println();
        }
    }
    public void entra() {
        Scanner entradaScanner = new Scanner(System.in);
        System.out.println("Ingrese la expresion:");
        entrada = entradaScanner.nextLine();
        //System.out.println(entrada);
        dato=separador(entrada);
        //dato=agregarA(dato);
    }

    private String[] agregarA(String[] cadena) {
        String[] tmp = new String[cadena.length + 1];
        for (int i = 0; i < cadena.length; i++) {
            tmp[i] = cadena[i];
        }

        tmp[cadena.length] = "";
        //System.out.println(tmp.length);
        return tmp;
    }
        private String[] separador(String a){
        String[] salida = a.split("");
        //System.out.println(salida.length);
        return salida;
    }


    public static void main(String[] args) {
        Grafo prueba=new Grafo(1);
        prueba.añadir("(",")");
        prueba.añadir("[","]");
        prueba.añadir("{","}");

        prueba.entra();

        //prueba.dato= new String[]{"{","{","[","(","{","}",")","}","}","}"};
        //prueba.dato= new String[]{"[","(","{","}",")","}"};
        //prueba.dato= new String[]{"[","]"};
        //prueba.dato= new String[]{"{","(",")","[","(",")","]","}"};
        for(int i=0;i<prueba.dato.length;i++){
            System.out.print(prueba.dato[i]);
        }
        //System.out.println();
        //prueba.imprimir();

        if(prueba.probar()){
            System.out.print(": Esta cadena ES valida");
        }else{
            System.out.print(": Esta cadena NO ES valida ");
        }

    }

}
