import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MakeWindow frame = new MakeWindow();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(10, 10, 300, 200);
        frame.setTitle("タイトル");
        frame.setVisible(true);
    }
}
