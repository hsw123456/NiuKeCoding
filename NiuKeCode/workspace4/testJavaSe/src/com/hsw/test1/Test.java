package com.hsw.test1;

public class Test {
	public static void main(String[] args) {
		Board board = new Board(8);
		solve(board);

	}

	public static void solve(Board b) {
		if (explore(b, 0)) {
			System.out.println("one solution is as follows:");
			b.print();
		} else {
			System.out.println("No solution.");
		}

	}

	public static boolean explore(Board b, int col) {
		if (col > b.getSize() - 1) {
			return true;
		} else {
			for (int row = 0; row < b.getSize(); row++) {
				if (b.isSafe(row, col)) {
					b.place(row, col);
					if (explore(b, col + 1)) {
						return true;
					}

					b.remove(row, col);
				}
			}

			return false;
		}

	}

}

class Board {

	private int size;
	private int[][] pos;

	public Board(int size) {
		this.size = size;
		pos = new int[size][size];
	}
	
	public boolean isSafe(int row, int col) {
		for(int i=col-1; i>=0;i--){
			for(int j=0;j<this.size;j++){
				if(j<row){
					if(this.pos[i][i+row-col]==1)
						return false;
				}else{
					if(this.pos[i][row+col-i]==1){
						return false;
					}
				}
				
				if(this.pos[row][col] == 1){
					return false;
				}
			}
		}
		return true;
	}

	public void place(int row, int col) {
		pos[row][col] = 1;
	}

	public void remove(int row, int col) {
		pos[row][col] = 0;
	}

	public void print() {
		for (int i = 0; i < pos.length; i++) {
			for (int j = 0; j < pos[i].length; j++) {
				System.out.print(pos[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
