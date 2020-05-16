
public class Q14 {
	public class Student {
		String firstName;
		String lastName;
		int mNumber;
		
		public boolean equals(Object obj) {
			Student s = (Student) obj;
			return s.firstName == this.firstName && s.lastName == this.lastName && s.mNumber == this.mNumber;
		}
		
		public int hashCode() {
			return this.firstName.hashCode() + this.lastName.hashCode();
		}
	}
}
