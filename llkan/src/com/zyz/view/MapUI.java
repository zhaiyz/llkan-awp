package com.zyz.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.zyz.model.Map;
import com.zyz.model.Setting;

public class MapUI extends JPanel{ 

	private static final long serialVersionUID = 7588984409785301139L;
	
	JButton[] dots = new JButton[Setting.ROW * Setting.COLUMN]; 
	
	public MapUI() { 

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
                if (map.getMap()[row][col] != 0)
				    add(dots[index] = new JButton("" + map.getMap()[row][col]));
                else
                	add(dots[index] = new JButton(""));

			}
		}
	}
}
