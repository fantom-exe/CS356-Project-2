
public interface Subject {

	void register(Observer observer);
	
	// Not used //
	void unregister(Observer observer);

	void notifyObserver();
	//
	
}
