
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class Gui extends JFrame {

    public Gui(int rows, int columns) {
        super("TicTacToe");//title for jframe
        JPanel p = new JPanel();//create panel
        jbutton j[][] = new jbutton[rows][columns];//create buttons
        setSize(rows * 100, columns * 100);//size of frmae

        setResizable(false);//canot be resizable

        setDefaultCloseOperation(EXIT_ON_CLOSE);//exit on close
        p.setLayout(new GridLayout(rows, columns));//creating two d. array of buttons
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {
                j[i][k] = new jbutton(i, k);
                j[i][k].setIcon(null);
                j[i][k].setEnabled(true);
                p.add(j[i][k]);//add buttons to panel
            }
        }
        add(p);//add panel to frame

        setVisible(true);//make it visible

    }
}
