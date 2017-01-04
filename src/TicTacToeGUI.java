import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Raman on 04/01/2017.
 */
public class TicTacToeGUI extends JFrame {
    public TicTacToeGUI() {
        setTitle("Tic-Tac-Toe");
        setResizable(false);
        setBounds(300, 300, 506, 565);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel bottomPanel = new JPanel(new GridLayout());
        JButton jbNewGame = new JButton("Start New Game");
        JButton jbExitGame = new JButton("Exit Game");
        jbExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("BYE");
            }
        });

        bottomPanel.add(jbNewGame);
        bottomPanel.add(jbExitGame);
        bottomPanel.setPreferredSize(new Dimension(1, 40));
        add(bottomPanel, BorderLayout.SOUTH);

        TicTacToeGameMap gamePanel = new TicTacToeGameMap();
        add(gamePanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
