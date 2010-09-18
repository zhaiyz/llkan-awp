package com.zyz.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.zyz.control.AnimateThread;
import com.zyz.model.Line;
import com.zyz.model.Map;
import com.zyz.model.Match;
import com.zyz.model.Setting;

public class MapPanel extends JPanel implements MouseListener{

	private static final long serialVersionUID = 3466590739406451337L;
	
	private int width = 400;
	
	private int height = 300;
	
	private Point pre;
	
	boolean flag = true;
	
	private Border selectedBorder = BorderFactory.createLineBorder(Color.blue, 4);
	
	private Border overBorder = BorderFactory.createLineBorder(Color.yellow, 4);
	
	JButton[] dots = new JButton[Setting.ROW * Setting.COLUMN];
	
	public MapPanel() {
		this.setSize(width, height);
		
		 // ��Ʋ���
		GridLayout gridLayout = new GridLayout();

		gridLayout.setRows(Setting.ROW);

		gridLayout.setColumns(Setting.COLUMN);

		// ����������
		gridLayout.setHgap(0);

		// ���ú�����
		gridLayout.setVgap(0);

		this.setLayout(gridLayout);
		
		Map.init();
		
		// ���ð�ť
		for (int row = 0; row < Setting.ROW; row++) {

			for (int col = 0; col < Setting.COLUMN; col++) {

				int index = row * Setting.COLUMN + col;
                if (Map.map[row][col] != 0) {
                	Icon icon = null;
                	add(dots[index] = new JButton());
				    
				    icon = new ImageIcon(getClass().getResource("images/" + (Map.map[row][col] - 1) + ".JPG"));

					dots[index].setIcon(icon);
					dots[index].addMouseListener(this);
					dots[index].setActionCommand("" + index);
                } else {
                	add(dots[index] = new JButton());
                	dots[index].setVisible(false);
                }

			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		JButton button = (JButton) e.getSource(); 

		int offset = Integer.parseInt(button.getActionCommand()); 

		int row, col; 

		row = Math.round(offset / Setting.COLUMN); 

		col = offset - row * Setting.COLUMN;
		
		Point cur = new Point(row, col);
		
		if (pre == null) {
			pre = cur;
			dots[pre.x * Setting.COLUMN + pre.y].setBorder(selectedBorder);
		} else {
			dots[pre.x * Setting.COLUMN + pre.y].setBorder(null);
			Point p = new Point(pre.x, pre.y);
			pre = null;
			if (Match.checkLink(Map.map, p, cur)) {
				dots[p.x * Setting.COLUMN + p.y].removeMouseListener(this);
				dots[offset].removeMouseListener(this);
				LinkedList<Line> path = new LinkedList<Line>();
				path = Match.path;
				AnimateThread animate = new AnimateThread(path, dots, p, cur, offset, row, col);
				animate.start();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        
        int offset = Integer.parseInt(button.getActionCommand()); 
        if (pre == null || (pre.x * Setting.COLUMN + pre.y) != offset)
            dots[offset].setBorder(overBorder);        
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton button = (JButton) e.getSource();

		int offset = Integer.parseInt(button.getActionCommand());
		if (pre == null || (pre.x * Setting.COLUMN + pre.y) != offset)
		    dots[offset].setBorder(null);  
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	protected void paintComponent(Graphics g) {
		  super.paintComponent(g);
		  ImageIcon image = new ImageIcon(getClass().getResource("images/" + "java.jpg"));
		  image.paintIcon(this, g, 0, 0);
    }
	
	public void paint() {
		this.removeAll();
		this.repaint();
		Map.random(Map.map);
		for (int row = 0; row < Setting.ROW; row++) {

			for (int col = 0; col < Setting.COLUMN; col++) {

				int index = row * Setting.COLUMN + col;
                if (Map.map[row][col] != 0) {
                	Icon icon = null;
                	add(dots[index] = new JButton());
					
				    icon = new ImageIcon(getClass().getResource("images/" + (Map.map[row][col] - 1) + ".JPG"));

					dots[index].setIcon(icon);
					dots[index].addMouseListener(this);
					dots[index].setActionCommand("" + index);
                } else {
                	add(dots[index] = new JButton());
                	dots[index].setEnabled(false);
                	dots[index].setVisible(false);
                }

			}
			pre = null;
		}
	}
	
	public void restart() {
		this.removeAll();
		this.repaint();
		Map.init();
		for (int row = 0; row < Setting.ROW; row++) {

			for (int col = 0; col < Setting.COLUMN; col++) {

				int index = row * Setting.COLUMN + col;
                if (Map.map[row][col] != 0) {
                	Icon icon = null;
                	add(dots[index] = new JButton());
					
				    icon = new ImageIcon(getClass().getResource("images/" + (Map.map[row][col] - 1) + ".JPG"));

					dots[index].setIcon(icon);
					dots[index].addMouseListener(this);
					dots[index].setActionCommand("" + index);
                } else {
                	add(dots[index] = new JButton());
                	dots[index].setEnabled(false);
                	dots[index].setVisible(false);
                }

			}
			pre = null;
		}
	}
}
