/**
 * This class implements a point in a two dimensional
 * area.
 * All method print when they are called.
 *
 * @version   $Id$
 *
 * @author    hp bischof
 *
 * Revisions:
 *	$Log$
 */

public class Point {
				// class variable
  static int nPoints;		// so many points were created.

  private int x;		// x coordinate of the point
  private int y;		// y cooridnate of the point

/**
 * Default Constructor.
 * Increases the counter nPoints by 1.
 *
 * @return	      Point a Point object
 */
  public Point(){
	super();
	System.out.println("	in Point() constructor");
	nPoints ++;
  }

/**
 * Constructor.
 * initialize x and y values of a point
 *
 * @param       x	x coordinate
 * @param       y	y coordinate
 *
 * @return	      Point a Point object
 */
  public Point(int x, int y){
	super();
	int i; 
	//i++;
	this.x = x;
	this.y = y;
	System.out.println("	in Point(int, int) constructor");
  }

/**
 * So many points have been created.
 *
 * @return int So many points have been created
 */
  public static int soManyPoints(){
  	return nPoints;
  }

/**
 * initialzes x and y of a point.
 *
 * @param       x	int x coordinate
 * @param       y	int y coordinate
 *
 * @return	      Point a Point object
 */
  public Point initPoint(int x, int y){
	System.out.println("	in initPoint(int, int)");

	this.x = x;
	this.y = y;

	return this;
  }

/**
 * move a point
 *
 * @param       x	int delta x value
 * @param       y	int delta y value
 *
 * @return	      Point a Point object
 */
  public Point move(int x, int y){
	System.out.println("	in move(int, int)");

	this.x += x;
	this.y += y;

	return this;
  }

/**
 * Returns the x coordinate of a point
 *
 * @return	      int x value 
 */
  public int getX(){
	System.out.println("	in getX()");
	return this.x;
  }

/**
 * Returns the y coordinate of a point
 *
 * @return	      int x value 
 */
  public int getY(){
	System.out.println("	in getY()");
	return this.y;
  }

/**
 * Returns how many points are created so far.
 *
 * @return	      int nPoints 
 */
  public int getNPoints(){
	System.out.println("	in getNPoints()");
	return this.nPoints;
  }
}
