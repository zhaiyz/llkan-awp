package com.zyz.control;

import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JButton;

import com.zyz.model.Line;
import com.zyz.model.Map;
import com.zyz.model.Setting;

public class AnimateThread extends Thread {
	private LinkedList<Line> path;
	
	private JButton[] dots;
	
	private Point pre;
	
	private Point cur;
	
	private int offset;
	
	private int row;
	
	private int col;
	
	private Long time = 50L;
	public AnimateThread (LinkedList<Line> path, JButton[] dots, Point pre, Point cur, int offset, int row, int col) {
		this.path = path;
		this.dots = dots;
		this.pre = pre;
		this.cur = cur;
		this.offset = offset;
		this.row = row;
		this.col = col;
	}
	public void run() {
		// Ҫ���������·������ʾ
		for(int i=0; i<path.size(); i++) {
			Point a = path.get(i).getA();
			Point b = path.get(i).getB();
			int direct = path.get(i).getDirect();
			try {
				if (direct == 1) {
					// ����Ǻ��ߣ����������X��ȣ��Ǿ� Ҫ�����������߻�����������
					if (a.y < b.y) {
						// ���˵A����B�����ߣ���·�ϵİ�ť��ʾ����
						for (int j = a.y; j <= b.y; j++) {
							Point temp = new Point(a.x, j);
							if (temp.equals(pre) || temp.equals(cur)) {
								// ���˵����ǰ·���ϵĵ�ΪҪ���ӵĵ㣬�Ͳ�������
							} else {
								int index = a.x * Setting.COLUMN + j;
								dots[index].setIcon(null);
								dots[index].setVisible(true);
								AnimateThread.sleep(time);
							}
						}
					} else {
						// ���˵A����B����ұߣ���·�ϵİ�ť��ʾ����
						for (int j = a.y; j >= b.y; j--) {
							Point temp = new Point(a.x, j);
							if (temp.equals(pre) || temp.equals(cur)) {
								// ���˵����ǰ·���ϵĵ�ΪҪ���ӵĵ㣬�Ͳ�������
							} else {
								int index = a.x * Setting.COLUMN + j;
								dots[index].setIcon(null);
								dots[index].setVisible(true);
								AnimateThread.sleep(time);
							}
						}
					}
				} else {
					// ���˵�Ǹ����ߣ��Ǿ���˵���ǵ�Y��ȣ������������߻���������
					if (a.x < b.x) {
						// ���˵A����B��� �ϱߣ���·�ϵİ�ť��ʾ����
						for (int j = a.x; j <= b.x; j++) {
							Point temp = new Point(j, a.y);
							if (temp.equals(pre) || temp.equals(cur)) {
								// ���˵����ǰ·���ϵĵ�ΪҪ���ӵĵ㣬�Ͳ�������
							} else {
								int index = j * Setting.COLUMN + a.y;
								dots[index].setIcon(null);
								dots[index].setVisible(true);
								AnimateThread.sleep(time);
							}
						}
					} else {
						// ���˵A����B����±ߣ���·�ϵİ�ť��ʾ����
						for (int j = a.x; j >= b.x; j--) {
							Point temp = new Point(j, a.y);
							if (temp.equals(pre) || temp.equals(cur)) {
								// ���˵����ǰ·���ϵĵ�ΪҪ���ӵĵ㣬�Ͳ�������
							} else {
								int index = j * Setting.COLUMN + a.y;
								dots[index].setIcon(null);
								dots[index].setVisible(true);
								AnimateThread.sleep(time);
							}
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < path.size(); i++) {
			Point a = path.get(i).getA();
			Point b = path.get(i).getB();
			int direct = path.get(i).getDirect();
			if (direct == 1) {
				// ����Ǻ��ߣ����������X��ȣ��Ǿ� Ҫ�����������߻�����������
				if (a.y < b.y) {
					// ���˵A����B�����ߣ���·�ϵİ�ť��ʾ����
					for (int j = a.y; j <= b.y; j++) {
						Point temp = new Point(a.x, j);
						if (temp.equals(pre) || temp.equals(cur)) {
							// ���˵����ǰ·���ϵĵ�ΪҪ���ӵĵ㣬�Ͳ�������
						} else {
							int index = a.x * Setting.COLUMN + j;
							dots[index].setVisible(false);
						}
					}
				} else {
					// ���˵A����B����ұߣ���·�ϵİ�ť��ʾ����
					for (int j = a.y; j >= b.y; j--) {
						Point temp = new Point(a.x, j);
						if (temp.equals(pre) || temp.equals(cur)) {
							// ���˵����ǰ·���ϵĵ�ΪҪ���ӵĵ㣬�Ͳ�������
						} else {
							int index = a.x * Setting.COLUMN + j;
							dots[index].setVisible(false);
						}
					}
				}
			} else {
				// ���˵�Ǹ����ߣ��Ǿ���˵���ǵ�Y��ȣ������������߻���������
				if (a.x < b.x) {
					// ���˵A����B��� �ϱߣ���·�ϵİ�ť��ʾ����
					for (int j = a.x; j <= b.x; j++) {
						Point temp = new Point(j, a.y);
						if (temp.equals(pre) || temp.equals(cur)) {
							// ���˵����ǰ·���ϵĵ�ΪҪ���ӵĵ㣬�Ͳ�������
						} else {
							int index = j * Setting.COLUMN + a.y;
							dots[index].setVisible(false);
						}
					}
				} else {
					// ���˵A����B����±ߣ���·�ϵİ�ť��ʾ����
					for (int j = a.x; j >= b.x; j--) {
						Point temp = new Point(j, a.y);
						if (temp.equals(pre) || temp.equals(cur)) {
							// ���˵����ǰ·���ϵĵ�ΪҪ���ӵĵ㣬�Ͳ�������
						} else {
							int index = j * Setting.COLUMN + a.y;
							dots[index].setVisible(false);
						}
					}
				}
			}
		}
		dots[offset].setEnabled(false);
		dots[pre.x * Setting.COLUMN + pre.y].setEnabled(false);
		dots[offset].setBorder(null);
		dots[pre.x * Setting.COLUMN + pre.y].setBorder(null);
		dots[offset].setIcon(null);
		dots[pre.x * Setting.COLUMN + pre.y].setIcon(null);
		dots[offset].setVisible(false);
		dots[pre.x * Setting.COLUMN + pre.y].setVisible(false);
		Map.map[row][col] = 0;
		Map.map[pre.x][pre.y] = 0;
	}
}
