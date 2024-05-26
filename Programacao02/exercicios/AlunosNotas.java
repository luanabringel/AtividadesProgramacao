//Luana Bringel Leite (matricula: 121210141) LP2 2022.1
import java.util.Scanner;

public class AlunosNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada;
        String[] dados;
        int notas;
        int menorNota = 1000, maiorNota = 0, media = 0, soma = 0;
        int acimaMedia = 0, abaixoMedia = 0, cont = 0;

        while(true){
            entrada = sc.nextLine();
            dados = entrada.split(" ");
            if(entrada.equals("-")){
                break;
            }
            notas = Integer.valueOf(dados[1]).intValue();
            if(notas < menorNota){
                menorNota = notas;
            }
            if(notas > maiorNota){
                maiorNota = notas;
            }
            soma += notas;
            cont += 1;
            if(notas >= 700){
                acimaMedia += 1;
            }else{
                abaixoMedia += 1;
            }
            media = soma / cont;
        }
        System.out.println("maior: " + maiorNota);
        System.out.println("menor: " + menorNota);
        System.out.println("media: " + media);
        System.out.println("acima: " + acimaMedia);
        System.out.println("abaixo: " + abaixoMedia);
    }
}
