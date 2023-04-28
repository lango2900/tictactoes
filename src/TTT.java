import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class TTT implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean turn1;

    TTT(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.magenta);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(Color.magenta);
        textfield.setForeground(Color.black);
        textfield.setFont(new Font("Dialog",Font.BOLD,65));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0,0,800,100);

        button.setLayout(new GridLayout(3,3));
        button.setBackground(Color.darkGray);

        for(int i=0;i<9;i++) {
            buttons[i] = new JButton();
            button.add(buttons[i]);
            buttons[i].setFont(new Font("Dialog",Font.PLAIN,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        title.add(textfield);
        frame.add(title,BorderLayout.NORTH);
        frame.add(button);

        Turn1();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (turn1) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.red);
                        buttons[i].setText("X");
                        turn1 = false;
                        textfield.setText("O's Turn");
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.green);
                        buttons[i].setText("O");
                        turn1 = true;
                        textfield.setText("X's Turn");
                        checker();

                    }
                }
            }
        }
    }

    public void Turn1() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            turn1 = true;
            textfield.setText("X's Turn");
        } else {
            turn1=false;
            textfield.setText("O's Turn");


        }
    }
    public void checker(){

        if(     (buttons[0].getText()=="X")&&
                (buttons[1].getText()=="X")&&
                (buttons[2].getText()=="X")
        ) {
            xWinner(0,1,2);
        }
        if(     (buttons[3].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[5].getText()=="X")
        ) {
            xWinner(3,4,5);
        }
        if(     (buttons[6].getText()=="X")&&
                (buttons[7].getText()=="X")&&
                (buttons[8].getText()=="X")
        ) {
            xWinner(6,7,8);
        }
        if(     (buttons[0].getText()=="X")&&
                (buttons[3].getText()=="X")&&
                (buttons[6].getText()=="X")
        ) {
            xWinner(0,3,6);
        }
        if(     (buttons[1].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[7].getText()=="X")
        ) {
            xWinner(1,4,7);
        }
        if(     (buttons[2].getText()=="X")&&
                (buttons[5].getText()=="X")&&
                (buttons[8].getText()=="X")
        ) {
            xWinner(2,5,8);
        }
        if(     (buttons[0].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[8].getText()=="X")
        ) {
            xWinner(0,4,8);
        }
        if(     (buttons[2].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[6].getText()=="X")
        ) {
            oWinner(2,4,6);
        }
        if(     (buttons[0].getText()=="O")&&
                (buttons[1].getText()=="O")&&
                (buttons[2].getText()=="O")
        ) {
            oWinner(0,1,2);
        }
        if(     (buttons[3].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[5].getText()=="O")
        ) {
            oWinner(3,4,5);
        }
        if(     (buttons[6].getText()=="O")&&
                (buttons[7].getText()=="O")&&
                (buttons[8].getText()=="O")
        ) {
            oWinner(6,7,8);
        }
        if(     (buttons[0].getText()=="O")&&
                (buttons[3].getText()=="O")&&
                (buttons[6].getText()=="O")
        ) {
            oWinner(0,3,6);
        }
        if(     (buttons[1].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[7].getText()=="O")
        ) {
            oWinner(1,4,7);
        }
        if(     (buttons[2].getText()=="O")&&
                (buttons[5].getText()=="O")&&
                (buttons[8].getText()=="O")
        ) {
            oWinner(2,5,8);
        }
        if(     (buttons[0].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[8].getText()=="O")
        ) {
            oWinner(0,4,8);
        }
        if(     (buttons[2].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[6].getText()=="O")
        ) {
            oWinner(2,4,6);
        }

    }
    public void xWinner(int a,int b,int c){
        buttons[a].setBackground(Color.red);
        buttons[b].setBackground(Color.red);
        buttons[c].setBackground(Color.red);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X is the Winner!");


    }
    public void oWinner(int a,int b,int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O is the Winner!");

    }
}
