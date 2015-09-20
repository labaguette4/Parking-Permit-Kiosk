import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.LinkedList;


public class KeyBoard extends JFrame {

    private JFrame frame = new JFrame("KeyBoard");
    private JPanel parent = new JPanel(new GridLayout(0, 1));
    private JPanel[] panel;
    private JButton[][] button;
    LinkedList<String> myinfo = new LinkedList<String>(); 
    private static final String[][] key = {
        {"A", "B", "C", "D", "E","F","G","H","I"},
        {"J", "K", "L", "N", "M","O","P","Q","R"}, 
        {"S", "T", "U","V","W","X","Y","Z"},
            {"0","1", "2", "3", "4","5","6","7","8","9"},
           {"@","@yorku.ca","@gmail.com","@yahoo.com"},
        {"Enter", "                                 ","Delete"}
           };

    public KeyBoard() {
        super("KeyBoard");
        panel = new JPanel[6];
        for (int row = 0; row < key.length; row++) {
            panel[row] = new JPanel();
            button = new JButton[10][10];
            for (int column = 0; column < key[row].length; column++) {
                button[row][column] = new JButton(key[row][column]);
                button[row][column].putClientProperty("column", column);
                button[row][column].putClientProperty("row", row);
                button[row][column].putClientProperty("key", key[row][column]);
                button[row][column].addActionListener(new MyActionListener());
                panel[row].add(button[row][column]);
            }
            parent.add(panel[row]);
        }
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(parent);
        pack();
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            System.out.println("clicked column --> " + btn.getClientProperty("column")
                    + ", row --> " + btn.getClientProperty("row")
                    + ", Key Typed --> " + btn.getClientProperty("key"));
            String info = (String) btn.getClientProperty("key");
            myinfo.add(info);
            System.out.println(myinfo);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                KeyBoard guI = new KeyBoard();
            }
        });
    }
}
