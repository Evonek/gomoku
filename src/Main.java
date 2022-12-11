public class Main {
    public static final int BOARD_SIZE = 15;
    public static final int WIDTH = 900;
    public static final int HEIGHT = 900;
    public static int turnPlayer = 1;
    public Main(){
        new GUI("Gomoku", WIDTH, HEIGHT);
        new Logic();
    }
    public static void main(String[] args) {
        new Main();
    }
}
