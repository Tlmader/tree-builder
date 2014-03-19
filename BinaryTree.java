/* BinaryTree.java
*
*  Description: The BinaryTree class implements the insert() method and the inOrder() traversal method in order to:
*  1. De-serialize an ArrayList object from a file.
*  2. Iterate over the ArrayList object reading the values stored in it and insert each value into a BinaryTree object.
*  3. Use the in order traversal of the BinaryTree object to print the integers in sorted order.
*  
*  Author: Ted Mader, 3/13/2014
*/

//Class implementing a binary tree
//with in order traversal
	
public class BinaryTree
{
	//Instance variables
	private int data;
	private BinaryTree leftSubtree;
	private BinaryTree rightSubtree;
	
	//Constructor:
	//Parameters: int value contains the data being stored
	//BinaryTree instance variables do not contain sub-trees
	//initially, so they are set to null.

	public BinaryTree( int value )
	{
		
		this.data = value;
		this.leftSubtree = null;
		this.rightSubtree = null;
	}
	
	//Returns the value stored in this node

	public int getData()
	{
		return this.data;
	}

	//Method insert, adds a value to the tree
	//Parameters: int value contains the value to be added

	public void insert( int value )
	{
		if( value <= data )
		{
			if( this.leftSubtree != null )
			{
				this.leftSubtree.insert( value );
			}
			
			else
			{
				this.leftSubtree = new BinaryTree( value );
			}
		}
		
		else if( value > data )
		{
			if( this.rightSubtree != null )
			{
				this.rightSubtree.insert( value );
			}
			
			else
			{
				this.rightSubtree = new BinaryTree( value );
			}
		}
	}

	//Method inOrder traverses the tree following the in order
	//traversal algorithm. When each node is ‘visited’ by the
	//algorithm print the value at that node to the screen

	public void inOrder()
	{
		if( this.leftSubtree != null )
		{
			this.leftSubtree.inOrder();
		}
		
		System.out.println( data );
		getData();
		
		if( this.rightSubtree != null )
		{
			this.rightSubtree.inOrder();
		}
	}
}