/**
 * An up/down counter with a simple GUI.
 * 
 * @author Lynn Marshall
 * @version November 17, 2012
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class tictactoeGUI implements ActionListener
{
   
   /* A JTextField displays the current value of the counter. */
   private JTextField counterDisplay;
   
   /* The button that is clicked to increment the counter. */
   private JButton oneone,onetwo,onethree,twoone,twotwo,twothree,threeone,threetwo,threethree;

   /* The button that is clicked to decrement the counter. */
   private JButton downButton;

   /* The button that is clicked to reset the counter. */
   private JButton resetButton;
   
   /* The reset menu item */
   private JMenuItem NewGame;
   
   /* The quit menu item */
   private JMenuItem QuitGame;
   
   /* The history area */
   private JTextArea history;
   
   private int turn; //used to indicate whos turn it is. turn 1 = player one, turn 2 = player 2
   
   public tictactoeGUI() {
      
      
      // JFrame
      JFrame frame = new JFrame("Tic-Tac-Toe");
      Container contentPane = frame.getContentPane(); 
      contentPane.setLayout(new GridLayout(3,3)); // use border layout (default)
      
      JMenuBar menubar = new JMenuBar();
      frame.setJMenuBar(menubar); // add menu bar to our frame

      JMenu fileMenu = new JMenu("Game"); // create a menu
      menubar.add(fileMenu); // and add to our menu bar

      NewGame = new JMenuItem("New (ctrl-N)"); // create a menu item called "Reset"
      fileMenu.add(NewGame); // and add to our menu

      QuitGame = new JMenuItem("Quit (ctrl-Q)"); // create a menu item called "Quit"
      fileMenu.add(QuitGame); // and add to our menu
      
      // this allows us to use shortcuts (e.g. Ctrl-N and Ctrl-Q)
      final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(); // to save typing
      NewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, SHORTCUT_MASK));
      QuitGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
      
      // listen for menu selections
      NewGame.addActionListener(this); 
      QuitGame.addActionListener(new ActionListener() // create an anonymous inner class
        { // start of anonymous subclass of ActionListener
          // this allows us to put the code for this action here  
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0); // quit
            }
        } // end of anonymous subclass
      ); // end of addActionListener parameter list and statement
      // add a label
      JLabel label = new JLabel("PLAYER INSTRUCTIONS: Player 1 is first. Player 1 uses the symbol X. Click on a button to assign an X. Then it will be player 2's (O's) turn. Click on a button to assign an O. The game status (whos turn, who won, tie) is on the bottom of the board.");
      label.setHorizontalAlignment(JLabel.RIGHT); // right justified
      contentPane.add(label,BorderLayout.EAST); // west side 
      // the gridaylayout of buttons
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(3, 3)); // 3 x 3 grid

      oneone = new JButton(); //represents column one, button one (1,1). 
      //as in most top column and most left button
      buttonPanel.add(oneone); // add to button panel
      onetwo = new JButton();// column one and middle button
      buttonPanel.add(onetwo);
      onethree = new JButton();
      buttonPanel.add(onethree);
      twoone = new JButton(); //column two now, most left button (2,1)...etc.
      buttonPanel.add(twoone);
      twotwo = new JButton();
      buttonPanel.add(twotwo);
      twothree = new JButton();
      buttonPanel.add(twothree);
      threeone = new JButton();
      buttonPanel.add(threeone);
      threetwo = new JButton();
      buttonPanel.add(threetwo);
      threethree = new JButton();
      buttonPanel.add(threethree);

      /* Place the buttons at the top. */
      contentPane.add(buttonPanel, BorderLayout.NORTH); // north side
      
      // register all buttons as listeners
      oneone.addActionListener(this); onetwo.addActionListener(this);onethree.addActionListener(this);
      twoone.addActionListener(this);twotwo.addActionListener(this);twothree.addActionListener(this);
      threeone.addActionListener(this);threetwo.addActionListener(this);threethree.addActionListener(this);

      turn = 1; //set default turn to 1, signifing player 1
      history = new JTextArea(20,10);//for current games status
      JScrollPane pane = new JScrollPane(history); // put text area in a scroll pane
      contentPane.add(pane,BorderLayout.SOUTH); // south side
      history.append("\n Game in progress. Its currently player number "+ turn + "'s turn"); //output whos turn it is
      history.setEditable(false); // cant write stuff on display at bottom
      // finish setting up the frame
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // exit when we hit the "X"
      frame.pack(); // pack everthing into our frame
      frame.setResizable(true); // we can resize it
      frame.setVisible(true); // it's visible
   }
   
   /** This action listener is called when the user clicks on 
    * any of the GUI's buttons. 
    */
    public void actionPerformed(ActionEvent e)
    {
        Object o = e.getSource(); // get the action 
       
        // see if it's a JButton
        if (o instanceof JButton) {
        
            JButton button = (JButton)o;
            //depending on which button is clicked and whos turn it is, place either X and O.
            //Always starts with an X for the first player who goes, which is player 1, then
            //it alternates.
        
            if (button == oneone && turn == 1) { // put X
                button.setText("X");
                turn =2;
                button.setEnabled(false);
            } else if (button == oneone && turn ==2) { // put O. repeated below
                button.setText("O");
                turn =1;
                button.setEnabled(false);
            }else if (button == onetwo && turn ==1) { 
                button.setText("X");
                turn =2;
                button.setEnabled(false);
            }else if (button == onetwo && turn ==2) { 
                button.setText("O");
                turn =1;
                button.setEnabled(false);
            }else if (button == onethree && turn ==1) { 
                button.setText("X");
                turn =2;
                button.setEnabled(false);
            }else if (button == onethree && turn ==2) { 
                button.setText("O");
                turn =1;
                button.setEnabled(false);
            }else if (button == twoone && turn ==1) { 
                button.setText("X");
                turn =2;
                button.setEnabled(false);
            }else if (button == twoone && turn ==2) { 
                button.setText("O");
                turn =1;
                button.setEnabled(false);
            }else if (button == twotwo && turn ==1) { 
                button.setText("X");
                turn =2;
                button.setEnabled(false);
            }else if (button == twotwo && turn ==2) { 
                button.setText("O");
                turn =1;
                button.setEnabled(false);
            }else if (button == twothree && turn ==1) { 
                button.setText("X");
                turn =2;
                button.setEnabled(false);
            }else if (button == twothree && turn ==2) { 
                button.setText("O");
                turn =1;
                button.setEnabled(false);
            }else if (button == threeone && turn ==1) { 
                button.setText("X");
                turn =2;
                button.setEnabled(false);
            }else if (button == threeone && turn ==2) { 
                button.setText("O");
                turn =1;
                button.setEnabled(false);
            }else if (button == threetwo && turn ==1) { 
                button.setText("X");
                turn =2;
                button.setEnabled(false);
            }else if (button == threetwo && turn ==2) { 
                button.setText("O");
                turn =1;
                button.setEnabled(false);
            }else if (button == threethree && turn ==1) { 
                button.setText("X");
                turn =2;
                button.setEnabled(false);
            }else if (button == threethree && turn ==2) { 
                button.setText("O");
                turn =1;
                button.setEnabled(false);
            }
        } else { // it's a JMenuItem
            
            JMenuItem item = (JMenuItem)o;
            
            if (item == NewGame) { // reset the board buttons
              oneone.setText("");onetwo.setText("");onethree.setText("");twoone.setText("");
              twotwo.setText("");twothree.setText("");threeone.setText("");threetwo.setText("");
              threethree.setText("");
              oneone.setEnabled(true);onetwo.setEnabled(true);onethree.setEnabled(true);
              twoone.setEnabled(true);twotwo.setEnabled(true);twothree.setEnabled(true);
              threeone.setEnabled(true);threetwo.setEnabled(true);threethree.setEnabled(true);

            }
               
        }
      
        // update the display
      
        history.append("\n Game in progress. Its currently player number "+ turn + "'s turn");
        
        //if sommeone wins we need to output it on display. here i go through every
        //possible winning combination on the tic tac toe board. if one matches, the 
        //display  out puts weather X's win or O's win.
        if((oneone.getText()=="X" && onetwo.getText()=="X"&& onethree.getText()=="X")||
        (twoone.getText()=="X" && twotwo.getText()=="X"&& twothree.getText()=="X")||
        (threeone.getText()=="X" && threetwo.getText()=="X"&& threethree.getText()=="X")||
        (oneone.getText()=="X" && twoone.getText()=="X"&& threeone.getText()=="X")||
        (onetwo.getText()=="X" && twotwo.getText()=="X"&& threetwo.getText()=="X")||
        (onethree.getText()=="X" && twothree.getText()=="X"&& threethree.getText()=="X")||
        (oneone.getText()=="X" && twotwo.getText()=="X"&& threethree.getText()=="X")||
        (onethree.getText()=="X" && twotwo.getText()=="X"&& threeone.getText()=="X")){
            history.append("\n hold up! X's (player 1) Win! Select Game menu  option & start a new game, or quit. ");
            oneone.setEnabled(false);onetwo.setEnabled(false);onethree.setEnabled(false);
            twoone.setEnabled(false);twotwo.setEnabled(false);twothree.setEnabled(false);
            threeone.setEnabled(false);threetwo.setEnabled(false);threethree.setEnabled(false);
        }
        //in the case that O's win.
        else if((oneone.getText()=="O" && onetwo.getText()=="O"&& onethree.getText()=="O")||
        (twoone.getText()=="O" && twotwo.getText()=="O"&& twothree.getText()=="O")||
        (threeone.getText()=="O" && threetwo.getText()=="O"&& threethree.getText()=="O")||
        (oneone.getText()=="O" && twoone.getText()=="O"&& threeone.getText()=="O")||
        (onetwo.getText()=="O" && twotwo.getText()=="O"&& threetwo.getText()=="O")||
        (onethree.getText()=="O" && twothree.getText()=="O"&& threethree.getText()=="O")||
        (oneone.getText()=="O" && twotwo.getText()=="O"&& threethree.getText()=="O")||
        (onethree.getText()=="O" && twotwo.getText()=="O"&& threeone.getText()=="O")){
            history.append("\n hold up! O's Win! Select Game menu  option & start a new game, or quit. ");
            oneone.setEnabled(false);onetwo.setEnabled(false);onethree.setEnabled(false);
            twoone.setEnabled(false);twotwo.setEnabled(false);twothree.setEnabled(false);
            threeone.setEnabled(false);threetwo.setEnabled(false);threethree.setEnabled(false);
        }
        //in the case of a tie, all buttons will be disabled at the end.
        else if((!oneone.isEnabled()) && (!onetwo.isEnabled())&&(!onethree.isEnabled())&&
        (!twoone.isEnabled())&&(!twotwo.isEnabled())&&(!twothree.isEnabled())&&
        (!threeone.isEnabled())&&(!threetwo.isEnabled())&&(!threethree.isEnabled())){
           history.append("\n Its a tie. Select Game menu  option & start a new game, or quit. (can also use ctr-N or ctr-Q) ");
        }
    }
 } 



