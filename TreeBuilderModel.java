/* TreeBuilderController.java
*
*  Description: This class is the model for the Risk program. It contains the data and the methods and
*				functions that are required to manipulate the data.
*
*  Author: Ted Mader, 3/13/2014
*/

import java.util.Observable;
import java.util.ArrayList;
import java.lang.Integer;
import java.lang.ClassNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TreeBuilderModel extends Observable
{
	private ObjectInputStream objectInputStream;
	private FileInputStream fileInputStream;
	private DataInputStream dataInputStream;
	private BufferedReader bufferedReader;
	
	private int i = 0;
	private int intToInsert;
	
	private String line;
	
	private JFileChooser fileChooser;
	private File file;
	
	private ArrayList<String> arrayList;
	
	private BinaryTree binaryTree;
	
	protected void loadTextFile( TreeBuilderView view )
	{
		//Opens file chooser, accepts text files
		
		fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter( "Text Files", "txt", "text" );
		fileChooser.setFileFilter( filter );
		
		if ( fileChooser.showOpenDialog( view ) == JFileChooser.APPROVE_OPTION )
		{
			file = fileChooser.getSelectedFile();
		}
		
		//Reads a text file and stores integers into an array
		
		try
		{
			fileInputStream = new FileInputStream( file );
			dataInputStream = new DataInputStream( fileInputStream );
			bufferedReader = new BufferedReader( new InputStreamReader( dataInputStream ) );
			
			arrayList = new ArrayList<String>();
					
			while( ( line = bufferedReader.readLine() ) != null )
			{
				line = line.trim();
				
				if( line.length() != 0 )
				{
					arrayList.add( line );
				}
			}
			
			buildTree( arrayList );
		}
		
		//Error message when file chooser fails
		
		catch( IOException e )
		{
			System.out.println( e.getMessage() );
		}
	}
	
	protected void loadSerFile( TreeBuilderView view )
	{
		//Opens file chooser, accepts serialized files
		
		fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter( "Serialized Files", "ser" );
		fileChooser.setFileFilter( filter );
		
		if ( fileChooser.showOpenDialog( view ) == JFileChooser.APPROVE_OPTION )
		{
			file = fileChooser.getSelectedFile();
		}
		
		try
		{
			objectInputStream = new ObjectInputStream( new FileInputStream( file ) );
			arrayList = ( ArrayList<String> )objectInputStream.readObject();
			
			buildTree( arrayList );
		}
		
		//Error message when file chooser fails
		
		catch( IOException e )
		{
			System.out.println( e.getMessage() );
		}
		
		catch( ClassNotFoundException e )
		{
			System.out.println( e.getMessage() );
		}	
	}
	
	//Creates the binary tree using the deserialized integers
		
	protected BinaryTree buildTree( ArrayList<String> arrayList )
	{
		System.out.println( "Creating new binary tree with integers:" );
		
		for ( i = 0; i < arrayList.size(); i++ )
		{
			//Creates a new BinaryTree using the first integer
		
			if( i == 0 )
			{
				intToInsert = Integer.parseInt( arrayList.get( i ) );
				System.out.println( intToInsert );
				binaryTree = new BinaryTree( intToInsert );
			}
			
			//Following integers will be inserted into the existing BinaryTree
			
			else
			{
				intToInsert = Integer.parseInt( arrayList.get( i ) );
				System.out.println( intToInsert );
				binaryTree.insert( intToInsert );
			}
		}
		
		return binaryTree;
	}
	
	//Sorts and prints the integers to the text area
	
	protected void print()
	{
		System.out.println( "Printing integers in sorted order..." );
		binaryTree.inOrder();
	}
	
	//Exits the program
	
	protected void quit()
	{
		System.exit( 0 );
	}
}