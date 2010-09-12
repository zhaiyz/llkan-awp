package com.zyz.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.zyz.model.Map;
import com.zyz.model.Match;
import com.zyz.model.Setting;

public class MapPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 3466590739406451337L;
	
	private int width = 400;
	
	private int height = 300;
	
	private Point pre;
	
	JButton[] dots = new JButton[Setting.ROW * Setting.COLUMN];
	
	public MapPanel() {
		this.setSize(width, height);
		this.setBackground(Color.RED);
		
		 // ��Ʋ���
		GridLayout gridLayout = new GridLayout();

		gridLayout.setRows(Setting.ROW);

		gridLayout.setColumns(Setting.COLUMN);

		// ����������
		gridLayout.setHgap(2);

		// ���ú�����
		gridLayout.setVgap(2);

		this.setLayout(gridLayout);
		
		Map map = new Map();
		map.init();
		
		// ���ð�ť
		for (int row = 0; row < Setting.ROW; row++) {

			for (int col = 0; col < Setting.COLUMN; col++) {

				int index = row * Setting.COLUMN + col;
                if (Map.map[row][col] != 0) {
                	String name = "";
                	Icon icon = null;
                	switch (Map.map[row][col] - 1) {
                		case 0:
                			name = "����";
                			break;
                		case 1:
                			name = "�ɸ�";
                			break;
                		case 2:
                			name = "�೤";
                			break;
                		case 3:
                			name = "����";
                			break;
                		case 4:
                			name = "С��";
                			break;
                		case 5:
                			name = "���";
                			break;
                		case 6:
                			name = "С��";
                			break;
                		case 7:
                			name = "����";
                			break;
                		case 8:
                			name = "����";
                			break;
                		case 9:
                			name = "���";
                			break;
                		case 10:
                			name = "��ү";
                			break;
                		case 11:
                			name = "����";
                			break;
                		case 12:
                			name = "ѧ��";
                			break;
                		case 13:
                			name = "ѧΰ";
                			break;
                		case 14:
                			name = "���";
                			break;
                		default:
                			name = "";
                	}
                	
                	add(dots[index] = new JButton());
					
				    if ("".equals(name)) {
				    	dots[index].setVisible(false);
				    } else {
				    	icon = new ImageIcon(getClass().getResource("images/" + (Map.map[row][col] - 1) + ".JPG"));
	        			
					    dots[index].setIcon(icon);
					    dots[index].addActionListener(this);
					    dots[index].setActionCommand("" + index);
				    }
                } else {
                	add(dots[index] = new JButton());
                	dots[index].setVisible(false);
                }

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource(); 

		int offset = Integer.parseInt(button.getActionCommand()); 

		int row, col; 

		row = Math.round(offset / Setting.COLUMN); 

		col = offset - row * Setting.COLUMN;
		
		Point cur = new Point(row, col);
		
		if (pre == null) {
			pre = cur;
		} else {
			if (Match.checkLink(Map.map, cur, pre)) {
				System.out.println("-------------��������-------------");
				System.out.println("pre[" + pre.x + "][" + pre.y + "]=" + Map.map[pre.x][pre.y]);
				System.out.println("cur[" + cur.x + "][" + cur.y + "]=" + Map.map[cur.x][cur.y]);
				dots[offset].setVisible(false);
				dots[pre.x * Setting.COLUMN + pre.y].setVisible(false);
				Map.map[row][col] = 0;
				Map.map[pre.x][pre.y] = 0;
			} else {
				System.out.println("-------------��������-------------");
				System.out.println("pre[" + pre.x + "][" + pre.y + "]=" + Map.map[pre.x][pre.y]);
				System.out.println("cur[" + cur.x + "][" + cur.y + "]=" + Map.map[cur.x][cur.y]);
			}
			pre = null;
		}
	}
}
