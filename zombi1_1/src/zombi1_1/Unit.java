package zombi1_1;

import java.util.*;

abstract public class Unit {
	private int pos,hp;
	
	int max;
	Random r;
	
	
	public Unit(int pos, int hp, int max) {
		this.pos = pos;
		this.hp =hp;
		this.max =max;
		
		r= new Random();
		
	}


	public int getPos() {
		return pos;
	}


	public void setPos(int pos) {
		this.pos = pos;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}
	
	public void move() {
		if(pos <=10) {
			pos++;
		}
		System.out.println("오른쪽 이동. 현위치: "+pos);
	}


}
