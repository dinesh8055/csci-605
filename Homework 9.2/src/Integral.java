/** 
 * Integral.java
 *
 * @ Version: 
 *     $Id: Integral.java , Version 1.0 10/26/2014 $ 
 * 
 * Revisions: 
 *     $Log Initial Version $ 
 */

import java.text.*;
import java.math.BigDecimal;

/**
 * The following class contains helper functions for calculating the integration
 *
 * @author      Dinesh Gudi
 * @author      Rithvik Gambhir 
 */

class IntegralFunctions {

/**
 * The following method calculates the z co-ordinate for the given x and y co-ordinate
 * 
 * @param 	x			Stores the x co-ordinate
 * @param 	y			Stores the y co-ordinate
 * 
 * @return				Returns the z co-ordinate
 */
	
	static BigDecimal calcZFor(BigDecimal x, BigDecimal y){
		return ((x.multiply(x)).add(y.multiply(new BigDecimal(2.0))));
	}
	
/**
 * The following method calculates the volume
 * 	
 * @param 	length		Stores the length
 * @param 	breadth		Stores the breadth
 * @param 	height		Stores the height
 * @return				Return the volume
 */
	
	static BigDecimal calcVol(BigDecimal length, BigDecimal breadth, BigDecimal height){
		return length.multiply(breadth.multiply(height));
	}
	
/**
 * The following method compares the two BigDecimals
 * 
 * @param 	b1			Stores the first BigDecimal
 * @param 	b2			Stores the first BigDecimal
 * @return				Returns the boolean value according to whichever is lesser
 */
	
	static boolean isLess(BigDecimal b1,BigDecimal b2){
		int retval = b1.compareTo(b2);
		if(retval<0) return true;
		else return false;
	}
}

/**
 * The following class calculates the integral of the plane in the positive z-axis
 *
 * @author      Dinesh Gudi
 * @author      Rithvik Gambhir 
 */

class PosIntegral extends IntegralFunctions implements Runnable {
	
	static BigDecimal gPosIntegral=new BigDecimal(0.0);
	static BigDecimal yNegIntegral=new BigDecimal(0.0);
	BigDecimal x;
	BigDecimal y;
	BigDecimal gridSize;
	PosIntegral t;
	BigDecimal[] b=new BigDecimal[2];
	PosIntegral() {
		gPosIntegral=gPosIntegral.valueOf(0.0);
		yNegIntegral=yNegIntegral.valueOf(0.0);
	}
	PosIntegral(BigDecimal x,BigDecimal y,BigDecimal gridSize){
		this.x=x;
		this.y=y;
		this.gridSize=gridSize;
	}

/**
 * The following run method runs the thread
 */
	
	public void run(){
		BigDecimal volume=new BigDecimal(0.0);
		BigDecimal z=calcZFor(x,y);
		volume=calcVol(gridSize,gridSize,z);
		if(isLess(z,new BigDecimal(0))) yNegIntegral=yNegIntegral.add(volume);
		else gPosIntegral=gPosIntegral.add(volume);
		DecimalFormat df = new DecimalFormat("#.##");
	}
/**
 * The following method calculates the integral
 * 
 * @param 	size			Stores the size of the grid to be considered
 * 		
 * @return					Returns the BigDecimal array
 */
	
	public BigDecimal[] calcPositiveIntegral(double size){
		BigDecimal gridSize=new BigDecimal(size);
		new PosIntegral();
		for(y=BigDecimal.valueOf(-2);isLess(y,new BigDecimal(2.0));y=y.add(gridSize)){
			for(x=BigDecimal.valueOf(-1);isLess(x,new BigDecimal(1.0));x=x.add(gridSize)){				
				t=new PosIntegral(x,y,gridSize);
				Thread t1 = new Thread(t);
				t1.start();
				try{

					t1.join();

				}
				catch (  InterruptedException e ) {
					e.printStackTrace();
				}
			}
			b[0]=gPosIntegral;
			b[1]=yNegIntegral;
		}
		return b;
	}
}

/**
 * The following class calculates the integral of the plane in the negative z-axis
 *
 * @author      Dinesh Gudi
 * @author      Rithvik Gambhir 
 */

class NegIntegral extends IntegralFunctions implements Runnable {
	static BigDecimal gNegIntegral=new BigDecimal(0.0);
	static BigDecimal yPosIntegral=new BigDecimal(0.0);
	BigDecimal m;
	BigDecimal n;
	BigDecimal o;
	BigDecimal gridSize;
	NegIntegral t;
	BigDecimal[] b=new BigDecimal[2];
	NegIntegral() {
		gNegIntegral=gNegIntegral.valueOf(0.0);
		yPosIntegral=yPosIntegral.valueOf(0.0);
	}
	NegIntegral(BigDecimal x,BigDecimal y,BigDecimal gridSize){
		this.m=x;
		this.n=y;
		this.gridSize=gridSize;
	}

/**
 * The following run method runs the thread
 */
	
	public void run(){
		BigDecimal volume=new BigDecimal(0.0);
		BigDecimal o=calcZFor(m,n);
		volume=calcVol(gridSize,gridSize,o);
		if(isLess(o,new BigDecimal(0.0))) gNegIntegral=gNegIntegral.add(volume);
		else yPosIntegral=yPosIntegral.add(volume);
	}
	
/**
 * The following method calculates the integral
 * 
 * @param 	size			Stores the size of the grid to be considered
 * 		
 * @return					Returns the BigDecimal array
 */
	
	public BigDecimal[] calcNegativeIntegral(double size){
		BigDecimal gridSize=new BigDecimal(size);
		new NegIntegral();
		for(n=BigDecimal.valueOf(2);isLess(new BigDecimal(-2),n);n=n.subtract(gridSize)){
			for(m=BigDecimal.valueOf(1);isLess(new BigDecimal(-1.0),m);m=m.subtract(gridSize)){
				t=new NegIntegral(m,n,gridSize);
				Thread t1 = new Thread(t);
				t1.start();
				try{

					t1.join();

				}
				catch (  InterruptedException e ) {
					e.printStackTrace();
				}
			}
			b[0]=gNegIntegral;
			b[1]=yPosIntegral;
		}
		return b;
	}
}

/**
 * The following class contains the main() method
 *
 * @author      Dinesh Gudi
 * @author      Rithvik Gambhir 
 */

public class Integral{

/**
 * The following method creates objects to the other classes defined above
 * The volumes obtained above are then compared with the delta value to reduce error
 * 
 * @param 	args				Not used anywhere
 */
	
	public static void main(String [] args){
		double delta = 0.01;
		PosIntegral pos_integral=new PosIntegral();
		NegIntegral neg_integral=new NegIntegral();
		BigDecimal yellowIntegral=new BigDecimal(0.0);
		BigDecimal greenIntegral=new BigDecimal(0.0);
		BigDecimal[] b1;
		BigDecimal[] b2;
		BigDecimal yellowVolume;
		BigDecimal greenVolume;
		double green;
		double yellow;
		double size=0.1;
		int iterationCount = 0;
		do{
			b1=pos_integral.calcPositiveIntegral(size);
			b2=neg_integral.calcNegativeIntegral(size);
			size=size/2;
			greenVolume = b1[0].add(b2[0]);
			yellowVolume = b1[1].add(b2[1]);
			green = greenVolume.doubleValue();
			yellow = yellowVolume.doubleValue();
			System.out.println("Iteration Number " + iterationCount);
			System.out.println("Maximum volume " + yellow);
			System.out.println("Minimum volume " + green);
			System.out.println();
			iterationCount++;
		} while(Math.abs(yellow - green) > delta);
		System.out.println("Finally, volume is " + (yellow+green)/2);
		System.out.println("The error is " + (Math.abs(yellow - green)));
	}
}