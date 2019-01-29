package ytfeed;

import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.SyndFeedOutput;
import com.rometools.rome.io.XmlReader;

public class YTFeed {

    public static void main(String[] args) {
        
            try {
            	List<String> urls = new ArrayList<String>();
            	urls.add("https://www.youtube.com/feeds/videos.xml?channel_id=UCwRD2tsZ9iBz4f4LVBHgtVQ");
            	urls.add("https://www.youtube.com/feeds/videos.xml?channel_id=UCKyTokYo0nK2OA-az-sDijA");
            	
            	// rss_0.9, rss_0.91U, rss_0.91N, rss_0.92, rss_0.93, rss_0.94, rss_1.0, rss_2.0 & atom_0.3
                String outputType = "rss_2.0";

                SyndFeed feed = new SyndFeedImpl();
                feed.setFeedType(outputType);

                feed.setTitle("Aggregated Feed");
                feed.setDescription("Anonymous Aggregated Feed");
                feed.setAuthor("anonymous");
                feed.setLink("http://www.anonymous.com");

                List<SyndEntry> entries = new ArrayList<SyndEntry>();
                feed.setEntries(entries);

                
                for (String url : urls) {
	
                    URL inputUrl = new URL(url);

                    SyndFeedInput input = new SyndFeedInput();
                    SyndFeed inFeed = input.build(new XmlReader(inputUrl));

                    entries.addAll(inFeed.getEntries());

                }

                SyndFeedOutput output = new SyndFeedOutput();
                output.output(feed,new PrintWriter(System.out));

            }
            catch (Exception ex) {
                System.out.println("ERROR: "+ex.getMessage());
            }

    }

}
