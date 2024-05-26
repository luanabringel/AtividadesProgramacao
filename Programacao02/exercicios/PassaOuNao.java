//Luana Bringel Leite (matrícula: 121210141) LP2 2022.1
import java.util.Scanner;

public class PassaOuNao {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float num1 = sc.nextFloat();
        float num2 = sc.nextFloat();
        float med = (num1 + num2)/2;
        if(med < 7.0){
            System.out.println("pass: False!");
        }else {
            System.out.println("pass: True!");
        }
    }
}
