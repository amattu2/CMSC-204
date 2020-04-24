/**
 * A town i/o manager class
 * 
 * @author Alec M.
 * @date 04/24/2020
 * @version 0.01c
 * @see TownGraphManagerInterface.java
 */
public class TownGraphManager implements TownGraphManagerInterface {

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getRoad(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addTown(String v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsTown(String v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public java.util.ArrayList<String> allRoads() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public java.util.ArrayList<String> allTowns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Town getTown(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void populateTownGraph(java.io.File selectedFile) throws java.io.FileNotFoundException, java.io.IOException {
		// TODO Auto-generated method stub
		
	}
}
