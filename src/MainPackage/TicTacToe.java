/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author mohda
 */
public class TicTacToe implements ActionListener{
    Random random= new Random();
    JFrame frame = new JFrame("TicTacToe");
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];

    boolean player1_turn;
    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel,BorderLayout.NORTH);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free", Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        title_panel.add(textfield);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));
        

        for(int i=0;i<9;i++){
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn(); // to start the game
    }
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){ // if we click on any button
                if(player1_turn==true){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O turn");
                        check();// for winning condition
                    }
                }else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
        draw();
    }
    public void firstTurn(){
        try{
            textfield.setText("Loading....");
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X Turn");
        }else{
            player1_turn=false;
            textfield.setText(("O Turn"));
        }
    }
    public void gameOver(String s){
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(n==0){
            frame.dispose();
            new TicTacToe();
        }
        else{
            frame.dispose();
        }
    }
    public void check(){
        // conditions for X win
        if(buttons[0].getText()=="X" &&buttons[1].getText()=="X" && buttons[2].getText()=="X"){
            xwin(0,1,2);
        }
        if(buttons[3].getText()=="X" &&buttons[4].getText()=="X" && buttons[5].getText()=="X"){
            xwin(3,4,5);
        }
        if(buttons[6].getText()=="X" &&buttons[7].getText()=="X" && buttons[8].getText()=="X"){
            xwin(6,7,8);
        }
        if(buttons[0].getText()=="X" &&buttons[3].getText()=="X" && buttons[6].getText()=="X"){
            xwin(0,3,6);
        }
        if(buttons[1].getText()=="X" &&buttons[4].getText()=="X" && buttons[7].getText()=="X"){
            xwin(1,4,7);
        }
        if(buttons[2].getText()=="X" &&buttons[5].getText()=="X" && buttons[8].getText()=="X"){
            xwin(2,5,8);
        }
        if(buttons[0].getText()=="X" &&buttons[4].getText()=="X" && buttons[8].getText()=="X"){
            xwin(0,4,8);
        }
        if(buttons[2].getText()=="X" &&buttons[4].getText()=="X" && buttons[6].getText()=="X"){
            xwin(2,4,6);
        }
        //Check o wins
        if(buttons[0].getText()=="O" &&buttons[1].getText()=="O" && buttons[2].getText()=="O"){
            owin(0,1,2);
        }
        if(buttons[3].getText()=="O" &&buttons[4].getText()=="O" && buttons[5].getText()=="O"){
            owin(3,4,5);
        }
        if(buttons[6].getText()=="O" &&buttons[7].getText()=="O" && buttons[8].getText()=="O"){
            owin(6,7,8);
        }
        if(buttons[0].getText()=="O" &&buttons[3].getText()=="O" && buttons[6].getText()=="O"){
            owin(0,3,6);
        }
        if(buttons[1].getText()=="O" &&buttons[4].getText()=="O" && buttons[7].getText()=="O"){
            owin(1,4,7);
        }
        if(buttons[2].getText()=="O" &&buttons[5].getText()=="O" && buttons[8].getText()=="O"){
            owin(2,5,8);
        }
        if(buttons[0].getText()=="O" &&buttons[4].getText()=="O" && buttons[8].getText()=="O"){
            owin(0,4,8);
        }
        if(buttons[2].getText()=="O" &&buttons[4].getText()=="O" && buttons[6].getText()=="O"){
            owin(2,4,6);
        }
    }
    public void xwin(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        textfield.setText("X is the winner");
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        gameOver("X is the winner");
    }
    public void owin(int a,int b,int c){
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);
        textfield.setText("O is the winner");
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        gameOver("O is the winner");
    }
    public void draw(){
        int count=0;
        for(int i=0;i<9;i++){
        if(buttons[i].getText()!="")
        count++;
        if(count==9){
            textfield.setText("Match is draw");
            gameOver("Match is draw");
        for(int j=0;j<9;j++){
            buttons[j].setEnabled(false);
            }
        }
    }
  }
}
