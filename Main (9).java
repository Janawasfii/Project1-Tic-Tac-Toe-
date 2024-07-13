import java.util.Random;
import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {

                Scanner scan = new Scanner(System.in);

                char[][] Board = {{'1', '2', '3'},
                        {'4', '5', '6'},
                        {'7', '8', '9'}};

                displayBoard(Board);

                while (true) {
                    playerTurn(Board, scan);
                    if (isGameFinish(Board)){
                        break;
                    }
                    displayBoard(Board);

                    compTurn(Board);
                    if (isGameFinish(Board)){
                        break;
                    }
                    displayBoard(Board);
                }
                scan.close();
            }


            public static boolean isGameFinish(char[][] Board) {

                if (hasContWon(Board, 'X')) {
                    displayBoard(Board);
                    System.out.println("Player wins!");
                    return true;
                }

                if (hasContWon(Board, 'O')) {
                    displayBoard(Board);
                    System.out.println("Computer wins!");
                    return true;
                }

                for (int i = 0; i < Board.length; i++) {
                    for (int j = 0; j < Board[i].length; j++) {
                        if (Board[i][j] == ' ') {
                            return false;
                        }
                    }
                }
                displayBoard(Board);
                System.out.println("The game ended in a tie!");
                return true;
            }


            public static boolean hasContWon(char[][] Board, char sym) {
                if ((Board[0][0] == sym && Board [0][1] == sym && Board [0][2] == sym) ||
                        (Board[1][0] == sym && Board [1][1] == sym && Board [1][2] == sym) ||
                        (Board[2][0] == sym && Board [2][1] == sym && Board [2][2] == sym) ||

                        (Board[0][0] == sym && Board [1][0] == sym && Board [2][0] == sym) ||
                        (Board[0][1] == sym && Board [1][1] == sym && Board [2][1] == sym) ||
                        (Board[0][2] == sym && Board [1][2] == sym && Board [2][2] == sym) ||

                        (Board[0][0] == sym && Board [1][1] == sym && Board [2][2] == sym) ||
                        (Board[0][2] == sym && Board [1][1] == sym && Board [2][0] == sym) ) {
                    return true;
                }
                return false;
            }


            public static void compTurn(char[][] Board) {
                Random rand = new Random();
                int compMove;
                while (true) {
                    compMove = rand.nextInt(9) + 1;
                    if (isValid(Board, Integer.toString(compMove))) {
                        break;
                    }
                }
                System.out.println("Computer choose number:" + compMove);
                place(Board, Integer.toString(compMove), 'O');
            }


            public static boolean isValid(char[][] Board, String position) {
                switch(position) {
                    case "1":
                        return (Board[0][0] == ' ');
                    case "2":
                        return (Board[0][1] == ' ');
                    case "3":
                        return (Board[0][2] == ' ');
                    case "4":
                        return (Board[1][0] == ' ');
                    case "5":
                        return (Board[1][1] == ' ');
                    case "6":
                        return (Board[1][2] == ' ');
                    case "7":
                        return (Board[2][0] == ' ');
                    case "8":
                        return (Board[2][1] == ' ');
                    case "9":
                        return (Board[2][2] == ' ');
                    default:
                        throw new IllegalArgumentException("Invalid position: " + position);
                }
            }

            public static void playerTurn(char[][] Board, Scanner scan) throws Exception {
                String playerInput = "";
                while (true) {
                    System.out.println("Where would you like to play? (1-9)");
                    try{
                        playerInput = scan.nextLine();
                        if (isValid(Board, playerInput)){
                            break;
                        } else {
                            System.out.println(playerInput + " is not a valid move.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid");}
                    catch(Exception e){
                        System.out.printf(e.getMessage());
                    }


                    place(Board, playerInput, 'X');
                }}


                public static void place(char[][] Board, String position, char sym) {
                    switch(position) {
                        case "1":
                            Board[0][0] = sym;
                            break;
                        case "2":
                            Board[0][1] = sym;
                            break;
                        case "3":
                            Board[0][2] = sym;
                            break;
                        case "4":
                            Board[1][0] = sym;
                            break;
                        case "5":
                            Board[1][1] = sym;
                            break;
                        case "6":
                            Board[1][2] = sym;
                            break;
                        case "7":
                            Board[2][0] = sym;
                            break;
                        case "8":
                            Board[2][1] = sym;
                            break;
                        case "9":
                            Board[2][2] = sym;
                            break;
                        default:
                            System.out.println();
                    }
                }

                public static void displayBoard(char[][] Board) {
                    System.out.println("***************");
                    for (int i = 0; i < Board.length; i++) {
                        System.out.print(" | ");
                        for (int j = 0; j < Board[i].length; j++) {
                            System.out.print(Board[i][j] + " | ");
                        }
                        System.out.println();
                        System.out.println("***************");
                    }
                }
            }

