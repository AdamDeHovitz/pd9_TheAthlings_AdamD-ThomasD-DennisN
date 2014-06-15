import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GuiApp {

    public GuiApp(Node current)
    {
        final String Question = current.getQuestion();
        JFrame guiFrame = new JFrame();
        final Node question = current;
        final Game game = new Game();

        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Guess my thing!");
        guiFrame.setSize(300,250);
        guiFrame.setLocationRelativeTo(null);

        final JPanel comboPanel = new JPanel();
        JLabel comboLbl = new JLabel(Question);
        comboPanel.add(comboLbl);

        JButton Yes = new JButton( "Yes");
        JButton No = new JButton( "No");

        Yes.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event)
                {
                    if (question.getLeft() == null && question.getRight() == null){
                        JLabel comboLbl2 = new JLabel("Yay that's your object!");
                        comboPanel.add(comboLbl2);
                    } else {
                        new GuiApp(question.getLeft());
                        System.exit(0);
                    }
                }
            });

        No.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event)
                {
                    if (question.getLeft() == null && question.getRight() == null){
                        ArrayList<Integer> properties = new ArrayList<Integer>();
                        for (int x = 0; x < game.getattributeList().size(); x++){
                            properties.add(-1);
                        }
                        game.createNew(properties);
                        System.exit(0);
                    } else {
                        new GuiApp(question.getRight());
                        System.exit(0);
                    }
                }
            });

        guiFrame.add(comboPanel, BorderLayout.NORTH);
                guiFrame.add(Yes, BorderLayout.CENTER);
        guiFrame.add(No,BorderLayout.SOUTH);

        guiFrame.setVisible(true);
    }

}
