import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Processing {
    private int row;
    private int col;
    private List<Creature> pList = new LinkedList<>();
    Random ran = new Random();

    public Processing(int row, int col) {
        this.row = row;
        this.col = col;
        makeList();
    }

    public void makeList() {
        for (int i = 0; i < row * col; i++) {
            int num = ran.nextInt(2);
            if (num == 0) {
                pList.add(new Creature(false, false));
            } else {
                pList.add(new Creature(true, false));
            }
//            list.add(new Creature(i));
        }
    }

    public List makePudding() {

        for (int i = 0; i < pList.size(); i++) {
            pList.get(i).setPadding_flag(false);
        }

        List<Creature> newList = new LinkedList<>(pList);
        int newRow = row + 2;
        int newCol = col + 2;

//        printField(this.list, row, col);
//        System.out.println();

        /* パディングの上部分 */
        newList.add(0, pList.get(toIndex(row - 1, 0)));
        newList.get(0).setPadding_flag(true);
        for (int i = 0; i < col; i++) {
            newList.add(0, pList.get(toIndex(row-1, col-1-i)));
            newList.get(0).setPadding_flag(true);
        }
        newList.add(0, pList.get(toIndex(row-1,col-1)));
        newList.get(0).setPadding_flag(true);

        /* パディングの左右部分 */
        for (int i = 0; i < row; i++) {
            newList.add(newCol*(i+1), pList.get(toIndex(i, col - 1)));
            newList.get(newCol*(i+1)).setPadding_flag(true);
            newList.add(newCol*(i+2)-1, pList.get(toIndex(i, 0)));
            newList.get(newCol*(i+2)-1).setPadding_flag(true);
        }

        /* パディングの下部分 */
        newList.add(newList.size(), pList.get(toIndex(0, col-1)));
        newList.get(newList.size()-1).setPadding_flag(true);
        for (int i = 0; i < col; i++) {
            newList.add(newList.size(), pList.get(toIndex(0, i)));
            newList.get(newList.size()-1).setPadding_flag(true);
        }
        newList.add(newList.size(), pList.get(toIndex(0, 0)));
        newList.get(newList.size()-1).setPadding_flag(true);

//        printField(newList, newRow, newCol);

        return newList;
    }

    public void check(List<Creature> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isPadding_flag()) {
                continue;
            }
            Point p0 = toPoint(i);
            boolean a_zero_flag = false;
            int alive_count = 0;
            for (int a = -1; a < 2; a++) {
                if (a == 0) {
                    a_zero_flag = true;
                }
                for (int b = -1; b < 2; b++) {
                    if (b == 0 && a_zero_flag) {
                        continue;
                    }

                    if (list.get(toIndex(p0.getR() + a, p0.getC() + b)).isLife_flag()) {
                        alive_count = alive_count + 1;
                    }
                }
            }

            if (!list.get(i).isLife_flag() && alive_count == 3) {
                list.get(i).setLife_flag(true);
            }
            if (list.get(i).isLife_flag() && alive_count <= 1) {
                list.get(i).setLife_flag(false);
            }
            if (list.get(i).isLife_flag() && alive_count >= 4) {
                list.get(i).setLife_flag(false);
            }
        }

        int pi = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isPadding_flag()) {
                continue;
            }

            if (list.get(i).isLife_flag()) {
                pList.get(pi).setLife_flag(true);
            } else {
                pList.get(pi).setLife_flag(false);
            }

            pi = pi + 1;
        }
    }

    public int toIndex(int r, int c) {
        return r*this.col+c;
    }

    public Point toPoint(int i) {
        int r = i / this.col;
        int c = i % this.col;

        Point p = new Point(r, c);

        return p;
    }

    public void printField(List<Creature> list, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int l = 0; l < c; l++) {
                list.get(i * c + l).printSelf();
//                list.get(i*c+l).testPrintSelf();
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void printFieldForConsole() {
        printField(pList, this.row, this.col);
    }

    public void play() {
        List<Creature> paddingList = new LinkedList<>();

        printFieldForConsole();
        try {
            Thread.sleep((long) 1.0 * 1000);
        } catch (InterruptedException e) {

        }
        System.out.println();

        while (true) {
            paddingList = makePudding();
            check(paddingList);

            printFieldForConsole();
            try {
                Thread.sleep((long) 1.0 * 1000);
            } catch (InterruptedException e) {

            }
            System.out.println();
        }
    }
}
