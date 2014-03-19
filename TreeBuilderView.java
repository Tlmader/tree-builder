/* TreeBuilderView.java
*
*  Description: This class sets up the main GUI screen of the TreeBuilder program.
*
*  Author: Ted Mader, 3/13/2014
*/

import java.lang.StringBuilder;
import java.io.OutputStream;
import java.io.PrintStream;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class TreeBuilderView extends JFrame
{
	private JPanel buttonsPanel;
	private JPanel printPanel;
	
	private GridLayout mainLayout;
	private GridLayout buttonsLayout;
	private GridLayout printLayout;
	
	private JButton loadTextButton;
	private JButton loadSerButton;
	private JButton printButton;
	private JButton quitButton;
	
	private String loadTextButtonCommand = "loadTextButton";
	private String loadSerButtonCommand = "loadSerButton";
	private String printButtonCommand = "printButton";
	private String quitButtonCommand = "quitButton";
	
	private JTextArea printTextArea;
	
	private JScrollPane printScrollPane;
	
	//Constructor
	
	protected TreeBuilderView()
	{
		setTitle( "Binary Tree Builder" );
		setPreferredSize( new Dimension( 480, 320 ) );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo( null );
		setResizable( false );
		
		//Set the layout of the frame
		
		mainLayout = new GridLayout( 1, 2, 5, 5 );
		setLayout( mainLayout );
		
		//Add the panels to the frame
		
		add( buttonsPanel() );
		add( printPanel() );
		
		pack();
		setVisible( true );
		toFront();
	}
	
	//Creates the panel containing the load, print, and quit buttons
	
	private JPanel buttonsPanel()
	{
		buttonsPanel = new JPanel();
		
		//Set layout for buttonsPanel
		
		buttonsLayout = new GridLayout( 4, 1, 5, 5 );
		buttonsPanel.setLayout( buttonsLayout );
		
		loadTextButton = new JButton( "Load Text File" );
		loadSerButton = new JButton( "Load Serialized File" );
		printButton = new JButton( "Print Integers" );
		quitButton = new JButton( "Quit" );
		
		//Set action commands for buttons

		loadTextButton.setActionCommand( loadTextButtonCommand );
		loadSerButton.setActionCommand( loadSerButtonCommand );
		printButton.setActionCommand( printButtonCommand );
		quitButton.setActionCommand( quitButtonCommand );
		
		//Add the buttons to the panel

		buttonsPanel.add( loadTextButton );
		buttonsPanel.add( loadSerButton );
		buttonsPanel.add( printButton );
		buttonsPanel.add( quitButton );
		
		return buttonsPanel;
	}
	
	//Creates the panel containing the text area displaying the actions and integers
	
	private JPanel printPanel()
	{
		printPanel = new JPanel();
		printPanel.setFocusable(false);
		
		//Set layout for printPanel
		
		printLayout = new GridLayout( 1, 1, 5, 5 );
		printPanel.setLayout( printLayout );
		
		//Create text area and set the output stream
		
		printTextArea = new JTextArea();
		System.setOut( new PrintStream( new TextAreaOutputStream( printTextArea ) ) );
		
		//Allow scrolling for the text area
		
		printScrollPane = new JScrollPane( printTextArea );
		printPanel.add( printScrollPane );
		
		return printPanel;
	}
	
	//Action listeners
	
	protected void treeBuilderActionListeners( ActionListener event )
	{
		loadTextButton.addActionListener( event );
		loadSerButton.addActionListener( event );
		printButton.addActionListener( event );
		quitButton.addActionListener( event );
	}
}