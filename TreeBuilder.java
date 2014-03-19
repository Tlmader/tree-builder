/* TreeBuilder.java
*
*  Description: This class contains the main() method that creates a model, a view, and a controller, passing the
*				model and the view to the controller.
*
*  Author: Ted Mader, 3/13/2014
*/

public class TreeBuilder
{
	public static void main( String[] args )
	{
		TreeBuilderModel model = new TreeBuilderModel();
		TreeBuilderView view = new TreeBuilderView();
		TreeBuilderController controller = new TreeBuilderController( model, view );
	}
}