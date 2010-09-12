package com.zyz.model;

import java.awt.Point;
import java.util.LinkedList;

public class Line {

	/**
	 * 线上的一个点
	 */
	private Point a;

	/**
	 * 线上的一个点
	 */
	private Point b;

	/**
	 * 0 表示竖线, 1 表示横线
	 */
	private int direct;

	public Line() {

	}

	public Line(int direct, Point a, Point b) {

		this.direct = direct;

		this.a = a;

		this.b = b;

	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}
	
	public static LinkedList<Line> scan(int[][] map, Point a, Point b) {   
        LinkedList<Line> ll = new LinkedList<Line>();   
        for(int y = a.y; y >= 0; y--)   
            if(map[a.x][y] == 0 && map[b.x][y] == 0 && Match.verticalMatch(map, new Point(a.x, y), new Point(b.x, y)))   
                ll.add(new Line(0, new Point(a.x, y), new Point(b.x, y)));   
  
        for(int y = a.y; y < Setting.ROW; y++)   
            if(map[a.x][y] == 0 && map[b.x][y] == 0 && Match.verticalMatch(map, new Point(a.x, y), new Point(b.x, y)))   
                ll.add(new Line(0, new Point(a.x, y), new Point(b.x, y)));   
  
        for(int x = a.x; x >= 0; x--)   
            if(map[x][a.y] == 0 && map[x][b.y] == 0 && Match.horizonMatch(map, new Point(x, a.y), new Point(x, b.y)))   
                ll.add(new Line(1, new Point(x, a.y), new Point(x, b.y)));   
  
        for(int x = a.x; x < Setting.COLUMN; x++)   
            if(map[x][a.y] == 0 && map[x][b.y] == 0 && Match.horizonMatch(map, new Point(x, a.y), new Point(x, b.y)))   
                ll.add(new Line(1, new Point(x, a.y), new Point(x, b.y)));   
  
        return ll;   
  }

}
