
/*
 * TCSS 598A
 * Fall 2015
 * Credit to : https://github.com/vbohush/SortingAlgorithmAnimations
 * Edited Version by Viet Nguyen
 * 
 */

package Sorts;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class QuickSortPanel extends SortPanel {
	private static final long serialVersionUID = 1L;
	private int redColumn = -1;
	private int blueColumn = -1;
	private int cyanColumn = -1;
	private int greenColumn = -1;
	
	public QuickSortPanel(String name, int sleepTime, int width, int height) {
		super(name, sleepTime, width, height);
	}

	@Override
	public void reset() {
		redColumn = -1;
		blueColumn = -1;
		greenColumn = -1;
		cyanColumn = -1;
	}

	@Override
	public void run() {
		try {
			quickSort(0, list.length - 1);			
		} catch (InterruptedException e) {
		}
		redColumn = -1;
		blueColumn = -1;
		cyanColumn = -1;
		greenColumn = size - 1;
		repaint();
	}
	
	private void quickSort(int start, int end) throws InterruptedException {
		
		// mine
		if (start < end) {
			int pivot = end;
			redColumn = pivot;
			int current = start;
			blueColumn = current;
			cyanColumn = pivot - 1;
			Thread.sleep(sleepTime);
			repaint();
			while (current < pivot) {
				if (list[current] < list[pivot]) {
					current ++;
					blueColumn = current;
					redColumn = pivot;
					Thread.sleep(4*sleepTime);
					repaint();
				}
				else {
					int temp = list[pivot];
					list[pivot] = list[current];
					blueColumn = pivot;
					Thread.sleep(4*sleepTime);
					repaint();
					pivot--;
					list[current] = list[pivot];
					list[pivot] = temp;
					
					cyanColumn = current;					
					redColumn = pivot;
					Thread.sleep(4*sleepTime);
					repaint();
					
				}
			}
			// recursive left piece
			quickSort(start, current - 1);
			// recursive right piece
			quickSort( current + 1, end);
		}
		
		/*
		
		
		int i = low;
		int j = high;
		Thread.sleep(sleepTime);
		repaint();
		int pivot = list[low + (high - low) / 2];
		redColumn = low + (high - low) / 2;
		
		while (i <= j) {
			while (list[i] < pivot) {
				i++;
				blueColumn = i;
				Thread.sleep(4 * sleepTime);
				repaint();
			}
			while (list[j] > pivot) {
				j--;
				cyanColumn = j;
				Thread.sleep(4 * sleepTime);
				repaint();
			}

			if (i <= j) {
				int temp = list[i];
				list[i] = list[j];
				list[j] = temp;
				if(i == redColumn) {
					redColumn = j;
				} else if (j == redColumn) {
					redColumn = i;
				}
				Thread.sleep(4 * sleepTime);
				repaint();
				i++;
				j--;
			}
		}

		if (low < j) {
			quicksort(low, j);
		}
		if (i < high) {
			quicksort(i, high);
		}
		if(low > greenColumn) {
			greenColumn = low;
			blueColumn = -1;
			cyanColumn = -1;
		}
		repaint(); 
		*/
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
		if(blueColumn != -1) {
			g.setColor(Color.YELLOW);
			g.fillRect(2 * BORDER_WIDTH + columnWidth * blueColumn, getHeight() - list[blueColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[blueColumn] * columnHeight);
			g.setColor(Color.WHITE);
			g.drawRect(2 * BORDER_WIDTH + columnWidth * blueColumn, getHeight() - list[blueColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[blueColumn] * columnHeight);
		}
		if(cyanColumn != -1) {
			g.setColor(Color.BLUE);
			g.fillRect(2 * BORDER_WIDTH + columnWidth * cyanColumn, getHeight() - list[cyanColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[cyanColumn] * columnHeight);
			g.setColor(Color.WHITE);
			g.drawRect(2 * BORDER_WIDTH + columnWidth * cyanColumn, getHeight() - list[cyanColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[cyanColumn] * columnHeight);
		}
		
		Font nameFont = new Font(Font.MONOSPACED, Font.BOLD, 18);
		FontMetrics nameFontMetrix = getFontMetrics(nameFont);		
		g.setColor(Color.BLUE);
		g.setFont(nameFont);
	//	g.drawString("TCSS 598A:" + "Quick Sort", (getWidth() - nameFontMetrix.stringWidth("Quick Sort")) / 2 -230, BORDER_WIDTH + nameFontMetrix.getAscent() / 3);



	}

}
