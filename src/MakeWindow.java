import javax.swing.*;
import java.awt.*;

public class MakeWindow extends JFrame {
    public MakeWindow() {
        GridBagLayout layout = new GridBagLayout();
        JPanel p = new JPanel();
        p.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();

        JButton button1 = new JButton("Google");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 1.0d;
        gbc.weighty = 1.0d;
        gbc.fill = GridBagConstraints.VERTICAL;
        layout.setConstraints(button1, gbc);

        JButton button2 = new JButton("Yahoo!");
        button2.setFont(new Font("Arial", Font.PLAIN, 30));

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.weightx = 1.0d;
        gbc.weighty = 1.0d;
        gbc.fill = GridBagConstraints.BOTH;
        layout.setConstraints(button2, gbc);

        JButton button3 = new JButton("MSM");

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0d;
        gbc.weighty = 1.0d;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        layout.setConstraints(button3, gbc);

        p.add(button1);
        p.add(button2);
        p.add(button3);

        getContentPane().add(p, BorderLayout.CENTER);
    }
}
