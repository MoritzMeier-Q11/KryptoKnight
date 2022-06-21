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
    public void move() {
        switch (dir) {
            case 0 -> {
                if (y > 0) {
                    y--;
                } else {
                    y = 35;
                }
            }
            case 1 -> {
                if (x < 63) {
                    x++;
                } else {
                    x = 0;
                }
            }
            case 2 -> {
                if (y < 35) {
                    y++;
                } else {
                    y = 0;
                }
            }
            case 3 -> {
                if (x > 0) {
                    x--;
                } else {
                    x = 63;
                }
            }
        }
    }
}
