package ytfeed;

import ytfeed.business.YTFeed;
import ytfeed.model.Site;
import ytfeed.model.User;

public class App {

	public static void main(String[] args) {
		
		YTFeed ytfeed = new YTFeed(new User("john"), new Site("Title","description","site.com"));
		ytfeed.feed();

	}

}
