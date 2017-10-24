package de.fhro.inf.prg3.a04.collections;

public interface SimpleList<T> extends Iterable<T> {
	/**
	 * Add a given object to the back of the list.
	 */
	void add(T o);

	void addEmpty();

	/**
	 * @return current size of the list
	 */
	int size();

	/**
	 * Generate a new list using the given filter instance.
	 * @return a new, filtered list
	 */

	default SimpleList<T> filter(SimpleFilter<T> filter){
		SimpleList<T> result = new SimpleListImpl<T>();
		for(T o : this){
			if(filter.include(o)){
				result.add(o);
			}
		}
		return result;
	}

	default <R> SimpleList<R>  map() {
		SimpleList<R> newSimpleList = new SimpleListImpl<R>();
		for(T o:this)
			newSimpleList.add((R) o);

		return newSimpleList;
	}

}
