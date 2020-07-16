
import javax.swing.JOptionPane;

public class Main {

    static boolean Exit = false;
    static boolean newGame = false;
    static boolean GameOn = true;
    static boolean restart = false;
    static boolean on = true;
    static int rows;
    static int columns;

    public static boolean check(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        while (GameOn) {//loop to make game on always
            String rowsinput = JOptionPane.showInputDialog(null, "Enter Number Of Rows (3-20)");//take input from user for no of rows
            if (rowsinput == null || rowsinput.equals("")) {
                return;//validate this no. or not
            }
            if (Main.check(rowsinput))//if it is valid
            {
                rows = Integer.parseInt(rowsinput);
            }//converte string to integer

            while (rows > 20 || rows < 3 || !Main.check(rowsinput)) {//if not loop again until enter the right input for rows
                rowsinput = JOptionPane.showInputDialog(null, "Invalid Input \nEnter Number Of Rows again (3-20)");
                if (rowsinput == null || rowsinput.equals("")) {
                    return;
                }
                if (Main.check(rowsinput)) {
                    rows = Integer.parseInt(rowsinput);
                }
            }
            String columnsinput = JOptionPane.showInputDialog(null, "Enter Number Of Columns (3-20)");//take input from user for no of columns
            if (columnsinput == null || columnsinput.equals("")) {
                return;//validate this no. or not
            }
            if (Main.check(columnsinput))//if it is valid
            {
                columns = Integer.parseInt(columnsinput);
            }
            while (columns > 20 || columns < 3 || !Main.check(columnsinput)) {//if not loop again until enter the right input for columns
                columnsinput = JOptionPane.showInputDialog(null, "Invalid Input \nEnter Number Of Columns again (3-20)");
                if (columnsinput == null || columnsinput.equals("")) {
                    return;
                }
                if (Main.check(columnsinput)) {
                    columns = Integer.parseInt(columnsinput);
                }
            }
            TicTacToe TicTac = new TicTacToe(rows, columns);//creat instance from TicTacToe to get rows and columns

            Gui gui = new Gui(rows, columns);//creat instance from Gui to get rows and columns

            GameOn = false;//boolen is false to stop loop until some intrubt of winning or draw

            while (true) {//loop waiting any intruption if someone win or draw

                gui.setLocationRelativeTo(null);

                if (Exit) {//if it's the end and click exit that boolean will be true an close game

                    gui.dispose();//close game 

                    break;
                } else if (newGame) {//if it new game will restart variables in all over calsses and begin the game from begining
                    gui.dispose();
                    GameOn = true;
                    Exit = false;
                    newGame = false;

                    TicTacToe.reset();//reset variables in that class
                    break;

                } else if (restart) {//if it true it will restart the game with same no. of rows and columns

                    while (restart) {//loop untill he choos new game or exit
                        gui.setLocationRelativeTo(null);
                        if (on) {//make game on untill he restart it or click new game or exit
                            on = false;
                            gui.dispose();

                            TicTacToe.reset();
                            TicTac = new TicTacToe(rows, columns);
                            gui = new Gui(rows, columns);

                            gui.setLocationRelativeTo(null);

                        }

                    }

                }

            }
        }

    }
}
