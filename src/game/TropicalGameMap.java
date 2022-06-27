package game;

import java.util.List;

import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.GroundFactory;
import edu.monash.fit2099.engine.Location;
/**
 * TropicalMap allows plant to grow efficiently than previous map
 */
public class TropicalGameMap extends GameMap{
	
	private TropicalGameMap neighbourMap;
	
	/**
	 * Constructor that creates a map from a sequence of ASCII strings.
	 * TropicalMap allows plant to grow efficiently than previous map
	 *
	 * @param groundFactory Factory to create Ground objects
	 * @param lines         List of Strings representing rows of the map
	 */
	public TropicalGameMap(GroundFactory groundFactory, List<String> lines) {
		super(groundFactory, lines);
		this.neighbourMap = null;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor that creates a map from a sequence of ASCII strings.
	 * TropicalMap allows plant to grow efficiently than previous map
	 *
	 * @param groundFactory Factory to create Ground objects
	 * @param lines         List of Strings representing rows of the map
	 * @param neighhbourGameMap neighhbourGameMap is a TropicalGameMap next to this map
	 */
	public TropicalGameMap(GroundFactory groundFactory, List<String> lines , TropicalGameMap neighhbourGameMap) {
		this(groundFactory, lines);
		addGameMap(neighhbourGameMap);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor that creates a map from a sequence of ASCII strings.
	 * TropicalMap allows plant to grow efficiently than previous map
	 *
	 * @param groundFactory Factory to create Ground objects
	 * @param lines         List of Strings representing rows of the map
	 * @param neighbourlines neighbourlines is a neighbourline next to this tropicalgamemap
	 */
	public TropicalGameMap(GroundFactory groundFactory,List<String> lines, List<String> neighbourlines) {
		this(groundFactory, lines);
		addGameMap(groundFactory, neighbourlines);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * add new map to this game map as neighbour and assume neighbour is on north.
	 * 
	 * @param newgroundFactory Factory to create Ground objects
	 * @param neighbourlines   List of Strings representing rows of the map
	 */
	public void addGameMap(GroundFactory newgroundFactory,List<String> neighbourlines) {
		// TODO Auto-generated method stub
		this.neighbourMap = new TropicalGameMap(newgroundFactory, neighbourlines);
		createMapFromStrings();
	}
	
	/**
	 * add new map to this game map as neighbour and assume neighbour is on north.
	 * 
	 * @author Siew
	 * @param neighhbourGameMap neighhbourGameMap is a neighbourhgamemap next to this map
	 */
	public void addGameMap(TropicalGameMap neighhbourGameMap) {
		// TODO Auto-generated method stub
		this.neighbourMap = neighhbourGameMap;
		createMapFromStrings();
	}
	
	
	/**
	 * Creates a new Location to allows plant to grow efficiently than previous map
	 *
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @return a new Location.
	 */
	@Override
	protected Location makeNewLocation(int x, int y) 
	{
		// TODO Auto-generated method stub
		return new TropicalLocation(this,x, y);
	}
	
	/**
	 * added an exit where old map go to new map at north and another exit from south of 
	 * new map to old map
	 */
	private void createMapFromStrings() {
		for (int x : widths) {
			Location here = at(x, getYRange().min());
			Location destination = neighbourMap.at(x, neighbourMap.getYRange().max());
			here.addExit(new Exit("New Map", destination, "0"));
			destination.addExit(new Exit("Old Map", here, "0"));
		}
	}
}
