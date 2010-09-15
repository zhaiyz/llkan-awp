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
	private static int[] array = new int[Setting.ROW * Setting.COLUMN];

	/**
	 * 最大元素数，不能超过map总元素的四分之一
	 */
//	private static int maxElement = 16;

	/**
	 * 元素个数
	 */
	public static int elements = 15;

	/**
	 * 初始化一维数组
	 */
	public static void init() {
		initArray();
		random(array);
		initMap(array);
	}

	/**
	 * 初始化一维数组
	 */
	public static void initArray() {
		
		for (int i=0; i<Setting.ROW * Setting.COLUMN; i++) {
			array[i] = 0;
		}
		
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
	public static int[] random(int[] array) {

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
	public static int[][] initMap(int[] array) {
		for (int i = 0; i < Setting.ROW; i++) {
			for (int j = 0; j < Setting.COLUMN; j++) {
				map[i][j] = array[i * Setting.COLUMN + j];
			}
		}
		return map;
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	public static int[] random(int[][] map) {
		for (int i=0; i<Setting.ROW * Setting.COLUMN; i++) {
			array[i] = 0;
		}
		for (int i=0; i<Setting.ROW; i++) {
			for (int j=0; j<Setting.COLUMN; j++) {
				array[i * Setting.COLUMN + j] = map[i][j];
				map[i][j] = 0;
			}
		}
		
		random(array);
		
		for (int i = 0; i < Setting.ROW; i++) {
			for (int j = 0; j < Setting.COLUMN; j++) {
				map[i][j] = array[i * Setting.COLUMN + j];
			}
		}
		
		return array;
	}
}
