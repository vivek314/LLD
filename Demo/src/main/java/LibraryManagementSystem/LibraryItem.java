package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class LibraryItem {
	private String id;
	private String title;
	private List<Member> observers  = new ArrayList<>();
	public LibraryItem(String id, String title) {
		this.id = id;
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public List<Member> getObservers() {
		return observers;
	}
	public void addObserver(Member member) {
		observers.add(member);
	}
	public void notifyObservers(){
		for(Member member : observers){
			member.update("Good news!: "+ title + " is back in stock!");
		}
		observers.clear();
	}
}
