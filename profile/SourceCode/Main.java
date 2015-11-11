/*
 * TCSS 598A
 * Fall 2015
 * Credit to : https://github.com/vbohush/SortingAlgorithmAnimations
 * Edited Version by Viet Nguyen
 * 
 */



package Sorts;

import javax.swing.*;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//Visualization and Comparison of Sorting Algorithms
public class Main extends JApplet {

	private static final long serialVersionUID = 1L;
	private SortPanel[] sortPanels = new SortPanel[9];
	private static int size = 20;
	private int sleepTime = 100;
	private String animationName = "";

	public Main() {
		setLayout(new GridLayout(1, 1, 0, 0));
		SortPanelsHolder sortPanelHolder = new SortPanelsHolder();
		sortPanelHolder.setLayout(new  GridLayout(0, 1, 0, 0));
		//sortPanelHolder.setBackground(Color.BLUE);
	//	sortPanelHolder.setForeground(Color.WHITE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width / 3;
		int height = screenSize.height / 3;
		sortPanels[0] = new SelectionSortPanel(" Selection Sort ", sleepTime, width, height);
	//	sortPanels[0] = new InsertionSortPanel(" Insertion Sort ", sleepTime, width, height);
	//	sortPanels[0] = new BubbleSortPanel(" Bubble Sort ", sleepTime, width, height);
	//	sortPanels[0] = new MergeSortPanel(" Merge Sort ", sleepTime, width, height);
	//	sortPanels[0] = new QuickSortPanel(" Quick Sort ", sleepTime, width, height);

		
		
	//	for (int i = 0; i < sortPanels.length; i++) {
			sortPanels[0].setVisible(false);
			sortPanelHolder.add(sortPanels[0]);				
	//	}
		add(sortPanelHolder);
	}
	
	class SortPanelsHolder extends JPanel {
		private static final long serialVersionUID = 1L;
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.WHITE);
			Font animationNameFont = new Font(Font.MONOSPACED, Font.BOLD, 150);
			FontMetrics animationNameFontFontMetrix = getFontMetrics(animationNameFont);
			g.setFont(animationNameFont);
			int x = (getWidth() - animationNameFontFontMetrix.stringWidth(animationName)) / 2;
			int y = (getHeight() - animationNameFontFontMetrix.getLeading()) / 2;
			g.drawString(animationName, x, y);
		}
	}
	
	public void beginAnimation(String animationName, int[] list) {
		try {
			Thread.sleep(4000);
		//	this.animationName = animationName;
		//	repaint();
		//	Thread.sleep(2000);
		//	this.animationName = "";
		//	repaint();
		//	for (int i = 0; i < sortPanels.length; i++) {
				sortPanels[0].setList(list);
				sortPanels[0].setVisible(true);
		//	}
			Thread.sleep(1000);
			ExecutorService executor = Executors.newFixedThreadPool(1);//sortPanels.length);
			for (int i = 0; i < 1; i++) {
				executor.execute(sortPanels[i]);
			}
			executor.shutdown();
			while(!executor.isTerminated()) {
				Thread.sleep(100);
			}
			Thread.sleep(1000);
		//	for (int i = 0; i < sortPanels.length; i++) {
				sortPanels[0].setVisible(false);
		//	}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Sorting Algorithm Animations");
		Main main = new Main();
		frame.add(main);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		int[] list = new int[size];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = i + 1;
		}
	/*	for (int i = 0; i < list.length; i++) {
			int index = (int) (Math.random() * list.length);
			int temp = list[i];
			list[i] = list[index];
			list[index] = temp;
		}*/
		// pyramid
/*		int temp1 = 2;
		for (int i = 0; i < 10; i ++) {
			list[i] = temp1;
			temp1 +=2;
		}
		temp1 = 0;
		for (int i = 10; i < 20; i ++) {
			list[i] = 20 - temp1;
			temp1 += 2;
		}*/
		
		// Downtown - unique and random 
/*		list[0] = 14;
		list[1] = 16;
		list[2] = 14;
		list[3] = 3;
		list[4] = 3;
		list[5] = 6;
		list[6] = 7;
		list[7] = 5;
		list[8] = 3;
		list[9] = 10;
		list[10] = 20;
		list[11] = 18;
		list[12] = 3; list[13] = 12; list[14] = 4;list[15] = 3;list[16] = 3; list[17] = 7;list[18] = 7;list[19] = 4;
		*/
		// sorted stair
		list[0] = 2;
	    list[1] = 2;
	    list[2] = 2;
	    list[3] = 2;
	    
		for (int i = 4; i < 20; i+=4) {
			list[i] = i + 2;
			if (i == 19) break;
			list[i+1] = i + 2;
			list[i+2] = i + 2;
			list[i+3] = i + 2;
		}
		main.beginAnimation("Random", list);
		
/*		for (int i = 0; i < list.length; i++) {
			list[i] = (1 + i / (size / 4) ) * (size / 4);
		}
		for (int i = 0; i < list.length; i++) {
			int index = (int) (Math.random() * list.length);
			int temp = list[i];
			list[i] = list[index];
			list[index] = temp;
		}*/
	}
}