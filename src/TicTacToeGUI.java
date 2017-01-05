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
        TicTacToeGameMap gamePanel = new TicTacToeGameMap();

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

        JPanel jpStartOrExit = new JPanel(new GridLayout());
        jpStartOrExit.add(jbNewGame);
        jpStartOrExit.add(jbExitGame);
        JPanel jpOpponents = new JPanel(new GridLayout());
        JButton jbHumanVsHuman = new JButton("Human vs. Human");
        JButton jbHumanVsAI = new JButton("Human vs. AI");
        jpOpponents.add(jbHumanVsHuman);
        jpOpponents.add(jbHumanVsAI);

        jbHumanVsHuman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.setOpponents("H-H");
            }
        });

        jbHumanVsAI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.setOpponents("H-AI");
            }
        });

        bottomPanel.setLayout(new CardLayout());
        bottomPanel.add(jpStartOrExit, "jpStartOrExit");
        bottomPanel.add(jpOpponents, "jpOpponents");

//        bottomPanel.setPreferredSize(new Dimension(1, 40));

        ((CardLayout) bottomPanel.getLayout()).show(bottomPanel, "jpStartOrExit");

        jbNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout) bottomPanel.getLayout()).show(bottomPanel, "jpOpponents");
            }
        });

        add(gamePanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
