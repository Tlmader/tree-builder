/* TreeBuilderController.java
*
*  Description: This class maps the user's actions in the the view to the data and methods in the model.
*
*  Author: Ted Mader, 3/13/2014
*/

import java.io.File;
import java.lang.Integer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

public class TreeBuilderController implements ActionListener
{
	private TreeBuilderModel model;
	private TreeBuilderView view;
	private JFileChooser fileChooser;
	private File file;
	
	//Constructor
	
	public TreeBuilderController( TreeBuilderModel model, TreeBuilderView view )
	{
		this.model = model;
		this.view = view;
		
		//Add this class' actionListener to TreeBuilderView's buttons
		
		view.treeBuilderActionListeners( this );
	}
	
	//TreeBuilderView's controller
	
	public void actionPerformed( ActionEvent e )
	{
		String actionEvent = e.getActionCommand();
		
		//Opens the file chooser
		
		if( actionEvent.equals( "loadTextButton" ) )
		{
			model.loadTextFile( view );
		}
		
		if( actionEvent.equals( "loadSerButton" ) )
		{
			model.loadSerFile( view );
		}
		
		//Sorts and prints the integers to the text area
		
		else if( actionEvent.equals( "printButton" ) )
		{
			model.print();
		}
		
		//Exits program
		
		else if( actionEvent.equals( "quitButton" ) )
		{
			model.quit();
		}
		
		else
		{
		}
	}
}
