package ytfeed;

import ytfeed.entity.Feed;
import ytfeed.entity.Site;
import ytfeed.entity.User;

public class App {

	public static void main(String[] args) {
		
		Feed ytfeed = new Feed(new User("john"), new Site("Title","description","site.com"));
		ytfeed.feed();

	}

	
	
	
	// here
}
