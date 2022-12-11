public class Logic {
    private static final int[] NORTH = {-1,0};
    private static final int[] SOUTH = {1,0};
    private static final int[] EAST = {0,1};
    private static final int[] WEST = {0,-1};
    private static final int[] NORTHEAST = {-1,1};
    private static final int[] NORTHWEST = {-1,-1};
    private static final int[] SOUTHEAST = {1,1};
    private static final int[] SOUTHWEST = {1,-1};

    private static boolean running = true;
    public static int[][] board;
    public Logic(){
        board = new int[Main.BOARD_SIZE][Main.BOARD_SIZE];
    }
    public static boolean inWinningPosition(int row, int col){
        boolean win = false;
        int[] count = new int[4];
        if(pieceCount(NORTH, row, col) + pieceCount(SOUTH, row, col) + 1 >= 5) win = true;
        if(pieceCount(EAST, row, col) + pieceCount(WEST, row, col) + 1 >= 5) win = true;
        if(pieceCount(NORTHEAST, row, col) + pieceCount(SOUTHWEST, row, col) + 1 >= 5) win = true;
        if(pieceCount(NORTHWEST, row, col) + pieceCount(SOUTHEAST, row, col) + 1 >= 5) win = true;
        return win;

    }

    private static int pieceCount(int[] direction, int row, int col) {
        int count = 0;
        while(true){
            if(row + direction[0] >= 0 && col + direction[1] >= 0 && row + direction[0] < Main.BOARD_SIZE && col + direction[1] < Main.BOARD_SIZE){
                row += direction[0];
                col += direction[1];
            }
            else break;

            if(board[row][col] == Main.turnPlayer)
                count++;
            else break;
        }
        return count;
    }
}
