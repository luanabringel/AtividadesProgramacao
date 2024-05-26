//Luana Bringel Leite (matrícula: 121210141) LP2 2022.1
import java.util.Scanner;

public class FunçãoMonotona {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float num1 = sc.nextFloat();
        float num2 = sc.nextFloat();
        float num3 = sc.nextFloat();
        float num4 = sc.nextFloat();
        if(num1 > num2 && num2 > num3 && num3 > num4){
            System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
        }else if(num1 < num2 && num2 < num3 && num3 < num4){
            System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
        }else{
            System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
        }
    }
}
