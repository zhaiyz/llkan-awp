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
                if (map.getMap()[row][col] != 0) {
                	String name = "";
                	switch (map.getMap()[row][col] - 1) {
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
