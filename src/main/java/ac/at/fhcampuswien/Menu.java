package ac.at.fhcampuswien;

import java.util.Scanner;

public class Menu {

    AppController controller = new AppController();
    String INVALID_USER_INPUT_MESSAGE = "Invalid Input!";
    String EXIT_MESSAGE = "Goodbye Pal, have a nice day";

    //Uses the printMenu Method to print out the menu and allows user input with a scanner

    public void start() {

        Scanner scanner = new Scanner(System.in);

        printMenu();

        String input = scanner.next();
        handleInput(input);
    }

    //Defines which user input is handled how

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
    //Prints out the count of articles

    public void getArticleCount(AppController ctrl) {
        System.out.println(ctrl.getArticleCount());

    }
    //Prints out the top headlines in austria

    public void getTopHeadlinesAustria(AppController ctrl) {
        System.out.println(ctrl.getTopHeadlinesAustria().toString());


    }

    //Prints out the bitcoin news

    public void getAllNewsBitcoin(AppController ctrl) {

        System.out.println(ctrl.getAllNewsBitcoin().toString());

    }

    //Prints out message if User exits the app

    public void printExitMessage() {

        System.out.println(EXIT_MESSAGE);

    }

    //Prints out the message if the input the User puts is invalid

    public void printInvalidInputMessage() {

        System.out.println(INVALID_USER_INPUT_MESSAGE);


    }
    //Prints out the text of the main menu

    public void printMenu() {

        System.out.println("*****************************\n" +
                "*  Welcome to NewsApp  *\n" +
                "*****************************");
        System.out.println("Enter what you want to do\n" +
                "a: Get top headlines austria\n" +
                "b: Get all news about bitcoin\n" +
                "y: Count articles\n" +
                "q: Quit Program");


    }


}
