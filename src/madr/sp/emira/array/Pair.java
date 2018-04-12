package madr.sp.emira.array;

public class Pair<T extends Comparable<T>> implements Comparable<Pair<T>>{
	
	public T i;
	public T j;
	
	public Pair(T i, T j) {
		this.i = i;
		this.j = j;
	}
	
	@Override
	public String toString() {
		return "{ " + i.toString() + " : " + j.toString() + " }"; 
	}

	@Override
	public int compareTo(Pair<T> o) {
		return this.i.compareTo(o.i);
	}
}
