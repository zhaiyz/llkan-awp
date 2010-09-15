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
	private static int[] array = new int[Setting.ROW * Setting.COLUMN];

	/**
	 * ���Ԫ���������ܳ���map��Ԫ�ص��ķ�֮һ
	 */
//	private static int maxElement = 16;

	/**
	 * Ԫ�ظ���
	 */
	public static int elements = 15;

	/**
	 * ��ʼ��һά����
	 */
	public static void init() {
		initArray();
		random(array);
		initMap(array);
	}

	/**
	 * ��ʼ��һά����
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
	 * ���ҵ�ͼ��˳��
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
	 * ��ͼ
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
