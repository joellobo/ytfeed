package ytfeed;

public class App {

	public static void main(String[] args) {
		
		YTFeed ytfeed = new YTFeed(new User(), new Site());
		ytfeed.feed();

	}

}
