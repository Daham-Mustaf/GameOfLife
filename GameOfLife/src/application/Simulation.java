package application;

public class Simulation {
	// the grid is based on the length
	// in x direction
	// and height in y direction

	int width;
	int height;
	private int[][] board;

	public Simulation(int width, int height) {
		this.width = width;
		this.height = height;
		this.board = new int[width][height]; // initialize the grid

	}

	public void printBoard() {
		System.out.println("----");

		for (int y = 0; y < height; y++) {
			String line = "| ";
			for (int x = 0; x < width; x++) {
				if (this.board[x][y] == 0) {
					line += " . ";
				} else {
					line += " * ";

				}
			}
			line += " |";
			System.out.println(line);
		}
		System.out.println("----\n");
	}

	public void setAlive(int x, int y) {
		this.board[x][y] = 1;
	}

	public void setDead(int x, int y) {
		this.board[x][y] = 0;

	}

	public int countAliveNeighbours(int x, int y) {
		int count = 0;
		// uper
		count += getState(x - 1, y - 1);
		count += getState(x, y - 1);
		count += getState(x + 1, y - 1);

		count += getState(x - 1, y);
		count += getState(x + 1, y);

		count += getState(x - 1, y + 1);
		count += getState(x, y + 1);
		count += getState(x + 1, y + 1);
		return count;
	}

	public int getState(int x, int y) {
		if (x < 0 || x >= width) {
			return 0;
		}
		if (y < 0 || y >= height) {
			return 0;
		}
		return this.board[x][y];
	}

	public void step() {
		int[][] newBoard = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int aliveNeighbours = countAliveNeighbours(x, y);

				if (this.board[x][y] == 1) {
					if (aliveNeighbours < 2)
						newBoard[x][y] = 0;
					else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
						newBoard[x][y] = 1;
					} else if (aliveNeighbours > 3) {
						newBoard[x][y] = 0;
					}

				} else {
					if (aliveNeighbours == 3) {
						newBoard[x][y] = 1;
					}

				}
			}
			// this.board= newBoard;
		}
		this.board = newBoard;
	}

	public static void main(String[] args) {
		Simulation simulat = new Simulation(8, 5);
		simulat.setAlive(1, 1);
		simulat.setAlive(2, 1);
		simulat.setAlive(3, 1);

		simulat.printBoard();
		System.out.println(simulat.countAliveNeighbours(1, 0));
		simulat.step();

		simulat.printBoard();
		simulat.step();
		simulat.printBoard();
		simulat.step();
		
	}
}
