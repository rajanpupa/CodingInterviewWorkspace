package composition;

/*
 The Composite design pattern is used to structure data into its individual parts 
 as well as represent the inner workings of every part of a larger object.

 The composite pattern also allows you to treat both groups of parts in the same way 
 as you treat the parts polymorphically. 
 This allows your objects to maximize complexity while also remaining dynamic.

 - See more at: http://www.newthinktank.com/2012/10/composite-design-pattern-tutorial/#sthash.i1sHQMeB.dpuf
 */
//This acts as an interface for every Song (Leaf)
//and SongGroup (Composite) we create

public abstract class SongComponent {
	// We throw UnsupportedOperationException so that if
	// it doesn't make sense for a song, or song group
	// to inherit a method they can just inherit the
	// default implementation

	// This allows me to add components
	public void add(SongComponent newSongComponent) {
		throw new UnsupportedOperationException();
	}

	// This allows me to remove components
	public void remove(SongComponent newSongComponent) {
		throw new UnsupportedOperationException();
	}

	// This allows me to get components
	public SongComponent getComponent(int componentIndex) {
		throw new UnsupportedOperationException();
	}

	// This allows me to retrieve song names
	public String getSongName() {
		throw new UnsupportedOperationException();
	}

	// This allows me to retrieve band names
	public String getBandName() {
		throw new UnsupportedOperationException();
	}

	// This allows me to retrieve release year
	public int getReleaseYear() {
		throw new UnsupportedOperationException();
	}

	// When this is called by a class object that extends
	// SongComponent it will print out information
	// specific to the Song or SongGroup
	public void displaySongInfo() {
		throw new UnsupportedOperationException();
	}

}
