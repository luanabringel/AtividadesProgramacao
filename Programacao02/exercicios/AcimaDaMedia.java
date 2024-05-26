//Luana Bringel Leite (matrícula: 121210141) LP2 2022.1
import java.util.Scanner;

public class AcimaDaMedia {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		String[] numeros;
		String sequencia;
		sequencia = sc.nextLine();
		numeros = sequencia.split(" ");
        int num;
		int soma = 0;
		for(int i = 0; i < numeros.length; i++) {
			num = Integer.valueOf(numeros[i]);
			soma += num;
		}
		int media = soma / numeros.length;
		for(int i = 0; i<numeros.length; i++) {
			num = Integer.valueOf(numeros[i]);
			if(num > media){
				System.out.print(num + " ");
			}
		}	
	}
}