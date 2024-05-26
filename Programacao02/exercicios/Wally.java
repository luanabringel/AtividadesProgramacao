//Luana Bringel Leite (matricula: 121210141) LP2 2022.1
import java.util.Scanner;

public class Wally { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nomes;
        String[] listaNomes;
        int i;

        while(true){
            boolean igual = false;
            nomes = sc.nextLine();
            listaNomes = nomes.split(" ");
            if(nomes.equals("wally")){
                break;
            }
            for(i = listaNomes.length-1; i >= 0; i--){
                if(listaNomes[i].length() == 5){
                    System.out.println(listaNomes[i]); 
                    igual = true;
                    break;
                }
            }
            if(igual == false){
                System.out.println("?");
            }
        }
    }
}
