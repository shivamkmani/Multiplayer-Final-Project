package battleShips;

import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ticTacToe.TTTDraw;

public class BattleShips extends Thread implements MouseListener {
	
	private boolean[][] myPoints = new boolean[10][10];
	
	//0 is blank, 1 is miss, 2 is hit
	private int[][] opponentPoints = new int[10][10];
	
	private BSDraw BSD;
	private JFrame frame;
	
	//how many points you have left to place
	private int pointsLeft;
	
	public BattleShips() {
		pointsLeft = 17;
	}
	
	public void run() {
		BSD = new BSDraw();
        frame = new JFrame("Battle Ships");
        frame.add(BSD);
        frame.pack();
        frame.setVisible(true);
        
        BSD.addMouseListener(this);
        
        BSD.updatePoints(myPoints, opponentPoints);
        BSD.repaint();
        
	}
	private void attack(int x, int y) {
		
	}
	
	private void place(int x, int y) {
		if(myPoints[x/30][y/30] == false) {
			myPoints[x/30][y/30] = true;	
			pointsLeft--;
			
			BSD.updatePoints(myPoints, opponentPoints);
	        BSD.repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(pointsLeft>0) {
			if(x>=450 && x<=750 && y>=450 && y<=750) {
				place(x-450, y-450);
			}
		} else {
			if(x>=50 && x<=350 && y>=50 && y<=350) {
				attack(x-50, y-50);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
