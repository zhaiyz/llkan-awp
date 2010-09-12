package com.zyz.model;

import java.util.Random;

/**
 * ��ͼ
 * 
 * @author zyz
 * 
 */
public class Map {

	/**
	 * ��ͼ
	 */
	public static int[][] map = new int[Setting.ROW][Setting.COLUMN];

	/**
	 * ������һά����
	 */
	private int[] array = new int[Setting.ROW * Setting.COLUMN];

	/**
	 * ���Ԫ���������ܳ���map��Ԫ�ص��ķ�֮һ
	 */
	private int maxElement = 16;

	/**
	 * Ԫ�ظ���
	 */
	public int elements = 15;

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public int getMaxElement() {
		return maxElement;
	}

	public void setMaxElement(int maxElement) {
		this.maxElement = maxElement;
	}

	public int getElements() {
		return elements;
	}

	public void setElements(int elements) {
		this.elements = elements;
	}

	/**
	 * ��ʼ��һά����
	 */
	public void init() {
		initArray();
		random(array);
		initMap(array);
	}

	/**
	 * ��ʼ��һά����
	 */
	public void initArray() {
		for (int i = 0; i < elements; i++) {

			array[i * 4] = i + 1;

			array[i * 4 + 1] = i + 1;

			array[i * 4 + 2] = i + 1;

			array[i * 4 + 3] = i + 1;

		}
	}

	/**
	 * ���ҵ�ͼ��˳��
	 * 
	 * @param array
	 * @return
	 */
	public int[] random(int[] array) {

		Random random = new Random();

		for (int i = array.length; i > 0; i--) {

			int j = random.nextInt(i);

			int temp = array[j];

			array[j] = array[i - 1];

			array[i - 1] = temp;

		}

		return array;
	}

	/**
	 * ��ͼ
	 * 
	 * @param array
	 * @return
	 */
	public int[][] initMap(int[] array) {
		for (int i = 0; i < Setting.ROW; i++) {
			for (int j = 0; j < Setting.COLUMN; j++) {
				map[i][j] = array[i * Setting.COLUMN + j];
			}
		}
		return map;
	}
}
