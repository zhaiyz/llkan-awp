package com.zyz.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.zyz.model.Map;
import com.zyz.model.Setting;

public class MapPanel extends JPanel {

	private static final long serialVersionUID = 3466590739406451337L;
	
	private int width = 400;
	
	private int height = 300;
	
	JButton[] dots = new JButton[Setting.ROW * Setting.COLUMN];
	
	public MapPanel() {
		this.setSize(width, height);
		this.setBackground(Color.RED);
		
		 // 设计布局
		GridLayout gridLayout = new GridLayout();

		gridLayout.setRows(Setting.ROW);

		gridLayout.setColumns(Setting.COLUMN);

		// 设置纵向间距
		gridLayout.setHgap(2);

		// 设置横向间距
		gridLayout.setVgap(2);

		this.setLayout(gridLayout);
		
		Map map = new Map();
		map.init();
		
		// 放置按钮
		for (int row = 0; row < Setting.ROW; row++) {

			for (int col = 0; col < Setting.COLUMN; col++) {

				int index = row * Setting.COLUMN + col;
                if (map.getMap()[row][col] != 0) {
                	String name = "";
                	switch (map.getMap()[row][col] - 1) {
                		case 0:
                			name = "超哥";
                			break;
                		case 1:
                			name = "飞哥";
                			break;
                		case 2:
                			name = "班长";
                			break;
                		case 3:
                			name = "亚周";
                			break;
                		case 4:
                			name = "小彬";
                			break;
                		case 5:
                			name = "汊港";
                			break;
                		case 6:
                			name = "小罗";
                			break;
                		case 7:
                			name = "玉书";
                			break;
                		case 8:
                			name = "吴政";
                			break;
                		case 9:
                			name = "李聪";
                			break;
                		case 10:
                			name = "少爷";
                			break;
                		case 11:
                			name = "曾哥";
                			break;
                		case 12:
                			name = "学钊";
                			break;
                		case 13:
                			name = "学伟";
                			break;
                		case 14:
                			name = "李皓";
                			break;
                		default:
                			name = "";
                	}
				    add(dots[index] = new JButton(name));
				    if ("".equals(name)) {
				    	dots[index].setVisible(false);
				    }
                } else {
                	add(dots[index] = new JButton(""));
                	dots[index].setVisible(false);
                }

			}
		}
	}

}
