import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] votos = new char[2][cantidadVotos()];
        menu(votos);
    }
    public static int cantidadVotos(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Cuantas parejas de votantes desea?");
        int votos = teclado.nextInt();
        return votos;
    }
    public static char[][] llenarEncuesta(char[][] votos){
        for (int i = 0; i < votos.length; i++) {
            for (int j = 0; j < votos[i].length; j++) {
                int random = (int)(Math.random()*3);
                switch (random){
                    case 0 ->{
                        votos[i][j] = 's';
                    }
                    case 1->{
                        votos[i][j] = 'n';
                    }
                    case 2->{
                        votos[i][j] = 'x';
                    }
                }
            }
        }return votos;
    }
    public static void mostrarEncuesta(char[][] votos){
        for (int i = 0; i < votos.length; i++) {
            if (i==0){
                System.out.print("H: ");
            }else if (i==1){
                System.out.print("M: ");
            }
            for (int j = 0; j < votos[i].length; j++) {
                System.out.print("["+votos[i][j]+"]");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Encuesta llenada con éxito");
        System.out.println();
    }
    public static int cantidadHombresAprobar(char[][] votos){
        int contador = 0;
        for (int i = 0; i < votos[0].length; i++) {
            if (votos[0][i] == 's'){
                contador++;
            }
        }return contador;
    }
    public static int cantidadMujeresDesaprobar(char[][] votos){
        int contador = 0;
        for (int i = 0; i < votos[1].length; i++) {
            if (votos[1][i]=='n'){
                contador++;
            }
        }return contador;
    }
    public static double porcentajeAprobar(char[][] votos){
        double contador = 0;
        double cantidadVotantes = 2*(votos[0].length);
        for (int i = 0; i < votos.length; i++) {
            for (int j = 0; j < votos[i].length; j++) {
                if (votos[i][j]=='s'){
                    contador++;
                }
            }
        }
        return 100*( contador /cantidadVotantes);
    }
    public static int cantidadVotantes(char [][] votos){
        return 2*votos[0].length;
    }
    public static void menu(char[][] votos){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Que desea hacer:");
        System.out.println("1.- Llenar encuesta");
        System.out.println("2.- Cuantos hombres aprueban");
        System.out.println("3.- Cuantas mujeres desaprueban");
        System.out.println("4.- Porcentaje que aprueba");
        System.out.println("5.- Cantidad de votantes");
        System.out.println("6.- Salir");
        int ans = teclado.nextInt();
        llamarMetodos(ans, votos);
        menu(votos);
    }
    public static void llamarMetodos(int ans, char[][] votos){
        DecimalFormat df = new DecimalFormat("#.00");
        switch (ans){
            case 1->{
                if (votos[0][0] == 0){
                    llenarEncuesta(votos);
                    mostrarEncuesta(votos);
                }else {
                    System.out.println("La encuesta ya ha sido llenada");
                }
            }
            case 2->{
                if (votos[0][0] != 0){
                    System.out.println("Cantidad de hombre que aprobaron: "+cantidadHombresAprobar(votos));
                }else {
                    System.out.println("Debe llenar la encuesta primero");
                }
            }
            case 3->{
                if (votos[0][0] != 0){
                    System.out.println("Cantidad de mujeres que desaprobaron: "+cantidadMujeresDesaprobar(votos));
                }else {
                    System.out.println("Debe llenar la encuesta primero");
                }
            }
            case 4->{
                if (votos[0][0] != 0){
                    System.out.println("Porcentaje que aprobó: "+df.format(porcentajeAprobar(votos))+"%");
                }else {
                    System.out.println("Debe llenar la encuesta primero");
                }
            }
            case 5->{
                if (votos[0][0] != 0){
                    System.out.println("Cantidad de votantes: "+cantidadVotantes(votos));
                }else {
                    System.out.println("Debe llenar la encuesta primero");
                }
            }
            case 6->{
                System.out.println("Saliendo del programa...");
                System.exit(0);
            }
        }
    }
}