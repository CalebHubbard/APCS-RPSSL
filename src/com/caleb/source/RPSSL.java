package com.caleb.source;
//test
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* Pseudo code
 *  Take user input
 *  Make random comp input
 *  Check the table based on user input, and comp input
 *  Print who won, with the correct verb / positioning
 * */

public class RPSSL {
    
    static final int WIDTH = 232;
    static final int HEIGHT = 540;

    static int input;
    static int compInput;
    
    static String[] objects = {"rock","paper","scissors","spock","lizard"};
    static Integer[] numbers = {0,1,2,3,4};
    
    //x = comp                                      //Predefined table of outcomes
    //y = user
    //0 = comp win
    //1 = tie
    //2 = user win
    static int[][]  table  =  
        {            //       computer
                //       R  P  S  S  L
                /* u   R*/  { 1, 0, 2, 0, 2 },
                /* s   P*/  { 2, 1, 0, 2, 0 },
                /* e   S*/  { 0, 2, 1, 0, 2 },
                /* r   S*/  { 2, 0, 2, 1, 0 },
                /*     L*/  { 0, 2, 0, 2, 1 }
        };
    
    static String[][] verb = 
        {            //       computer
                     //       R            P            S              S            L
                /* u   R*/  { "",          "covers",    "crushes",     "eats",      "smashes"     },
                /* s   P*/  { "covers",    "",          "cuts",        "disproves", "eats"        },
                /* e   S*/  { "crushes",   "cuts",      "",            "smashes",   "decapitates" },
                /* r   S*/  { "eats",      "disproves", "smashes",     "",          "poisons"     },
                /*     L*/  { "smashes",   "eats",      "decapitates", "poisons",   ""            }
        };//////
    
    static JFrame frame = new JFrame("Rock, Paper, Scissors, Spock, Lizard");
    
    static JPanel mainPanel = new JPanel();
    static JPanel panel = new JPanel();
    static JPanel buttons = new JPanel();
    static JPanel plays = new JPanel();
    static JPanel output = new JPanel();
    
    static JLabel label = new JLabel("What do you choose?");
    static JLabel answer = new JLabel();
    static JLabel userPlay = new JLabel();
    static JLabel compPlay = new JLabel();
    
    static JButton rockButton = new JButton("Rock");
    static JButton paperButton = new JButton("Paper");
    static JButton scissorsButton = new JButton("Scissors");
    static JButton spockButton = new JButton("Spock");
    static JButton lizardButton = new JButton("Lizard");

    
    public static void main(String[] args) {
        
        
        //Start frame definition
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        mainPanel.add(panel);
        mainPanel.add(buttons);
        mainPanel.add(plays);
        mainPanel.add(output);
        
        panel.add(label);
        
        output.add(answer);
        
        buttons.add(rockButton);
        buttons.add(paperButton);
        buttons.add(scissorsButton);
        buttons.add(spockButton);
        buttons.add(lizardButton);

        plays.add(userPlay);
        plays.add(compPlay);
        
        frame.add(mainPanel);
        frame.setVisible(true);
        //End frame definition
        
        //Start button ActionListener definitions
        rockButton.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                input = 0;
                play();
                
            }

        });

        paperButton.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                input = 1;
                play();
                
            }

        });
        
        scissorsButton.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                input = 2;
                play();
                
            }

        });

        spockButton.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                input = 3;
                play();
                
            }

        });

        lizardButton.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                input = 4;
                play();
                
            }

        });
        //End button ActionListener definitions

    }
    
    public static void play() {
        
        compInput = (int) (Math.random() * 5);      //Random computer input (0-4)
        
        userPlay.setText("You chose " + convertInput(input)); //Display users input as String
        compPlay.setText(" You're opponent chose " + convertInput(compInput)); //Display computer input as String

        check(input, compInput); //Checks user input compared to computer input as ints
        
    }

    public static String convertInput(int input) {

        for (int i = 0; i < numbers.length; i++) {
            
            if (input == (numbers[i])) {    
                                                //Converts input from int to string
                return objects[i];
                
            }
            
        }
        
        return (String) null;
        
    }

    public static void check(int user, int comp) {

        if (table[user][comp] == 0) {				//Loss
            
            answer.setText(convertInput(compInput) + " " + verb[user][comp] + " " + convertInput(input)); //Display that the user lost with the correct verb
            
        }
        if (table[user][comp] == 1) {					//Tie
            
            answer.setText(convertInput(input) + " ties with " + convertInput(compInput)); //Display that the user tied
            
        }
        if (table[user][comp] == 2) {					//Win
            
            answer.setText(convertInput(input) + " " + verb[user][comp] + " " + convertInput(compInput)); //Display that the user won with the correct verb
        
        }

    }
}
