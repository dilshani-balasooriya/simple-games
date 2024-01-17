/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.*;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.text.StyleConstants.Bold;
/**
 *
 * @author Dilshani
 */
public class TicTacToe implements ActionListener{
    Random random =new Random();
        JFrame frame=new JFrame();
        JPanel tittle_panel= new JPanel();
        JPanel button_panel= new JPanel();
        JButton restartButton = new JButton("Restart");
        JLabel textfield= new JLabel();
        JButton[] button =new JButton[9];
        boolean Player1_turn;
        
    
    TicTacToe(){
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
       textfield.setBackground(new  Color (25,25,25));
       textfield.setForeground(new Color(25,255,0));
       textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
       textfield.setHorizontalAlignment(JLabel.CENTER);
       textfield.setText("Tic Tac Toe");
       textfield.setOpaque(true);
       
       tittle_panel.setLayout(new BorderLayout());
       tittle_panel.setBounds(0,0,700,100);
       
        button_panel.setLayout(new GridLayout(3,3));
       button_panel.setBackground(new Color(150,150,150));

        for(int i=0; i<9;i++){
           button[i]=new JButton();
           button_panel.add(button[i]);
           button[i].setFont(new Font("MY Boli",Font.BOLD,120));
           button[i].setFocusable(false);
           button[i].addActionListener(this);
}
       
       tittle_panel.add( textfield);
       frame.add(tittle_panel,BorderLayout.NORTH);
       frame.add(button_panel);

    
      
      restartButton.setFont(new Font("Ink Free", Font.BOLD, 30));
        restartButton.setFocusable(false);
        restartButton.addActionListener(this);

        tittle_panel.add(restartButton, BorderLayout.EAST);

          firstTurn();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < 9; i++) {
         if (e.getSource() == restartButton) {
            restartGame();
        } else if (e.getSource() == button[i]) {
            if (Player1_turn) {
                if (button[i].getText().equals("")) {
                    button[i].setForeground(new Color(255, 0, 0));
                    button[i].setText("X");
                    Player1_turn = false;
                    textfield.setText("O turn");
                }
            } else {
                if (button[i].getText().equals("")) {
                    button[i].setForeground(new Color(0, 0, 255));
                    button[i].setText("O");
                    Player1_turn = true;
                    textfield.setText("X turn");
                    check();
                }
            }
        }
    }
}

            
    
public void firstTurn(){
        try{
            Thread.sleep(2000);
       }catch(Exception e){
           e.printStackTrace();}

        if(random.nextInt(2)==0){
            Player1_turn=true;
            textfield.setText("X turn");
        }
        else{
            Player1_turn=false;
            textfield.setText("0 turn");
        }
        
    
}
    
    public void check(){
        
        if((button[0].getText()=="X")&& (button[1].getText()=="X") && (button[2].getText()=="X")){
           XWins(0,1,2);
                 
    }
        
        
        else if((button[3].getText()=="X")&& (button[4].getText()=="X") && (button[5].getText()=="X")){
           XWins(3,4,5);
            
        }
        
        else if((button[6].getText()=="X")&& (button[7].getText()=="X") && (button[8].getText()=="X")){
           XWins(6,7,8);
            
        }
        
       else if((button[0].getText()=="X")&& (button[3].getText()=="X") && (button[6].getText()=="X")){
           XWins(0,3,6);
            
        }
       else if((button[1].getText()=="X")&& (button[4].getText()=="X") && (button[7].getText()=="X")){
           XWins(1,4,7);
            
        }
        
       else if((button[2].getText()=="X")&& (button[5].getText()=="X") && (button[8].getText()=="X")){
           XWins(2,5,8);
            
        }
        
       else if((button[0].getText()=="X")&& (button[4].getText()=="X") && (button[8].getText()=="X")){
           XWins(0,4,8);
            
        }
        
        if((button[2].getText()=="X")&& (button[4].getText()=="X") && (button[6].getText()=="X")){
           XWins(2,4,6);
            
        }
        
        
        
        
        
        /*O wins*/
        
        else{
         if((button[0].getText()=="O")&& (button[1].getText()=="O") && (button[2].getText()=="O")){
           OWins(0,1,2);
                 
    }
        
        
         else if((button[3].getText()=="O")&& (button[4].getText()=="O") && (button[5].getText()=="O")){
           OWins(3,4,5);
            
        }
        
         else if((button[6].getText()=="O")&& (button[7].getText()=="O") && (button[8].getText()=="O")){
           OWins(6,7,8);
            
        }
        
         else if((button[0].getText()=="O")&& (button[3].getText()=="O") && (button[6].getText()=="O")){
           OWins(0,3,6);
            
        }
         else if((button[1].getText()=="O")&& (button[4].getText()=="O") && (button[7].getText()=="O")){
            OWins(1,4,7);
            
        }
        
         else if((button[2].getText()=="O")&& (button[5].getText()=="O") && (button[8].getText()=="O")){
           OWins(2,5,8);
            
        }
        
         else if((button[0].getText()=="O")&& (button[4].getText()=="O") && (button[8].getText()=="O")){
           OWins(0,4,8);
            
        }
        
         else if((button[2].getText()=="O")&& (button[4].getText()=="O") && (button[6].getText()=="O")){
           OWins(2,4,6);
            
        }  
        }
        
        boolean isDraw = true;
    for (int i = 0; i < 9; i++) {
        if (button[i].getText().equals("")) {
            isDraw = false;
            break;
        }
    }

    if (isDraw) {
        drawAlert();
    }
}

     public void drawAlert() {
    JOptionPane.showMessageDialog(frame, "The game is a draw!", "Draw", JOptionPane.INFORMATION_MESSAGE);
  
}
           
    

    
    public void XWins(int a, int b, int c){
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        
        for(int i=0; i<9; i++){
            button[i].setEnabled(false);
        }
        
        textfield.setText("X Wins");
        JOptionPane.showMessageDialog(frame, "Congratulations Player X !!!!!!");
  
}
    
    public void OWins(int a, int b, int c){
        
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        
        for(int i=0; i<9; i++){
            button[i].setEnabled(false);
        }
        
        textfield.setText("O Wins");
        JOptionPane.showMessageDialog(frame, "Congratulations Player O !!!!!!");
        
}
    
    public void restartGame() {
        for (int i = 0; i < 9; i++) {
            button[i].setText("");
            button[i].setBackground(null);
            button[i].setEnabled(true);
        }

        Player1_turn = true;
        textfield.setText("X turn");

        frame.repaint(); // Repaint the frame to reflect the changes
    }
    
    
}