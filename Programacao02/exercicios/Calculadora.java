//Luana Bringel Leite (matrícula: 121210141) LP2 2022.1
import java.util.Scanner;

public class Calculadora{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String c = sc.nextLine();
        if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
            float num1 = sc.nextFloat();
            float num2 = sc.nextFloat();
            float soma = num1 + num2;
            float sub = num1 - num2;
            float mult = num1 * num2;
            float div = num1 / num2;
            if(c.equals("+")){
                System.out.printf("RESULTADO : %.1f", soma);
            }else if(c.equals("-")){
                System.out.printf("RESULTADO : %.1f", sub);
            }else if(c.equals("*")){
                System.out.printf("RESULTADO : %.1f", mult);
            }else if(c.equals("/") && num2 != 0){
                System.out.printf("RESULTADO : %.1f", div);
            }else{
                System.out.println("ERRO");
            }
        }else{
            System.out.println("ENTRADA INVALIDA");
        }
        }
    }