/**
 * 
 */
package solution;

/**
 * @author Admin
 *
 */
public class Field {
	
	
	/**
	 * 
	 */
	private boolean wallNorth;
	
	
	/**
	 * 
	 */
	private boolean wallEast;
	
	
	/**
	 * 
	 */
	private boolean wallSouth;
	
	
	/**
	 * 
	 */
	private boolean wallWest;
	
	
	/**
	 * 
	 */
	private boolean block;
	
	
	/**
	 * 
	 */
	private Official official;


	/**
	 * Creates an empty Field without any Walls.
	 */
	public Field() {
		wallNorth = false;
		wallEast = false;
		wallSouth = false;
		wallWest = false;
		block = false;
		official = null;
	}


	/**
	 * 
	 * @return
	 */
	public boolean hasWallNorth() {
		return wallNorth;
	}


	/**
	 * 
	 * @return
	 */
	public boolean hasWallEast() {
		return wallEast;
	}


	/**
	 * 
	 * @return
	 */
	public boolean hasWallSouth() {
		return wallSouth;
	}


	/**
	 * 
	 * @return
	 */
	public boolean hasWallWest() {
		return wallWest;
	}


	/**
	 * 
	 * @return
	 */
	public boolean hasBlock() {
		return block;
	}


	/**
	 * 
	 * @return
	 */
	public boolean hasOfficial() {
		boolean ret = false;
		if (official != null) {
			ret = true;
		}
		return ret;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Official getOfficial() {
		return official;
	}


	/**
	 * 
	 * @param wallNorth
	 */
	public void setWallNorth(boolean wallNorth) {
		this.wallNorth = wallNorth;
	}


	/**
	 * 
	 * @param wallEast
	 */
	public void setWallEast(boolean wallEast) {
		this.wallEast = wallEast;
	}


	/**
	 * 
	 * @param wallSouth
	 */
	public void setWallSouth(boolean wallSouth) {
		this.wallSouth = wallSouth;
	}


	/**
	 * 
	 * @param wallWest
	 */
	public void setWallWest(boolean wallWest) {
		this.wallWest = wallWest;
	}


	/**
	 * 
	 * @param blocked
	 */
	public void setBlock(boolean blocked) {
		this.block = blocked;
	}


	/**
	 * 
	 * @param official
	 */
	public void setOfficial(Official official) {
		this.official = official;
	}
	
	
}
