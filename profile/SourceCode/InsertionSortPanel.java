
/*
 * TCSS 598A
 * Fall 2015
 * Credit to : https://github.com/vbohush/SortingAlgorithmAnimations
 * Edited Version by Viet Nguyen
 * 
 */


package Sorts;

import java.awt.Color; 
import java.awt.Graphics;

public class InsertionSortPanel extends SortPanel {
	private static final long serialVersionUID = 1L;
	private int redColumn = -1;
	private int greenColumn = -1;
	
	public InsertionSortPanel(String name, int sleepTime, int width, int height) {
		super(name, sleepTime, width, height);
	}

	@Override
	public void reset() {
		redColumn = -1;
		greenColumn = -1;		
	}

	@Override
	public void run() {
		
		for (int i = 0; i < list.length; i++) {
			
	
			int j = i;
			redColumn = j;
			repaint();
			
			try {
				Thread.sleep(4 * sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while (j > 0) {
				if (list[j] > (list[j-1]) ) {
					break;
				} else {
					try {
						Thread.sleep(3 * sleepTime);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					repaint();
					redColumn = j;
					repaint();
					
					try {
						Thread.sleep(4 * sleepTime);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					int temp = list[j-1];
					list[j-1] = list[j];
					list[j] = temp;
					j--;
				}
				
			}
			if (i < list.length)
			redColumn = i + 1;
			repaint();
		}
		
		/*try {
			for (int i = 1; i < list.length; i++) {
				greenColumn = i;
				redColumn = greenColumn;
				int k;
				for (k = i - 1; k >= 0 && list[k] > list[k + 1]; k--) {
					Thread.sleep(3 * sleepTime);
					repaint();
					redColumn = k + 1;
					repaint();
					Thread.sleep(4 * sleepTime);
					int tmp = list[k + 1]; 
					list[k + 1] = list[k];
					list[k] = tmp;
				}
				redColumn = k + 1;
				repaint();
			}
			redColumn = -1;
		} catch (InterruptedException e) {
		}*/
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int columnWidth = (getWidth() - 4 * BORDER_WIDTH) / size;
		int columnHeight = (getHeight() - 4 * BORDER_WIDTH) / size;
		for (int i = (greenColumn == -1 ? 0 : greenColumn); i < list.length; i++) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
			g.setColor(Color.WHITE);
			g.drawRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);			
		}
		for (int i = 0; i <= greenColumn; i++) {
			g.setColor(Color.BLACK);
			g.fillRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
			g.setColor(Color.WHITE);
			g.drawRect(2 * BORDER_WIDTH + columnWidth * i, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);			
		}
		if(redColumn != -1) {
			g.setColor(Color.RED);
			g.fillRect(2 * BORDER_WIDTH + columnWidth * redColumn, getHeight() - list[redColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[redColumn] * columnHeight);
			g.setColor(Color.WHITE);
			g.drawRect(2 * BORDER_WIDTH + columnWidth * redColumn, getHeight() - list[redColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[redColumn] * columnHeight);
		}
	}

}
