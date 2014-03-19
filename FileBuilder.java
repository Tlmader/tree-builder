import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileBuilder
{

    public static void main( String[] args )
    {
		ArrayList<String> arrayList;
		String[] integers;
		
		ObjectOutputStream objectWriter;
		ObjectInputStream objectReader;
		BufferedReader bufferedReader;
	
		integers = new String[] { "404", "9000", "256", "1024", "2120" };
		arrayList = new ArrayList<String>( Arrays.asList( integers ) );
		
		try
		{
			objectWriter = new ObjectOutputStream( new FileOutputStream( "outputFile.ser" ) );
			objectWriter.writeObject( arrayList );
			objectWriter.close();
		}
		catch( IOException e )
		{
			System.out.println( "Could not create file" ); 
		}
	}
}