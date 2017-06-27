package ipd;

import solution.Board;
import solution.Official;

/**
 * Class for printing Boards to the standard output stream.
 */
final public class Printer {
    private Board board;
    private SquarePrinter content;

    private interface SquarePrinter {
        void printTopRow(Board board, int x, int y);
        void printBottomRow(Board board, int x, int y);
    }

    private Printer(Board board) {
        this.board = board;



        this.content = new DefaultSquarePrinter();
    }

    private Printer(Board board, SquarePrinter content)  {
        this.board = board;
        this.content = content;
    }

    /**
     * Print a board to the standard output.
     * @param board The board to be printed.
     */
    public static void print(Board board) {
        Printer printer = new Printer(board);
        printer.printBoard();
    }

    /**
     * Print a board to the standard output. Print numbers indicating distances
     * to the specified official on the board.
     * @param board The board to be printed.
     * @param official The official for which distances will be printed.
     */
    public static void printWithDistances(Board board, Official official) {
        Printer printer = new Printer(board, new ShortestPathSquarePrinter(official));
        printer.printBoard();
    }

    private void printBoard() {
        System.out.println();

        // need to print out the board, should we query it, or not?
        System.out.print("---");
        printHorizontalWalls(board.getHeight() - 1, true);

        for (int y = 0; y != board.getHeight(); ++y) {
            int flipped = board.getHeight() - y - 1;

            printLeftLabel(flipped);

            printTopOfRow(flipped);
            System.out.println();

            System.out.print("   ");
            printBottomOfRow(flipped);
            System.out.println();

            System.out.print("---");
            printHorizontalWalls(flipped, false);
        }

        System.out.print("y\\x");
        printTopLabel();
    }

    private static String padToThree(int number) {
        return String.format("%3s", new Integer(number).toString());
    }

    private void printTopLabel() {
        System.out.print('|');
        for (int x = 0; x != board.getWidth(); ++x) {
            System.out.print(padToThree(x) + "|");
        }
        System.out.println();
    }

    private void printLeftLabel(int x) {
        System.out.print(padToThree(x));
    }

    private void printHorizontalWalls(int y, boolean north) {
        System.out.print('+');
        for (int x = 0; x != board.getWidth(); ++x) {
            boolean print = north ? board.hasWallNorth(x, y) : board.hasWallSouth(x, y);

            if (print) {
                System.out.print("---");
            } else {
                System.out.print("   ");
            }

            System.out.print('+');
        }
        System.out.println();
    }

    private static String colorToChar(Official.Color color) {
        switch (color) {
            case Red:
                return " R ";
            case Green:
                return " G ";
            case Yellow:
                return " Y ";
            case Blue:
                return " B ";
            case Black:
                return " S ";
            default:
                return " ? ";
        }
    }

    private void printTopOfRow(int y) {
        if (board.hasWallWest(0, y)) {
            System.out.print('|');
        } else {
            System.out.print(' ');
        }

        for (int x = 0; x != board.getWidth(); ++x) {
            content.printTopRow(board, x, y);

            if (board.hasWallEast(x, y)) {
                System.out.print('|');
            } else {
                System.out.print(' ');
            }
        }
    }

    private void printBottomOfRow(int y) {
        if (board.hasWallWest(0, y)) {
            System.out.print('|');
        } else {
            System.out.print(' ');
        }

        for (int x = 0; x != board.getWidth(); ++x) {
            content.printBottomRow(board, x, y);

            if (board.hasWallEast(x, y)) {
                System.out.print('|');
            } else {
                System.out.print(' ');
            }
        }
    }

    private static class DefaultSquarePrinter implements Printer.SquarePrinter {

        @Override
        public void printTopRow(Board board, int x, int y) {
            // print this position
            Official official = board.getOfficial(x, y);
            if (official != null) {
                System.out.print(Printer.colorToChar(official.getHat()));
            } else if (board.hasBlock(x, y)) {
                System.out.print("###");
            } else {
                System.out.print("   ");
            }
        }

        @Override
        public void printBottomRow(Board board, int x, int y) {
            // print this position
            Official official = board.getOfficial(x, y);
            if (official != null) {
                System.out.print(Printer.colorToChar(official.getRobe()));
            } else if (board.hasBlock(x, y)) {
                System.out.print("###");
            } else {
                System.out.print("   ");
            }
        }
    }

    private static class ShortestPathSquarePrinter extends Printer.DefaultSquarePrinter {

        private Official official;

        ShortestPathSquarePrinter(Official official) {
            this.official = official;
        }

        @Override
        public void printBottomRow(Board board, int x, int y) {
            int dist = board.getDistance(official, x, y);
            if (dist == Integer.MAX_VALUE || dist == 0) {
                super.printBottomRow(board, x, y);
            } else {
                System.out.print(Printer.padToThree(dist));
            }
        }
    }
}
