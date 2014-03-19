/* TextAreaOutputStream.java
*
*  Description: The TextAreaOutputStream class can be used to wrapper a window, in this case the printTextArea in
*  TreeBuilderView.java as a stream. I may reuse this class in future projects.
*  
*  Credit: Thanks to iamsqrt1@gmail.com; his TextAreaOutputStream class served as a great example for learning how to make
*  this work.
* 
*  Author: Ted Mader, 3/13/2014
*/

import java.io.OutputStream;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TextAreaOutputStream extends OutputStream
{
    private JTextArea textArea;
    private StringBuilder stringBuilder = new StringBuilder();

    public TextAreaOutputStream( JTextArea textArea )
	{
        this.textArea = textArea;
    }
	
	//Writes the specified byte to this output stream
	
	public void write( int b )
	{	
		//If text is on a new line, creates a new String
		
		if ( b == '\n' )
		{
			final String text = stringBuilder.toString();
			
			SwingUtilities.invokeLater( new Runnable()
			{
				public void run()
				{
					textArea.append( text );
				}
            } );
			
            stringBuilder.setLength( 0 );
        }

        stringBuilder.append( ( char ) b );
    }
}