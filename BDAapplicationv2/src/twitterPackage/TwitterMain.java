package twitterPackage;



	import java.util.List;

	import twitter4j.Status;
	import twitter4j.TwitterException;
	import twitter4j.TwitterFactory;
	import twitter4j.conf.ConfigurationBuilder;
	public class TwitterMain {

		public static void main(String[] args) throws TwitterException {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("eEgCarPGvzCmc7GZaCfRTF0zS")
									.setOAuthConsumerSecret("e5AohOjVOcanQOEFRhEsDq4ypHmW8EsZZZzaRkC5vd7EKA1CuQ")
									.setOAuthAccessToken("1055890890546466817-rcAxe0x6pbGuuaSPYQ3uwaZ2C4piwd")
									.setOAuthAccessTokenSecret("lmqSBwFAhTgGb07TYfj4U6Ysl8yrzsrua9C3vBm97Gj4d");
			
			TwitterFactory tf = new TwitterFactory(cb.build());
			twitter4j.Twitter twitter = tf.getInstance();
			
			//get  username status
			List<Status> status = twitter.getHomeTimeline();
			for(Status st : status) {
				System.out.println(st.getUser().getName() + "--------------" + st.getText());
			}
		}

	}

