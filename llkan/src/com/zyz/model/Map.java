package com.zyz.model;

import java.util.Random;

/**
 * 地图
 * 
 * @author zyz
 * 
 */
public class Map {

	/**
	 * 地图
	 */
	public static int[][] map = new int[Setting.ROW][Setting.COLUMN];

	/**
	 * 辅助的一维数组
	 */
	private int[] array = new int[Setting.ROW * Setting.COLUMN];

	/**
	 * 最大元素数，不能超过map总元素的四分之一
	 */
	private int maxElement = 16;

	/**
	 * 元素个数
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
	 * 初始化一维数组
	 */
	public void init() {
		initArray();
		random(array);
		initMap(array);
	}

	/**
	 * 初始化一维数组
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
	 * 打乱地图的顺序
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
	 * 地图
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
