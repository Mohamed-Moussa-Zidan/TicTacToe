
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class jbutton extends JButton implements ActionListener {

    ImageIcon x, o;//create image icon

    private int i, j;//indexs for buttons

    public jbutton(int i, int j) {
        this.i = i;
        this.j = j;
        x = new ImageIcon(this.getClass().getResource("x.png"));//take icons source
        o = new ImageIcon(this.getClass().getResource("o.png"));
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean end = false;
        if (TicTacToe.clickCounter % 2 == 0) {//counter if it even so its x player odd its o player
            TicTacToe.setValue(i, j);//pass location i,j to setValue method 

            setIcon(x);//set icon in that button for x
            setEnabled(false);//if you click on button cant be change again 

        } else {
            TicTacToe.setValue(i, j);//pass location i,j to setValue method 
            setIcon(o);//set icon in that button for o
            setEnabled(false);
        }

        if (TicTacToe.straightCheck() || TicTacToe.diagonalCheck()) {//check winner

            end = true;//tell it that game is end
            if (TicTacToe.clickCounter % 2 == 0) {//check if it x
                JOptionPane.showMessageDialog(null, "Player X wins", "Winner", JOptionPane.CLOSED_OPTION);//display winner 
            } else {//else it is o
                JOptionPane.showMessageDialog(null, "Player O wins", "Winner", JOptionPane.CLOSED_OPTION);//display winner
            }

        } else if (TicTacToe.draw()) {//check draw

            JOptionPane.showMessageDialog(null, "Draw\n No Winner", "Winner", JOptionPane.CLOSED_OPTION);//display no winner

            end = true;

        }
        if (end) {//if game is end
            Object[] possibilities = {"New Game","Restart", "Exit"};//display options 
            String s = (String) JOptionPane.showInputDialog(
                    null,
                    "Choose An Option",
                    "Game Over",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    "New Game");
            if (s == "Exit" || s == null) {//if it exit will send flag to main
                Main.Exit = true;
                Main.restart=false;
            } else if (s == "New Game") {//if it newgame will send flag to main
                Main.newGame = true;
                Main.restart=false;

            }else if(s=="Restart"){//if it restart will send flag to main
                
                Main.restart=true;
                Main.on=true;
            }
        }
        TicTacToe.clickCounter++;
    }
}
