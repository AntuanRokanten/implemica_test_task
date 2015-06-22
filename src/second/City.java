package second;

public class City implements Comparable<City> {
	private String name;
	private int index;
	private int cheapestCost = 200000; // the cheapest cost of commuting from
										// the source to this city. Requirement
										// says that the cost amounts to 200000
										// at most. This field will be reassign
										// during the execution of the
										// application
	private City previous; // a reference to a previous city
	private Path[] paths; // array of paths start from this city

	public City(String name, int index) {
		this.name = name;
		this.index = index;
	}

	// sequence of getters and setters
	public void setPaths(Path[] paths) {
		this.paths = paths;
	}

	public void setCheapestCost(int shortestDist) {
		this.cheapestCost = shortestDist;
	}

	public void setPrevious(City previous) {
		this.previous = previous;
	}

	public String getName() {
		return name;
	}

	public Path[] getPaths() {
		return paths;
	}

	public int getIndex() {
		return index;
	}

	public int getCheapestCost() {
		return cheapestCost;
	}

	// To order the cities, we implemented Comparable interface and now we
	// describe the actual method for comparison
	@Override
	public int compareTo(City o) {
		return Integer.compare(cheapestCost, o.getCheapestCost());
	}

	@Override
	public String toString() {
		return name;
	}
}
