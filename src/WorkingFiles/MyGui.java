package WorkingFiles;

import com.GameLogic.Game;
import com.Story.Story;
import com.Utility.Printer;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static com.Utility.Printer.print;

public class MyGui {

    JFrame frame;
    Container cp;
    Font titleFont;
    JPanel titlePanel;
    JPanel buttonPanel;
    JLabel gameTitle;
    JButton playButton;
    JButton infoButton;
    JPanel topPanel;
    JPanel centerPanel;
    JPanel bottomPanel;
    JLabel bottomTextLabel;
    static JTextField bottomTf;
    static JTextArea mainTextArea;
    static String newline;
    StartGameHandler sgHandler = new StartGameHandler();
    InputTextHandler itHandler = new InputTextHandler();

    //Game newGame;

    /*public static void main(String[] args) throws IOException, ParseException {

        new MyGui();
    }*/

    public MyGui() throws IOException, ParseException {

        //newGame = new Game();
        frame = new JFrame("Goblin's Greed");
        cp = frame.getContentPane();
        titleFont = new Font("Times New Roman", Font.PLAIN, 90);
        titlePanel = new JPanel();
        buttonPanel = new JPanel();
        gameTitle = new JLabel("Goblin's Greed");
        playButton = new JButton("Play");
        infoButton = new JButton("More Info");
        newline = "\n";
        mainTextArea = new JTextArea("This is the main text area. ");
        //StartGameHandler sgHandler = new StartGameHandler();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        cp.setBackground(Color.GRAY);
        gameTitle.setFont(titleFont);

        titlePanel.setBounds(100, 100, 600, 150);
        buttonPanel.setBounds(300, 400, 200, 100);
        playButton.setBackground(Color.GREEN);
        infoButton.setBackground(Color.GREEN);
        playButton.addActionListener(sgHandler);
        infoButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, Story.tutorial()));

        titlePanel.add(gameTitle);
        buttonPanel.add(playButton);
        buttonPanel.add(infoButton);

        frame.add(buttonPanel);
        frame.add(titlePanel);


        frame.setVisible(true);
        

    }

    public class StartGameHandler implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            startGameScreen();
        }

        private void startGameScreen() {
            buttonPanel.setVisible(false);
            titlePanel.setVisible(false);

            cp.setBackground(Color.GRAY);

            topPanel = new JPanel();
            centerPanel = new JPanel();
            bottomPanel = new JPanel();
            bottomTextLabel = new JLabel("Enter your command here: ");
            bottomTf = new JTextField(30);

            //JLabel sample = new JLabel("Goblin's Greed");
            //mainTextArea = new JTextArea("This is the main text area. ");
            //mainTextArea.setBackground(Color.white);
            //mainTextArea.setLineWrap(true);
            //mainTextArea.setWrapStyleWord(true);
            mainTextArea.setEditable(false);
            bottomTf.addActionListener(itHandler);


            centerPanel.add(mainTextArea);
            bottomPanel.add(bottomTextLabel);
            bottomPanel.add(bottomTf);

            cp.add(BorderLayout.NORTH, topPanel);
            cp.add(BorderLayout.CENTER, centerPanel);
            cp.add(BorderLayout.SOUTH, bottomPanel);

        }


    }

    public class InputTextHandler implements ActionListener {

        //takes input from JTextField at bottom
        @Override
        public void actionPerformed(ActionEvent e) {
            /*String text = mainTextArea.getText();
            mainTextArea.append(text + newline);
            mainTextArea.selectAll();*/
            if(e.getSource() == bottomTf){
                String str = bottomTf.getText();
                if(!str.equals("")){
                    //commandHandler.handle(str);
                }
            }
        }
    }

    /*public void run(){
        ui.print(commandHandler.listCommands());

        while(true){
            if(commandHandler.continue()){
                ui.print(commandHandler.events());
            }
        }
    }*/

    public static void outputTextArea(String output) {
        //output to JTextArea in center
        mainTextArea.append(output + newline);
        //mainTextArea.setText(output);
    }





}
