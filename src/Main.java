import java.util.Random;
import java.util.Scanner;

class Game{
    private Random rand = new Random();
    private Scanner sc = new Scanner(System.in);
    private int computer_guess;
    private int userChoice;
    private int guessInCounter;

    public Game(){
        this.setComputer_guess();
    }

    public void setComputer_guess(){
        this.computer_guess = rand.nextInt(0, 100);
    }

    public void takeUserInput(){
        System.out.print("Enter your guessed number : ");
        this.userChoice = sc.nextInt();
    }

    public int isNumberCorrect(){
        return Integer.compare(this.userChoice, this.computer_guess);
    }

    public char askReplay(){
        System.out.print("Wanna play again (y/n) : ");
        return sc.next().toLowerCase().charAt(0);
    }

    public void resetGame(){
        this.setComputer_guess();
        this.guessInCounter = 0;
    }

    public void incrementGuessInCounter(){
        this.guessInCounter += 1;
    }
    public int getGuessInCounter(){
        return this.guessInCounter;
    }
}

public class Main {
    public static void main(String[] args) {
        Game guessTheNumber = new Game();
        while (true){
            guessTheNumber.incrementGuessInCounter();
            guessTheNumber.takeUserInput();
            if (guessTheNumber.isNumberCorrect() == 0){
                System.out.println(">>>>>>> GG SWEET VICTORY <<<<<<<<");
                System.out.println("\tVery well, You won!");
                System.out.println("\tGame completed in "+guessTheNumber.getGuessInCounter()+" chances.");
                System.out.println("==================================\n");

                if (guessTheNumber.askReplay() == 'y') {
                    System.out.println("\n");
                    guessTheNumber.resetGame();
                    continue;
                }
                break;
            }
            else if (guessTheNumber.isNumberCorrect() < 0){
                System.out.println(">>> OOPS! guessed number is less then expected\n");
            }
            else{
                System.out.println(">>> OOPS! guessed number is more then expected\n");
            }
        }
    }
}
