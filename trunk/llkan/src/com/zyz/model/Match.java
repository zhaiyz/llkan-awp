package com.zyz.model;

import java.awt.Point;
import java.util.LinkedList;

/**
 * 判断是否可以消除
 * 
 * @author zyz
 * 
 */
public class Match {
	
	/**
	 * 用来记录连接的路线
	 */
	public static LinkedList<Line> path = new LinkedList<Line>();

	/**
	 * 横线上的判断
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean horizonMatch(int[][] map, Point a, Point b) {
		
		// 如果点击的是同一个图案，直接返回false
		if (a.x == b.x && a.y == b.y)
			return false;

		// 水平左边的点
		int x_start = a.y <= b.y ? a.y : b.y;

		// 水平右边的点
		int x_end = a.y <= b.y ? b.y : a.y;

		// 只要一个不是0，直接返回false
		for (int x = x_start + 1; x < x_end; x++)
			if (map[a.x][x] != 0) {
				return false;
			}
		path = new LinkedList<Line>();
		Line l = new Line();
		l.setA(a);
		l.setB(b);
		l.setDirect(1);
		path.add(l);
		return true;
	}

	/**
	 * 竖线上的判断
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean verticalMatch(int[][] map, Point a, Point b) {

		// 如果点击的是同一个图案，直接返回false
		if (a.x == b.x && a.y == b.y)
			return false;

		// 竖线上面的点
		int y_start = a.x <= b.x ? a.x : b.x;

		// 竖线下面的点
		int y_end = a.x <= b.x ? b.x : a.x;

		// 只要一个不是0，直接返回false
		for (int y = y_start + 1; y < y_end; y++)
			if (map[y][a.y] != 0)
				return false;
		path = new LinkedList<Line>();
		Line l = new Line();
		l.setA(a);
		l.setB(b);
		l.setDirect(0);
		path.add(l);
		return true;
	}

	/**
	 * 有一个拐角
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean oneCorner(int[][] map, Point a, Point b) {
		Point c, d;

		boolean isMatch;

		c = new Point(a.x, b.y);

		d = new Point(b.x, a.y);

		// C 点上必须没有障碍
		if (map[c.x][c.y] == 0) {

			isMatch = horizonMatch(map, a, c) && verticalMatch(map, b, c);

			if (isMatch) {
				path = new LinkedList<Line>();
                Line la = new Line();
                la.setA(a);
                la.setB(c);
                la.setDirect(1);
                Line lb = new Line();
                lb.setA(c);
                lb.setB(b);
                lb.setDirect(0);
                path.add(la);
                path.add(lb);
				return isMatch;

			}

		}

		// D 点上必须没有障碍
		if (map[d.x][d.y] == 0) {

			isMatch = verticalMatch(map, a, d) && horizonMatch(map, b, d);
            if (isMatch) {
            	path = new LinkedList<Line>();
            	Line la = new Line();
                la.setA(a);
                la.setB(d);
                la.setDirect(1);
                Line lb = new Line();
                lb.setA(d);
                lb.setB(b);
                lb.setDirect(0);
                path.add(la);
                path.add(lb);
			    return isMatch;
            }

		}

		return false;
	}

	/**
	 * 有两个拐角
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean twoCorner(int[][] map, Point a, Point b) {
		LinkedList<Line> ll = new LinkedList<Line>();
		ll = Line.scan(map, a, b);
		if (ll.isEmpty())
			return false;
		for (int index = 0; index < ll.size(); index++) {
			Line line = (Line) ll.get(index);
			if (line.getDirect() == 1) {
				if (Match.verticalMatch(map, a, line.getA())
						&& Match.verticalMatch(map, b, line.getB())) {
					path = new LinkedList<Line>();
					Line la = new Line();
	                la.setA(a);
	                la.setB(line.getA());
	                la.setDirect(0);
	                Line lb = new Line();
	                lb.setA(line.getB());
	                lb.setB(b);
	                lb.setDirect(0);
	                path.add(la);
	                path.add(line);
	                path.add(lb);
					return true;
				}

			} else if (Match.horizonMatch(map, a, line.getA())
					&& Match.horizonMatch(map, b, line.getB())) {
				path = new LinkedList<Line>();
				Line la = new Line();
                la.setA(a);
                la.setB(line.getA());
                la.setDirect(1);
                Line lb = new Line();
                lb.setA(line.getB());
                lb.setB(b);
                lb.setDirect(1);
                path.add(la);
                path.add(line);
                path.add(lb);
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断是否可以消除
	 * 
	 * @param map
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean checkLink(int[][] map, Point a, Point b) {
		// 如果图案不同，直接为false
		if (map[a.x][a.y] != map[b.x][b.y])
			return false;
		if (a.x == b.x && Match.horizonMatch(map, a, b))
			return true;
		if (a.y == b.y && Match.verticalMatch(map, a, b))
			return true;
		if (oneCorner(map, a, b))
			return true;
		else
			return twoCorner(map, a, b);
	}
}
