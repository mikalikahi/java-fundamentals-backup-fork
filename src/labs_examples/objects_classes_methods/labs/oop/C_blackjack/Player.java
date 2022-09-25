package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    String name;
    Hand hand = new Hand();

    int potValue = 1000; //(the

    int bet;

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public Player(int bet) {
        this.bet = bet;
    }


    public void dealAdditionalCards(Deck deck, boolean human) {

        if (human) {
            do {
                System.out.println("Do you want another card?");

                Scanner scanner = new Scanner(System.in);
                String anotherCard = scanner.next();
                if (anotherCard.equalsIgnoreCase("y")) {
                    System.out.println("Yes");
                    deck.dealCard(this);
                    getHand().print();
                    System.out.println("You now have: " + getHand().handScore());
                } else if (anotherCard.equalsIgnoreCase("n")) {
                    System.out.println("You decided to stay");
                    break;
                }
            } while (getHand().handScore() <= 20);
        } else {
            if (getHand().handScore() >= 17) {
                System.out.println("These are the AI's cards: ");
                getHand().print();
                System.out.println("\nThe AI has: " + getHand().handScore());
            }
            while (getHand().handScore() <= 16) {
                System.out.println("The AI is taking another card");
                deck.dealCard(this);
                System.out.println("These are the AI's cards: ");
                getHand().print();
                System.out.println("\nThe AI has: " + getHand().handScore());
            }
        }
    }

    public void placeBet() {
        try{Scanner scanner = new Scanner(System.in);
            System.out.println("Place a bet ....");
            System.out.println("\nYou have $" + potValue + " to bet");
            int playerBet = scanner.nextInt();


            if(playerBet <= potValue && playerBet > 0){
                setBet(playerBet);
            }else {
                do{
                    System.out.println(
                            "You only have: $" + potValue + ". That was too much! Bet again");
                    playerBet = scanner.nextInt();
                }while(playerBet > potValue);

                setBet(playerBet);}

        }  catch(InputMismatchException exc){
            System.out.println("You can only input numbers");
            placeBet();
        }
    }

    public boolean computerAI() {

        hand.handScore();
        if (hand.handScore() <= 16) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                ", potValue=" + potValue +
                '}';
    }

    public Player(String name, Hand hand, int potValue, int bet) {
        this.name = name;
        this.hand = hand;
        this.potValue = potValue;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getPotValue() {
        return potValue;
    }

    public void setPotValue(int potValue) {
        this.potValue = potValue;
    }

    public void adjustPot(boolean humanWin) {
        if (humanWin){
            potValue += bet;
        } else potValue -= bet;
        System.out.println("You have $" + potValue);
    }

    int playerWins;
    int computerAIWins;

    public void countWins(Player player, Player computerAI, Deck deck) {
        BlackJackController blackJackController = new BlackJackController();

        if (blackJackController.determineWinner(player, computerAI)) {
            playerWins += 1;
            System.out.println("Player: " + playerWins + " : AI: " + computerAIWins);
        } else {
            computerAIWins += 1;
            System.out.println("Number of games played: " + deck.countNewGame);
            System.out.println("Player - " + playerWins + " : Computer - " + computerAIWins);
        }
    }
}
