package snakeBikes;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class SnakeBikes extends Thread implements KeyListener {
	
	ArrayList<Point> points = new ArrayList();
	ArrayList<Point> opponentPoints = new ArrayList();
	
	private double angle = 0.0;
	private int speed = 5;
	
	public void run() {
		SBDraw SBD = new SBDraw();
        JFrame frame = new JFrame("SnakeBikes");
        frame.add(SBD);
        frame.pack();
        frame.setVisible(true);
        
        frame.addKeyListener(this);
        
        points.add(new Point(600, 700));
        
        boolean b = true;
        for(int c=0; b; c++) {
        	try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        	if(c%2==1) {
        		points.remove(0);
        	}

        	
        	Point lastPoint = points.get(points.size()-1);
        	int changeX, changeY;
        	changeX = (int) (Math.sin(angle)*speed);
        	changeY = (int) (Math.cos(angle)*speed);
        	
        	points.add(new Point(lastPoint.x-changeX, lastPoint.y-changeY));
        	
        	int search = 2;
        	
        	//test collision
        	if(points.size()>5) {
	        	Point thePoint = points.get(points.size()-1);
	        	for(int i = points.size()-2; i >= 0; i--) {
	        		Point testPoint = points.get(i);
	        		if((thePoint.x > testPoint.x - search) && (thePoint.x < testPoint.x + search) && (thePoint.y > testPoint.y - search) && (thePoint.x < testPoint.x + search)){
	        			b = false;
	        		}
	        	}
        	}
        	
        	SBD.setPoints(points, opponentPoints, c);
        	SBD.repaint();
        }
	}
	public void updateOpponent(Point newPoint) {
		opponentPoints.add(newPoint);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if(keycode==KeyEvent.VK_A) {
			angle = angle + (Math.PI*0.0625);
		}
		if(keycode==KeyEvent.VK_D) {
			angle = angle - (Math.PI*0.0625);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}