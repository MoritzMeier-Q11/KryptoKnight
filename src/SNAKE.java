public class SNAKE {
    int x, y, dir;
    public SNAKE(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public void ChangeDir(int dir) {
        this.dir = dir;
    }
}
