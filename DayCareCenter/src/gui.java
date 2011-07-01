
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gui 
{
	protected JLabel makeLabel(String text,JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int column, int row)
	{//create label method
		JLabel label = new JLabel(text);		
		gridbag.setConstraints(label, c);
		c.gridx = column;
		c.gridy = row;
		panel.add(label,c);
		return label;
	}
	
	protected JTextField makeTextfield (String name, JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int column,int row)
	{// TextField method
		JTextField textfield = new JTextField(name);		
		gridbag.setConstraints(textfield, c);
		c.gridx = column;
		c.gridy = row;
		panel.add(textfield,c);
		return textfield;
	}
	
	protected JButton makeButton(String name, JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int column, int row) 
	{   // create button method
		JButton button = new JButton(name);
        gridbag.setConstraints(button, c);
        c.gridx = column;
        c.gridy = row;
        panel.add(button,c);
        return button;
	}
	
	protected <T> JList makeListBox(T[] data, JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int column, int row) 
	{   // create button method
		JList list = new JList(data);
        gridbag.setConstraints(list, c);
        c.gridx = column;
        c.gridy = row;
        panel.add(list,c);
        return list;
	}
	
	/*protected JList makeListBoxA(Object[] data, JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int column, int row) 
	{   // create button method
		JList list = new JList(data);
        gridbag.setConstraints(list, c);
        c.gridx = column;
        c.gridy = row;
        panel.add(list,c);
        return list;
	}*/
	
	protected JPanel makeChildPanel(JPanel panel, GridBagLayout gridbag,GridBagConstraints c,int column, int row)//makes a panel and places it inside a "parent" panel 
	{
		JPanel thisPanel = new JPanel();
        gridbag.setConstraints(thisPanel, c);
        c.gridx = column;
        c.gridy = row;
        panel.add(thisPanel,c);
        return thisPanel;
	}
	
	protected JPanel makeParentPanel(JFrame frame, GridBagLayout gridbag,GridBagConstraints c,int column, int row) //makes a panel which will contain other panels
	{
		JPanel thisPanel = new JPanel();
        gridbag.setConstraints(thisPanel, c);
        c.gridx = column;
        c.gridy = row;
        frame.add(thisPanel, c);
        return thisPanel;
	}
	
	protected JMenuBar makeMenuBar(JPanel panel, GridBagLayout gridbag, GridBagConstraints c, int column, int row)
	{
		JMenuBar menu = new JMenuBar();
		gridbag.setConstraints(menu, c);
		c.gridx = column;
		c.gridy = row;
		panel.add(menu, c);
		return menu;
	}
	
	protected JLabel makePictureBox(String filename, int height, int width, JPanel panel, GridBagLayout gridbag, GridBagConstraints c, int column, int row)
	{
		ImageIcon pic = new ImageIcon(filename);
		//TODO optimize image to specified dimensions
		JLabel image = new JLabel(pic);
		gridbag.setConstraints(image, c);
		c.gridx = column;
		c.gridy = row;
		panel.add(image, c);
		return image;
	}
	
	public void addPanel2Frame(JPanel panel,JFrame frame, String orientation)//orientation is a BorderLayout constant
	{
		frame.add(panel,orientation);
	}
		
	public void init(LayoutManager layout, JFrame frame, int width, int height)  
	{
		// setting up frame
		//frame = new JFrame (winName);
		frame.setLayout(layout);
		frame.setLocationRelativeTo(null);			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.pack();
		frame.setVisible(true);
	}

	
}
