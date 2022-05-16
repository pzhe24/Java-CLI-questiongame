import java.util.*;

public class Main {

    public static void main(String args[]){
        String startRes="";
        boolean ran = false;
        try {
            while (!startRes.equalsIgnoreCase("s")) {
                if (!ran) {
                    startRes = mainMenu();
                    ran = true;
                }
                if (startRes.equalsIgnoreCase("i")) {
                    startRes = getInstructions();
                }
                if (startRes.equalsIgnoreCase("b")) {
                    startRes = mainMenu();
                }
                if (startRes.equalsIgnoreCase("s")) {
                    new Game();
                }
                if(startRes.equalsIgnoreCase("q")){
                    System.out.println("Game Ending...");
                    System.exit(0);
                }
                if (!startRes.toLowerCase().matches("s|i|b|q")) {
                    throw new IncorrectAnswerException("Option not supported");
                }
            }
        }catch(IncorrectAnswerException e){
            e.printStackTrace();
        }
    }

    public static String getInstructions(){
        String response="";
        Scanner in = new Scanner(System.in);
        System.out.println("____________________________________________________________________________________");
        System.out.println("When you start the game, you will go through 3 rounds.");
        System.out.println("There will be 3 Questions per Round.");
        System.out.println("If you pass all 3 rounds, you will win $1,000,000.");
        System.out.println("Use 1,2,3,4 to answer the questions.");
        System.out.println("At the end of each round, you will be given the option to walk away with your money.");
        System.out.println("If you answer a question wrong, you will lose all your money.");
        System.out.println("____________________________________________________________________________________");
        System.out.println("To go back to the main screen enter \"B\"");
        System.out.println("To quit the game, enter \"Q\"");
        System.out.println("To start game, enter \"S\"");
        response = in.next();
        return response;
    }

    public static String mainMenu(){
        String response="";
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println("Welcome to Who Wants To Be A Millionaire!");
        System.out.println("__________________________________________");
        System.out.println("If you want to start the Game, enter \"S\"");
        System.out.println("If you want to want to read the instructions, enter \"I\"");
        System.out.println("If you want to quit the game, enter \"Q\"");
        System.out.print("Enter your response: ");
        response = in.next();
        return response;
    }
}
