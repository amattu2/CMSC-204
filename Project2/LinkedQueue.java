/**
 * A LinkedQueue implementation based on Pearson Module #8 - Queues
 * 
 * @author Alec M.
 * @date 02/12/2020
 * @version 0.01
 */
public class LinkedQueue<T> implements QueueInterface<T> {
	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean enqueue(T e) {
		return false;
	}

	@Override
	public T[] toArray() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public T dequeue() {
		return null;
	}
}
