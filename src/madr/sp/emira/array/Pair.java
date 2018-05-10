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
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pair) return false;
		Pair<T> pair = (Pair<T>) obj;
		return this.i.equals(pair.i) && this.j.equals(pair.j);
	}
}

/*class Pair<T extends Comparable<T>, U extends Comparable<U>> implements Comparable<Pair<T,U>> {
    T i;
    U j;
    public Pair(T t, U u) {
        i = t;
        j = u;
    }
    
    @Override
    public int compareTo(Pair<T,U> o) {
        return this.i.compareTo(o.i);
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + i.hashCode();
        result = 31 * result + j.hashCode();
        return result;
    }
    
    @Override
	public boolean equals(Object obj) {
	    if (!(obj instanceof Pair)) return false;
	    Pair<T, U> pair = (Pair<T,U>) obj;
		return this.i.equals(pair.i) && this.j.equals(pair.j);
	}
}*/
