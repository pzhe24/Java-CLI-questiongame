import java.util.*;

public class Game {
    private ArrayList<Question> questions;
    private Random rand = new Random();
    private boolean lost = false;
    private int numOfCorrect = 0;
    private String[] easyPrizePool = {"$100","$500","$1,000","$8,000","$16,000","$32,000","$125,000","$500,000","$1,000,000"} ;
    private String[] checkPointRound = {"Round 1", "Round 2", "Round 3"};
    private int checkPoint = 0;
    private int numOfQuestions =24;

    public Game() {
        Scanner in = new Scanner(System.in);
        questions = questionDB();
        //for the number of question in each round.
        int qNum = 1;

        while (!lost && numOfCorrect < 9) {
            //get the question randomly from the questionDB
            int questionNum = rand.nextInt(numOfQuestions);
            Question test = questions.get(questionNum);
            questions.remove(questionNum);
            //lower the numofquestion after removing the question.
            numOfQuestions--;
            System.out.println();
            int ans;
            String ansConfirm;
            try {
                do {//display the question and options
                    System.out.println(checkPointRound[checkPoint]);
                    System.out.println("--------------------------");
                    System.out.println("Question " + qNum);
                    System.out.println("--------------------------");
                    System.out.println(test.getQuestion());
                    System.out.println("1. " + test.getOptions()[0]);
                    System.out.println("2. " + test.getOptions()[1]);
                    System.out.println("3. " + test.getOptions()[2]);
                    System.out.println("4. " + test.getOptions()[3]);
                    System.out.print("Your Answer: ");
                    ans = in.nextInt();
                    //throw incorrectAnswerException (custom exception)
                    if (ans > 0 && ans <= 4) {
                        System.out.println("Do you confirm your answer? (Y/N)");
                        ansConfirm = in.next();
                        if(!(ansConfirm.equalsIgnoreCase("y") || ansConfirm.equalsIgnoreCase("n"))){
                            throw new IncorrectAnswerException("Invalid Option");
                        }
                    }else {
                        throw new IncorrectAnswerException("Answer is not a valid option");
                    }
                } while (!ansConfirm.equalsIgnoreCase("y"));

                //if answer is correct, then we have not lost, and increment the numofcorrect by 1 to use as a checkpoint for each round.
                if (ans - 1 == test.getAnswer()) {
                    lost = false;
                    qNum++;
                    System.out.printf("\nCongratulation, You earned " + easyPrizePool[numOfCorrect] + "\n");
                    numOfCorrect++;
                    //at the end of each round, ask player if they would like to walk away.
                    if (numOfCorrect % 3 == 0) {
                        checkPoint++;
                        qNum = 1;
                        //this if statement is to avoid asking to walk away after winning the game.
                        if (numOfCorrect != 9) {
                            System.out.printf("\nWould you like to walk away? (Y/N)");
                        } else {
                            System.out.println("You've Won!");
                            System.exit(0);
                        }
                        String walkAway = in.next();
                        if (walkAway.equalsIgnoreCase("y")) {
                            System.out.printf("\nCongratulation, you walked away with " + easyPrizePool[numOfCorrect - 1] + "\n");
                            System.exit(0);
                        } else if (walkAway.equalsIgnoreCase("n")) {
                            continue;
                        } else {
                            throw new IncorrectAnswerException("Option is not valid");
                        }
                    }
                }
                //if answer is not correct, lost = true.
                else {
                    lost = true;
                    System.out.printf("\nSorry, you have lost\nYou did not make any money");
                }
            } catch (IncorrectAnswerException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList questionDB(){
        ArrayList<Question> questions = new ArrayList<>();

        Question q1 = new Question("Canada has how many provinces?", new String[]{"10","3","5","8"},0);
        Question q2 = new Question("Canada has how many territories?", new String[]{"10","3","5","8"},1);
        Question q3 = new Question("How large is Canada?", new String[]{"3rd largest","5th largest","1st largest","2nd largest"},3);
        Question q4 = new Question("What is canada's newest territory?", new String[]{"Ottawa","British Colombia","Nunavut","None"},2);
        Question q5 = new Question("Canada got independence in what year?", new String[]{"1900","1952","1870","1982"},3);
        Question q6 = new Question("What was the name of the war that the British won in Canada?", new String[]{"The Canadian War","The Cold War","War of the Roses","The French and Indian War"},3);
        Question q7 = new Question("Which of the following in Canada was valuable to the British?", new String[]{"gold and silver","corn and wheat","natural resources and beaver fur","beaver fur and corn"},2);
        Question q8 = new Question("Java was originally named:", new String[]{"Coffee","Oak","New C++","Duke"},1);
        Question q9 = new Question("Who invented Java?", new String[]{"James Gosling","Sergey Brin","Tim Berners-Lee","Alan Turing"},0);
        Question q10 = new Question("Which of the following NOT a PRIME NUMBER?", new String[]{"2","3","4","5"},2);
        Question q11 = new Question("2x - 3 + 4x = 27", new String[]{"12","4","5","15"},2);
        Question q12 = new Question("5x - 4 + 2x = 3", new String[]{"1","2","3","4"},0);
        Question q13 = new Question("What does HTML stand for?", new String[]{"Hypertext Markup Language","Hypertext Media Language","Hyper Text Marker Line","Hypertext Mangement List"},0);
        Question q14 = new Question("The structure of a web page is primarily created with which of the following?", new String[]{"CSS","Javascript","C++","HTML"},3);
        Question q15 = new Question("What symbol should you use to target an id in css?", new String[]{".","+","id","#"},3);
        Question q17 = new Question("What does CSS stand for?", new String[]{"Creative Style Sheets","Cascading Style Sheets","Colorful Style Spread","Computer Style Spread"},1);
        Question q16 = new Question("What goes up but never comes down? ",new String[]{"Balloon","Your age","arrow","Carbon Dioxide"},1);
        Question q18 = new Question("What is API?", new String[]{"Application Platform Interface", "Application Program Interface","Application Program Interaction","Any Process Interface"},1);
        Question q19 = new Question("What is a Software ?", new String[]{"Software is documentation and configuration of data","Software is set of programs","Software is set of programs, documentation & configuration of data","None of the mentioned"},2);
        Question q20 = new Question("What is cloud computing?", new String[]{"A linked connection of computers","A delivery of computing services", "A process of scheduling computer programs","A study of system uses"},1);
        Question q21 = new Question("Which of these is an advantage of cloud storage?", new String[]{"The user has no control over their data","Many programs can be run at the same time, regardless of the processing power of your device","Accessible anywhere with an internet connection","Portability"},2);
        Question q22 = new Question("Azure VMs and storage services fall under which of the following cloud computing models?", new String[]{"IaaS","PaaS","SaaS","All of the above"},0);
        Question q23 = new Question("What does \"SQL\" stand for?", new String[]{"Structured Question Language","Structured Query Language","Simple Query Language","Simple Question Language"},1);
        Question q24 = new Question("To remove a record from a table which SQL statement would you use?", new String[]{"Remove","Cancel","Eradicate","Delete"},3);

        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);
        questions.add(q6);
        questions.add(q7);
        questions.add(q8);
        questions.add(q9);
        questions.add(q10);
        questions.add(q11);
        questions.add(q12);
        questions.add(q13);
        questions.add(q14);
        questions.add(q15);
        questions.add(q16);
        questions.add(q17);
        questions.add(q18);
        questions.add(q19);
        questions.add(q20);
        questions.add(q21);
        questions.add(q22);
        questions.add(q23);
        questions.add(q24);

        return questions;
       }
}
