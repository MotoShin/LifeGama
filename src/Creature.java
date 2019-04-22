public class Creature {
    private boolean life_flag;
    private boolean padding_flag;
    private int test_num;

    public Creature(boolean life_flag, boolean padding_flag) {
        this.life_flag = life_flag;
        this.padding_flag = padding_flag;
    }

    public Creature(int test_num) {
        this.test_num = test_num;
    }

    public boolean isLife_flag() {
        return life_flag;
    }

    public void setLife_flag(boolean life_flag) {
        this.life_flag = life_flag;
    }

    public boolean isPadding_flag() {
        return padding_flag;
    }

    public void setPadding_flag(boolean padding_flag) {
        this.padding_flag = padding_flag;
    }

    public void printSelf() {
        if (this.life_flag) {
            System.out.print("@");
        } else {
            System.out.print(" ");
        }
    }

    public void testPrintSelf() {
        System.out.print(this.test_num);
    }
}
