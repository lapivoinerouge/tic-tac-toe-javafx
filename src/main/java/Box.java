public class Box {

    private char token;
    private int position;

    public Box(char token, int position) {
        this.token = token;
        this.position = position;
    }

    public char getToken() {
        return token;
    }

    public int getPosition() {
        return position;
    }
}
