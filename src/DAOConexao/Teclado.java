package DAOConexao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Teclado {

    public static String lerString(String rotulo) {
        System.out.println(rotulo);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    public static int lerInt(String rotulo) {
        System.out.println(rotulo);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }

    public static int lerLong(String rotulo) {
        System.out.println(rotulo);
        Scanner scanner = new Scanner(System.in);
        return (int) scanner.nextLong();
    }

    public static double LerDouble(String rotulo) {
        System.out.println(rotulo);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();

    }

    public static LocalDate Lerdata(String rotulo) {
        System.out.println(rotulo);
        Scanner scanner = new Scanner(System.in);
        String dataAux = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataAux, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return data;
    }
    public static void TesteCommit (){

        System.out.println("Commit Feito!!!");
        System.out.println("Não sei se foi Feito!!!");
    }
}
