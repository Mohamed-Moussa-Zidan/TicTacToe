
public class TicTacToe {

    public static int rows, columns;
    public static int turnCounter = 0; //number of turns played
    public static int clickCounter = 0; //number of clicks
    private static int[][] gameboard; // game matrix
    private static int[][][] Indexes; //table of indexes
    private static int xOrO = 0; // 0 for x , 1 for o

    public TicTacToe(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        gameboard = new int[rows][columns];
        Indexes = new int[2][((rows * columns) / 2) + 1][2]; // Index[x/o][number of index][row/column]
    } //constructor

    public static void setValue(int row, int column) {
        xOrO = clickCounter % 2;
        turnCounter = clickCounter / 2;
        int value;
        if (gameboard[row][column] == 0) {
            if (xOrO == 0) {
                value = 1; // indicates x
            } else {
                value = 2; //indicates o
            }
            gameboard[row][column] = value;
            Indexes[xOrO][turnCounter][0] = row; //storing the row
            Indexes[xOrO][turnCounter][1] = column; //storing column

        }
    }

    public static boolean borderChecker(int selectedrow, int selectedcolumn) {
        if (selectedrow < rows && selectedrow >= 0 && selectedcolumn >= 0 && selectedcolumn < columns) {
            return true;
        } else {
            return false;
        }

    } // to check if entered index is not out of boundaries in case of console usage

    public void showMatrix() {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                System.out.print(gameboard[row][column] + " ");
            }

            System.out.println();
        }
    } // to print matrix in case of console usage

    public static boolean straightCheck() {
        for (int counter = 0; counter <= turnCounter; counter++) { //iterating for the stored indexes in Indexes 3D-array
            int row = Indexes[xOrO][counter][0]; //getting stored row
            int column = Indexes[xOrO][counter][1]; //getting stored column
            if (column < columns - 2) { //avoid checking the extremes of matrix
                if ((gameboard[row][column] == gameboard[row][column + 1]) && (gameboard[row][column + 1] == gameboard[row][column + 2])) {
                    return true;
                }

            } //horizontal check
            if (row < rows - 2) {
                if ((gameboard[row][column] == gameboard[row + 1][column]) && (gameboard[row + 1][column] == gameboard[row + 2][column])) {
                    return true;
                }

            } //vertical check
        }
        return false;
    }

    public static boolean diagonalCheck() {
        for (int counter = 0; counter <= turnCounter; counter++) {
            int row = Indexes[xOrO][counter][0];
            int column = Indexes[xOrO][counter][1];
            if (row < rows - 2 && column < columns - 2) {
                if ((gameboard[row][column] == gameboard[row + 1][column + 1]) && (gameboard[row + 2][column + 2] == gameboard[row + 1][column + 1])) {
                    return true;
                }
            } // "\"
            if (row < rows - 2 && column > 1) {
                if ((gameboard[row][column] == gameboard[row + 1][column - 1]) && (gameboard[row + 1][column - 1] == gameboard[row + 2][column - 2])) {
                    return true;
                }
            } // "/"
        }
        return false;

    }

    public static void reset() { //re-constructor
        turnCounter = 0;
        clickCounter = 0;
        gameboard = new int[rows][columns];
        Indexes = new int[2][((rows * columns) / 2) + 1][2];
        xOrO = 0;
    }

    public static boolean draw() { //checks for draw
        if ((rows * columns) == clickCounter + 1) {
            return true;
        } else {
            return false;
        }

    }
}
