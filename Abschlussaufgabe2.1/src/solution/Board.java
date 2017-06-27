/**
 * 
 */
package solution;

import task.Official.Color;

/**
 * @author Admin
 *
 */
public class Board implements task.Board {

	
	/**
	 * 
	 */
	private final int width;
	
	
	/**
	 * 
	 */
	private final int height;
	
	
	/**
	 * 
	 */
	private Field[][] fields;
	
	
	@Override
	public int getWidth() {
		return width;
	}

	
	@Override
	public int getHeight() {
		return height;
	}

	
	@Override
	public Official getOfficial(int x, int y) {
		checkDimensions(x, y);
		return fields[x][y].getOfficial();
	}


	@Override
	public Official getOfficial(Color robe, Color hat) {
		Official ret = null;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (fields[x][y].hasOfficial()
						&& fields[x][y].getOfficial().getRobe().equals(robe)
						&& fields[x][y].getOfficial().getHat().equals(hat)) {
					ret = fields[x][y].getOfficial();
					x = width;
					y = height;
				}
			}
		}
		return ret;
	}


	@Override
	public int getDistance(task.Official official, int x, int y) {
		// TODO NICHT FERTIG!
		int[][] distances = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				distances[i][j] = Integer.MAX_VALUE;
			}
		}
		int oldX = 0;
		int oldY = 0;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (fields[i][j].hasOfficial()
						&& fields[i][j].getOfficial().getRobe().equals(official.getRobe())
						&& fields[i][j].getOfficial().getHat().equals(official.getHat())) {
					oldX = i;
					oldY = j;
					i = width;
					j = height;
				}
			}
		}
		distances[oldX][oldY] = 0;
		hilfsmethode(oldX, oldY, distances, official);
		
		
		
		return distances[x][y];
	}


	private void hilfsmethode(int x, int y, int[][] distances, task.Official official) {
		int delta = 0;
		while (!fields[x][y].hasWallNorth() && !fields[x][y + delta + 1].hasBlock()
				&& !fields[x][y + delta + 1].hasOfficial()) {
			delta++;
		}
		fields[x][y].setOfficial(null);
		fields[x][y + delta].setOfficial(official);
		y += delta;
		distances
		
	}


	@Override
	public void addBlock(int x, int y) {
		checkDimensions(x, y);
		fields[x][y].setBlock(true);
	}


	@Override
	public void addWallNorth(int x, int y) {
		checkDimensions(x, y);
		if (0 <= x && x < width && 0 <= y && y < height) {
			fields[x][y].setWallNorth(true);
			if (y != height - 1) {
				fields[x][y + 1].setWallSouth(true);
			}
		}
	}


	@Override
	public void addWallEast(int x, int y) {
		checkDimensions(x, y);
		if (0 <= x && x < width && 0 <= y && y < height) {
			fields[x][y].setWallEast(true);
			if (x != width - 1) {
				fields[x + 1][y].setWallWest(true);
			}
		}
	}


	@Override
	public void addWallSouth(int x, int y) {
		checkDimensions(x, y);
		if (0 <= x && x < width && 0 <= y && y < height) {
			fields[x][y].setWallSouth(true);
			if (y != 0) {
				fields[x][y - 1].setWallNorth(true);
			}
		}
	}


	@Override
	public void addWallWest(int x, int y) {
		checkDimensions(x, y);
		if (0 <= x && x < width && 0 <= y && y < height) {
			fields[x][y].setWallWest(true);
			if (x != 0) {
				fields[x - 1][y].setWallEast(true);
			}
		}
	}


	@Override
	public Official addOfficial(int x, int y, Color robe, Color hat) {
		checkDimensions(x, y);
		if (officialExists(robe, hat)) 
			throw new IllegalArgumentException("This Official already exists!"); 
		if (fields[x][y].hasBlock()) 
			throw new IllegalArgumentException("This field is blocked by a pavillion!"); 
		if (fields[x][y].hasOfficial()) 
			throw new IllegalArgumentException("This field is blocked by an official!"); 
		Official ret = new Official(x, y, robe, hat, fields);
		fields[x][y].setOfficial(ret);
		return ret;
	}


	@Override
	public boolean hasBlock(int x, int y) {
		checkDimensions(x, y);
		return fields[x][y].hasBlock();
	}


	@Override
	public boolean hasWallNorth(int x, int y) {
		checkDimensions(x, y);
		return fields[x][y].hasWallNorth();
	}


	@Override
	public boolean hasWallEast(int x, int y) {
		checkDimensions(x, y);
		return fields[x][y].hasWallEast();
	}


	@Override
	public boolean hasWallSouth(int x, int y) {
		checkDimensions(x, y);
		return fields[x][y].hasWallSouth();
	}


	@Override
	public boolean hasWallWest(int x, int y) {
		checkDimensions(x, y);
		return fields[x][y].hasWallWest();
	}
	
	
	private void checkDimensions(int x, int y) {
		if (0 < x || x >= width)
			throw new IllegalArgumentException("Illegal Width!"); 
		if (0 < y || y >= height)
			throw new IllegalArgumentException("Illegal Height!"); 
	}


	/**
	 * 
	 * @param robe
	 * @param hat
	 * @return
	 */
	private boolean officialExists(Color robe, Color hat) {
		boolean ret = false;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (fields[x][y].hasOfficial()
						&& fields[x][y].getOfficial().getRobe().equals(robe)
						&& fields[x][y].getOfficial().getHat().equals(hat)) {
					ret = true;
					x = width;
					y = height;
				}
			}
		}
		return ret;
	}
	
	
	/**
	 * @param width
	 * @param height
	 * @param fields
	 */
	public Board(int width, int height) {
		if (0 < width)
			throw new IllegalArgumentException("Illegal Width!"); 
		if (0 < height)
			throw new IllegalArgumentException("Illegal Height!"); 
		this.width = width;
		this.height = height;
		this.fields = new Field[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				this.fields[x][y] = new Field();
			}
		}
		for (int x = 0; x < width; x++) {
			fields[x][0].setWallSouth(true);
			fields[x][height - 1].setWallNorth(true);
		}
		for (int y = 0; y < height; y++) {
			fields[0][y].setWallWest(true);
			fields[width - 1][y].setWallEast(true);
		}
	}
	
	
	public static void main(String[] args) {
		Board tollesBrett = new Board(2, 2);
		tollesBrett.addOfficial(1, 1, Color.Red, Color.Green);
		tollesBrett.addOfficial(0, 1, Color.Blue, Color.Green);
		tollesBrett.addWallNorth(0, 1);
	}

	
}
