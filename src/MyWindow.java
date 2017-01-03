import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Raman on 03/01/2017.
 */
public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Tic-Tac-Toe");
        setBounds(400, 300, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton jb1 = new JButton("Hello #1");
        JButton jb2 = new JButton("Hello #2");
        JButton jb3 = new JButton("Hello #3");
        JButton jb4 = new JButton("Hello #4");

        setLayout(new BorderLayout());
        JPanel jpBottom = new JPanel(new GridLayout());
//        setLayout(null);        //Нет автоматической расстановки элементов
//        setLayout(new GridBagLayout());
        add(jpBottom, BorderLayout.SOUTH);
        jpBottom.add(jb1);      //Расстановка элементов
        jpBottom.add(jb2);
        jpBottom.add(jb3);
        jpBottom.add(jb4);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("#1");
            }
        });

//        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//        add(jb1);      //Расстановка элементов
//        add(jb2);
//        add(jb3);
//        add(jb4);

//        setLayout(new GridLayout(2, 2));
//        add(jb1);      //Расстановка элементов
//        add(jb2);
//        add(jb3);
//        add(jb4);

//        setLayout(new FlowLayout());
//        add(jb1);      //Расстановка элементов
//        add(jb2);
//        add(jb3);
//        add(jb4);

//        add(jb1, BorderLayout.CENTER);      //Расстановка элементов
//        add(jb2, BorderLayout.NORTH);
//        add(jb3, BorderLayout.SOUTH);
//        add(jb4, BorderLayout.WEST);

//        jb4.setPreferredSize(new Dimension(200, 100));    //Устанавливаем размер кнопки

        setVisible(true);
    }
}
