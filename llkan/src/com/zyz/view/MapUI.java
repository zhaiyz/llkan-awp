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

	    // ��Ʋ���
		GridLayout gridLayout = new GridLayout();

		gridLayout.setRows(Setting.ROW);

		gridLayout.setColumns(Setting.COLUMN);

		// ����������
		gridLayout.setHgap(2);

		// ���ú�����
		gridLayout.setVgap(2);

		this.setLayout(gridLayout);

		// ���ð�ť
		for (int row = 0; row < Setting.ROW; row++) {

			for (int col = 0; col < Setting.COLUMN; col++) {

				int index = row * Setting.COLUMN + col;
                if (Map.map[row][col] != 0) {
                	String name = "";
                	switch (Map.map[row][col]) {
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
                		case 5:
                			name = "С��";
                			break;
                		case 6:
                			name = "���";
                			break;
                		case 7:
                			name = "С��";
                			break;
                		case 8:
                			name = "����";
                			break;
                		case 9:
                			name = "����";
                			break;
                		case 10:
                			name = "���";
                			break;
                		case 11:
                			name = "��ү";
                			break;
                		case 12:
                			name = "����";
                			break;
                		case 13:
                			name = "ѧ��";
                			break;
                		case 14:
                			name = "ѧΰ";
                			break;
                		case 15:
                			name = "���";
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
