package ac.at.fhcampuswien;

import java.util.Scanner;

public class Menu {
//    Menu Klasse (4 Pkt): die Menu Klasse ist für die Ausgabe des Konsolenmenüs, sowie die
//    Usereingaben zuständig. Wurden die Usereingaben validiert, werden diese an die
//    entsprechenden AppController Funktionen weitergegeben (dh. die konkrete Logik vom
//    AppController wird aufgerufen). Dementsprechend enthält die Klasse eine Membervariable
//    von AppController. Weiters zwei konstante Membervariablen für invalide Usereingaben
//    (INVALID_USER_INPUT_MESSAGE) und den Verabschiedungstext (EXIT_MESSAGE).

    AppController controller = new AppController();
    String INVALID_USER_INPUT_MESSAGE = "Invalid Input!";
    String EXIT_MESSAGE = "Goodbye Pal, have a nice day";

    public void start() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            printMenu();

            String input = scanner.next();
            handleInput(input);
        }
    }

    public void handleInput(String input) {

        switch (input) {
            case "a":
                getTopHeadlinesAustria(controller);
                break;
            case "b":
                getAllNewsBitcoin(controller);
                break;
            case "y":
                getArticleCount(controller);
                break;
            case "q":
                printExitMessage();
                System.exit(0);
            default:
                printInvalidInputMessage();

        }


    }

    public void getArticleCount(AppController ctrl) {
        System.out.println(ctrl.getArticleCount());

    }

    public void getTopHeadlinesAustria(AppController ctrl) {
        System.out.println(ctrl.getTopHeadlinesAustria().toString());


    }

    public void getAllNewsBitcoin(AppController ctrl) {

        System.out.println(ctrl.getAllNewsBitcoin().toString());

    }

    public void printExitMessage() {

        System.out.println(EXIT_MESSAGE);

    }

    public void printInvalidInputMessage() {

        System.out.println(INVALID_USER_INPUT_MESSAGE);


    }

    public void printMenu() {

        System.out.println("*****************************\n" +
                "*  Welcome to NewsApp  *\n" +
                "*****************************\n");
        System.out.println("Enter what you want to do\n" +
                "a: Get top headlines austria\n" +
                "b: Get all news about bitcoin\n" +
                "y: Count articles\n" +
                "q: Quit Program");


    }


}
