//generic fixed size queue 
public class GenQueue<T> implements IGenQ<T> {
	
	private T q[]; // this array holds the queue
	private int putloc, getloc; // the get and put indices 
	
	// construct an empty queue with the given array
	public GenQueue(T[] aRef) {
		q = aRef;
		putloc = getloc = 0;
	}
	
	//put amn item into the queue 
	public void put(T obj) throws QueueFullException {
		
		if(putloc == q.length)
			throw new QueueFullException(q.length);
		
		q[putloc++] = obj;
	}
	
	// get a character from the queue
	public T get()
	throws QueueEmptyException {
		
		if(getloc == putloc)
			throw new QueueEmptyException();
		
		return q[getloc++];
	}
			
}
