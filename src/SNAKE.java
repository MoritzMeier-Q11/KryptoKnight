import java.util.ArrayList;

public class SNAKE {
    int x, y, dir;
    ArrayList<int[]> coods;
    public SNAKE(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        coods = new ArrayList<>(64*36);
        coods.add(new int[]{x, y});
    }
    public void ChangeDir(int dir) {
        this.dir = dir;
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
            if(SNAKEGAME.matrix[coods.get(0)[0]][coods.get(0)[1]] != -1) {
                coods = null;
            }
        }
    }
    public void addTale() {
        coods.add(new int[]{coods.get(coods.size()-1)[0], coods.get(coods.size()-1)[1]});
    }

}
