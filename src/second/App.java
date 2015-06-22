package second;

/**
 * @author AntonGarelykh
 */

/*
 * This is the second task from the test paper. This program 
 * finds the path of minimum cost between pairs of cities.
 * Please strictly adhere to the input order described in requirements.
 */
import java.util.PriorityQueue;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Input:");
		int s = scn.nextInt(); // the number of tests
		for (int i = 0; i < s; i++) {
			int n = scn.nextInt(); // the number of cities
			City[] cities = new City[n]; // array that will contain all the
											// cities
			for (int j = 0; j < n; j++) {
				String name = scn.next(); // city name
				int p = scn.nextInt(); // the number of neighbours of the city
										// entered above
				City city = new City(name, j + 1); // create a new city by
													// passing its name and
													// index
				Path[] paths = new Path[p]; // array with paths from this city
				for (int k = 0; k < p; k++) {
					int index = scn.nextInt(); // index of the next neighbour
					int cost = scn.nextInt(); // cost of this path
					paths[k] = new Path(index, cost);
				}
				city.setPaths(paths); // set all paths that derive from this
										// particular city
				cities[j] = city;
			}
			for (int j = 0; j < cities.length; j++) { // with this loop we fill
														// all the paths with
														// actual object, not
														// just with indexes
				setTargetObject(cities[j], cities);
			}
			int r; // the number of paths to find
			do {
				r = scn.nextInt();
			} while (r > 100); // r must be equal or smaller that 100 (condition
								// from requirements)
			int[] results = new int[r]; // array with the results
			for (int j = 0; j < r; j++) {
				results[j] = findChipestPath(scn.next(), scn.next(), cities);
			}
			System.out.println("\nOutput:");
			for (int o : results) {
				System.out.println(o);
			}
		}
	}

	/*
	 * Method "setTargetObject" adds to all cities actual objects of the cities
	 * derived from this very city.
	 */
	private static void setTargetObject(City city, City[] cities) {
		Path[] paths = city.getPaths(); // getting paths. At this point, paths
										// don't contain any object.
		for (int i = 0; i < paths.length; i++) {
			for (int j = 0; j < cities.length; j++) {
				if (paths[i].getTargetIndex() == cities[j].getIndex()) {
					paths[i].setTarget(cities[j]); // setting object of the
													// adjacent city
				}
			}
		}
		city.setPaths(paths); // setting path with object of neighbours. From
								// now on, we can complete our task.
	}

	/*
	 * Method "findChipestPath" returns the cheapest cost of commuting to the
	 * destination city
	 */
	private static int findChipestPath(String source, String destination,
			City[] cities) {
		City citySource = null;
		City cityDestination = null;
		for (int i = 0; i < cities.length; i++) { // with this loop we can find
													// respective City objects
													// of source and destination
													// cities
			if (cities[i].getName().equals(source)) {
				citySource = cities[i];
			} else if (cities[i].getName().equals(destination)) {
				cityDestination = cities[i];
			}
		}
		computePaths(citySource); // computing costs of all paths that go from
									// source city
		return cityDestination.getCheapestCost(); // return
	}

	/*
	 * Method "computePaths" implements Dijkstra's algorithm for finding the
	 * cheapest path to cities. In this method we are treating cities like
	 * vertexes of the graph.
	 */
	public static void computePaths(City source) {
		source.setCheapestCost(0);
		PriorityQueue<City> vertexQueue = new PriorityQueue<City>(); // this
																		// queue
																		// consists
																		// of
																		// cities
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			City u = vertexQueue.poll();
			Path[] p = u.getPaths();
			// Visit each path exiting u
			for (Path e : p) {
				City v = e.getTarget();
				int weight = e.getCost();
				int distanceThroughU = u.getCheapestCost() + weight;
				if (distanceThroughU < v.getCheapestCost()) {
					vertexQueue.remove(v);

					v.setCheapestCost(distanceThroughU);
					v.setPrevious(u);
					vertexQueue.add(v);
				}
			}
		}
	}

}
