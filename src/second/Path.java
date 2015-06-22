package second;

public class Path {
	private City target; // target city this path leads to
	private int cost; // actual cost of the path
	private int targetIndex; // index of the target city this path leads to

	public Path(int targetId, int cost) {
		this.targetIndex = targetId;
		this.cost = cost;
	}
	
	// sequence of getters and setters
	public int  getCost() {
		return cost;
	}
	
	public City getTarget() {
		return target;
	}
	
	public int getTargetIndex() {
		return targetIndex;
	}
	
	public void setTarget(City target) {
		this.target = target;
	}
	
	@Override
	public String toString() {
		return target.toString();
	}
}
