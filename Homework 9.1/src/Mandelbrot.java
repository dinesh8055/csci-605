// original from: http://rosettacode.org/wiki/Mandelbrot_set#Java
// modified for color

import java.awt.Color;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
 
public class Mandelbrot extends JFrame {
 
    private final int MAX = 5000;
    private final int LENGTH   = 800;
    private final double ZOOM  = 1000;
    private BufferedImage I;
    private double zx, zy, cX, cY, tmp;
    private int[] colors = new int[MAX];
 
    public Mandelbrot() {
        super("Mandelbrot Set");
        initColors();
        setBounds(100, 100, LENGTH, LENGTH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void initColors() {
        for (int index = 0; index < MAX; index++) {
            colors[index] = Color.HSBtoRGB(index/256f, 1, index/(index+8f));
        }
    }

/**
 * The following method creates the threads 
 */
    
    public void createSet()	{
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
    		      new DrawIt(x, y).start();
        	}
		}
	}

/**
 * The following class contains a constructor to initialize arguments 
 *
 * @author      Dinesh Gudi
 * @author      Rithvik Gambhir 
 */
    
    class DrawIt extends Thread {
    	int x;
    	int y;
    	
    	public DrawIt (int x, int y) {
            this.x = x;
            this.y = y;
    	}
    	
/**
 * The following run method is called multiple times from createSet() thus making the
 * given program multi-threaded
 * It puts in the required colors and repaint() is called
 */
    	
    	public void run() {
    		zx = zy = 0;
            cX = (x - LENGTH) / ZOOM;
            cY = (y - LENGTH) / ZOOM;
            int iter = 0;
            while ( (zx * zx + zy * zy < 4 ) && ( iter < MAX - 1 ) ) {
                tmp = zx * zx - zy * zy + cX;
                zy = 2.0 * zx * zy + cY;
                zx = tmp;
                iter++;
            }
            if ( iter > 0 )
            	I.setRGB(x, y, colors[iter]);
            else
            	I.setRGB(x, y, iter | (iter << 8));
            repaint();
    	}
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }
    
    public static void main(String[] args) {
        Mandelbrot aMandelbrot = new Mandelbrot();
        aMandelbrot.setVisible(true);
        aMandelbrot.createSet();
    }
}