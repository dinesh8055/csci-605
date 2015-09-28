/**
 * This class implements a point test program.
 *
 * @version   $Id$
 *
 * @author    hp bischof
 *
 * Revisions:
 *	$Log$
 */

	    

public class TestPoint {
  private static Point aPoint;


/**
  * The main program.
  *
  * @param    args    command line arguments (ignored)
  */
  public static void main(String args[])
  {
	System.out.println("Point.soManyPoints = " + Point.soManyPoints() );
	aPoint = new Point(2, 3);
	System.out.println("x = " + aPoint.getX() );
	System.out.println("y = " + aPoint.getY() );

	aPoint = new Point();
	aPoint.initPoint(4, 5);
	System.out.println("x = " + aPoint.getX() );
	System.out.println("y = " + aPoint.getY() );

	aPoint.move(6, 7);
	System.out.println("x = " + aPoint.getX() );
	System.out.println("y = " + aPoint.getY() );

	System.out.println("nPoints = " + aPoint.getNPoints() );
	System.out.println("aPoint.soManyPoints = " + aPoint.soManyPoints() );
  }
}




