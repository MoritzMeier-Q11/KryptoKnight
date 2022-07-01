import java.util.ArrayList;

public class SNAKE {
    int x, y, dir;
    boolean alive;
    ArrayList<int[]> coods;
    public SNAKE(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        coods = new ArrayList<>(64*36);
        coods.add(new int[]{x, y});
        alive = true;
    }
    public void move() {
        if(coods!=null) {
            for (int i = coods.size()-1; i > 0; i--) {
                coods.get(i)[0] = coods.get(i-1)[0];
                coods.get(i)[1] = coods.get(i-1)[1];
            }
            switch (dir) {
                case 0 -> {
                    if (coods.get(0)[1] > 0) {
                        coods.get(0)[1]--;
                    } else {
                        coods.get(0)[1] = 35;
                    }
                }
                case 1 -> {
                    if (coods.get(0)[0] < 63) {
                        coods.get(0)[0]++;
                    } else {
                        coods.get(0)[0] = 0;
                    }
                }
                case 2 -> {
                    if (coods.get(0)[1] < 35) {
                        coods.get(0)[1]++;
                    } else {
                        coods.get(0)[1] = 0;
                    }
                }
                case 3 -> {
                    if (coods.get(0)[0] > 0) {
                        coods.get(0)[0]--;
                    } else {
                        coods.get(0)[0] = 63;
                    }
                }

            }
            int facing = SNAKEGAME.matrix[coods.get(0)[0]][coods.get(0)[1]];
            if(facing != -1) {
                if(facing == 100) {
                    addTale();
                    if(SNAKEGAME.apples.size() <= 5) {
                        SNAKEGAME.SpawnApple();
                    }
                    SNAKEGAME.apples.removeIf(a -> a.x == coods.get(0)[0] && a.y == coods.get(0)[1]);
                } else {
                    alive = false;
                    SNAKEGAME.playerCount--;
                    for(int[] c : coods) {
                        APPLE a = new APPLE(c[0], c[1]);
                        SNAKEGAME.apples.add(a);
                    }
                    coods = null;
                }
            }
        }
    }
    public void addTale() {
        coods.add(new int[]{coods.get(coods.size()-1)[0], coods.get(coods.size()-1)[1]});
    }
}
