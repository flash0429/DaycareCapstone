import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;


public class UserInterface {
	
	int numberOfChildren = 1;
	int numberOfAccounts = 1;
	
	public UserInterface(int numberOfAccounts)
	{
		//instantiate gui class
		gui gui = new gui();
		//set-up layout manager
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		//create frame
		JFrame frame = new JFrame();
		frame.setBackground(Color.yellow);
		gui.frameInit(new BorderLayout(), frame, 800, 600);
		//create container panel
		c.fill = GridBagConstraints.HORIZONTAL;
		JPanel containerPanel = gui.makeParentPanel(frame, layout, c, false, 0, 0, BorderLayout.EAST);
		containerPanel.setBackground(Color.black);
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = GridBagConstraints.REMAINDER;
		JMenuBar menuBar = gui.makeMenuBar(containerPanel, layout, c, 0, 0);
		c.gridwidth = 1;
		menuBar.setBackground(Color.white);
		//create account panel and attach to main panel
		JPanel accountsPanel = gui.makeChildPanel(containerPanel, layout, c, 0, 1);
		accountsPanel.setBackground(Color.blue);
		//create account controls and attach to account panel (list box, labels, means of sorting...)
		c.gridwidth = GridBagConstraints.REMAINDER;//sets label to use entire space at top
		JLabel listLabel = gui.makeLabel("Accounts", accountsPanel, layout, c, 0, 0);
		c.gridwidth = 1;//sets gridwidth back to normal
		JTable accountList = gui.makeTable(2, numberOfAccounts, accountsPanel, layout, c, 0, 1);
		//create info panel to display account payer info and child info
		JPanel infoPanel = gui.makeChildPanel(containerPanel, layout, c, 1, 1);
		infoPanel.setBackground(Color.green);
		JLabel accountSummaryLabel = gui.makeLabel("Account Summary", infoPanel, layout, c, 0, 0);
		//create account payer info panel
		JPanel payerPanel = gui.makeChildPanel(infoPanel, layout, c, 0, 1);
		payerPanel.setBackground(Color.cyan);
		//create all components necessary for payer panel
		c.gridwidth = GridBagConstraints.REMAINDER;//label uses entire top space
		JLabel payerLabel = gui.makeLabel("Payer Information", payerPanel, layout, c, 0, 0);
		c.gridwidth = 1;
		//sets gridwidth back to normal
		c.gridheight = GridBagConstraints.REMAINDER;
		//payer photo is all of column 0
		JLabel payerPhoto = gui.makePictureBox("../images/placeholder.jpg", 100, 100, payerPanel, layout, c, 1, 1);//makePictureBox attaches an image to JLabel and displays it much the same as VB's PictureBox
		c.gridheight = 1;
		//column 1
		JLabel payerFNameLabel = gui.makeLabel("Fname", payerPanel, layout, c, 1, 2);
		JLabel payerLNameLabel = gui.makeLabel("Lname", payerPanel, layout, c, 1, 3);
		JLabel payerAddress = gui.makeLabel("Address", payerPanel, layout, c, 1, 4);
		//column 2
		JLabel payerPrimaryPhone = gui.makeLabel("Primary Phone #", payerPanel, layout, c, 2, 1);
		JLabel payerCellPhone = gui.makeLabel("Cell #", payerPanel, layout, c, 2, 2);
		JLabel payerWorkPhone = gui.makeLabel("Work #", payerPanel, layout, c, 2, 3);
		JLabel payerHomePhone = gui.makeLabel("Home Phone", payerPanel, layout, c, 2, 4);
		//column 3
		JLabel payerDOB = gui.makeLabel("D/O/B", payerPanel, layout, c, 3, 1);
		JLabel payerEmail = gui.makeLabel("Email Address", payerPanel, layout, c, 3, 3);
		//end payer panel
		//create panel to hold information about the child associated with currently selected account
		JPanel childInfoPanel = gui.makeChildPanel(infoPanel, layout, c, 0, 2);
		//create all components necessary to display child info
		JTable childRecords = gui.makeTable(numberOfChildren, 5, childInfoPanel, layout, c, 0, 0);
		// add records and column names to table
		//TODO need nates database stuff to add records
		c.gridx = 0;
		c.gridy = 0;
		//gui.addPanel2Frame(containerPanel, frame, c);
		gui.init(frame);
	}
	
	
}
