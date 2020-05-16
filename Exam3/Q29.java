import java.util.ArrayList;

public class Q29 {
	public class GroupOfStuff<T> {
		private ArrayList<T> group = new ArrayList<T>();
		
		public T get() {
			return this.group.remove(0);
		}
		
		public void insert(T value) {
			this.group.add(value);
		}
	}
}
