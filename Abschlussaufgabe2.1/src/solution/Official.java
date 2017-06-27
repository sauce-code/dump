/**
 * 
 */
package solution;

/**
 * @author Admin
 *
 */
public class Official implements task.Official {

	
	/**
	 * 
	 */
	int x;
	
	
	/**
	 * 
	 */
	int y;
	
	
	/**
	 * 
	 */
	Color robe;
	
	
	/**
	 * 
	 */
	Color hat;
	
	
	/**
	 * 
	 */
	Field[][] fields;
	
	
	/**
	 * @param robe
	 * @param hat
	 */
	public Official(int x, int y, Color robe, Color hat, Field[][] fields) {
		this.x = x;
		this.y = y;
		this.robe = robe;
		this.hat = hat;
		this.fields = fields;
	}


	@Override
	public Color getRobe() {
		return robe;
	}

	
	@Override
	public Color getHat() {
		return hat;
	}

	
	@Override
	public void moveNorth() {
		int delta = 0;
		while (!fields[x][y].hasWallNorth() && !fields[x][y + delta + 1].hasBlock()
				&& !fields[x][y + delta + 1].hasOfficial()) {
			delta++;
		}
		fields[x][y].setOfficial(null);
		fields[x][y + delta].setOfficial(this);
		y += delta;
	}


	@Override
	public void moveEast() {
		int delta = 0;
		while (!fields[x][y].hasWallEast() && !fields[x + delta + 1][y].hasBlock()
				&& !fields[x + delta + 1][y].hasOfficial()) {
			delta++;
		}
		fields[x][y].setOfficial(null);
		fields[x + delta][y].setOfficial(this);
		x += delta;
	}


	@Override
	public void moveSouth() {
		int delta = 0;
		while (!fields[x][y].hasWallSouth() && !fields[x][y - delta - 1].hasBlock()
				&& !fields[x][y - delta - 1].hasOfficial()) {
			delta++;
		}
		fields[x][y].setOfficial(null);
		fields[x][y - delta].setOfficial(this);
		y -= delta;
	}


	@Override
	public void moveWest() {
		int delta = 0;
		while (!fields[x][y].hasWallWest() && !fields[x - delta - 1][y].hasBlock()
				&& !fields[x - delta - 1][y].hasOfficial()) {
			delta++;
		}
		fields[x][y].setOfficial(null);
		fields[x - delta][y].setOfficial(this);
		x -= delta;
	}

	
}
