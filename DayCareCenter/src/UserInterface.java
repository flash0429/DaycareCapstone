import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class UserInterface {
	
	public UserInterface()
	{
		//instantiate gui class
		gui gui = new gui();
		//set-up layout manager
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		//create frame
		JFrame frame = new JFrame();
		//create container panel
		JPanel containerPanel = gui.makeParentPanel(frame, layout, c, 0, 0);
		JMenuBar menuBar = gui.makeMenuBar(containerPanel, layout, c, 0,0);
		//create account panel and attach to main panel
		JPanel accountsPanel = gui.makeChildPanel(containerPanel, layout,c,0,1);
		//create account controls and attach to account panel (list box, labels, means of sorting...)
		JLabel listLabel = gui.makeLabel("Accounts", accountsPanel, layout, c, 0, 0);
		//TODO extend listLabel to horizontally fill panel
		JList accountList = gui.makeListBox(null, accountsPanel, layout, c, 0, 1);
		//create info panel to display account payer info and child info
		JPanel infoPanel = gui.makeChildPanel(containerPanel, layout, c, 1, 1);
		//create account payer info panel
		JPanel payerPanel = gui.makeChildPanel(infoPanel, layout, c, 0, 0);
		//create all components necessary for payer panel
		JLabel payerLabel = gui.makeLabel("Payer Information", payerPanel, layout, c, 0, 0);
		//TODO extend payerLabel all the way across panel
		JLabel payerPhoto = gui.makePictureBox("placeholder.jpg", 100, 100, payerPanel, layout, c, 0, 1);//makePictureBox attaches an image to JLabel and displays it much the same as VB's PictureBox
		
		//
		JPanel childInfoPanel = gui.makeChildPanel(infoPanel, layout, c, 0, 1);
		
		gui.addPanel2Frame(containerPanel, frame, BorderLayout.EAST);
	}
	
	
}
