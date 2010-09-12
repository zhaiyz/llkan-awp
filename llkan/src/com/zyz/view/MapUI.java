package com.zyz.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.zyz.model.Map;
import com.zyz.model.Setting;

public class MapUI extends JPanel{ 

	private static final long serialVersionUID = 7588984409785301139L;
	
	JButton[] dots = new JButton[Setting.ROW * Setting.COLUMN]; 
	
	public MapUI(Map map) { 

	    // 设计布局
		GridLayout gridLayout = new GridLayout();

		gridLayout.setRows(Setting.ROW);

		gridLayout.setColumns(Setting.COLUMN);

		// 设置纵向间距
		gridLayout.setHgap(2);

		// 设置横向间距
		gridLayout.setVgap(2);

		this.setLayout(gridLayout);

		// 放置按钮
		for (int row = 0; row < Setting.ROW; row++) {

			for (int col = 0; col < Setting.COLUMN; col++) {

				int index = row * Setting.COLUMN + col;
                if (Map.map[row][col] != 0) {
                	String name = "";
                	switch (Map.map[row][col]) {
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
                		case 5:
                			name = "小彬";
                			break;
                		case 6:
                			name = "汊港";
                			break;
                		case 7:
                			name = "小罗";
                			break;
                		case 8:
                			name = "玉书";
                			break;
                		case 9:
                			name = "吴政";
                			break;
                		case 10:
                			name = "李聪";
                			break;
                		case 11:
                			name = "少爷";
                			break;
                		case 12:
                			name = "曾哥";
                			break;
                		case 13:
                			name = "学钊";
                			break;
                		case 14:
                			name = "学伟";
                			break;
                		case 15:
                			name = "李皓";
                			break;
                		default:
                			name = "";
                	}
				    add(dots[index] = new JButton(name));
                } else
                	add(dots[index] = new JButton(""));

			}
		}
	}
}
