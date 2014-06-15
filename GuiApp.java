import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiApp {
    
    public GuiApp(Node question)
    {
	String Question = question.getQuestion;
	JFrame guiFrame = new JFrame();
        
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
			comboPanel.add(comboLbl2)
			break;
		    } else {
			GuiApp(question.getLeft);
			System.exit(0);
		    }
		}
	    });

	No.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event)
                {
		    if (question.getLeft() == null && question.getRight() == null){
		    } else {
			GuiApp(question.getRight);
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