package ComunPackage;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.Group;
import com.restfb.types.Post;
import com.restfb.types.User;

import ServerPackage.Server;

public class Main {


	public static void main(String[] args) {

		/*String accessToken="EAAJJrQIZCZBh4BALPSuOp8atkzByndmyZCQDNUKEseJusV9ZBp7SgAZBBJubT8qHMCTemfjDwYZAjLsSVgn"
				+ "UgVZBiHGEDqtHgL3eWt4gnCbmtNGFZBz3M1R7dZAsGiQCeoWo2GXBRfZBZAH0ZC8M7Hr1szeYAorMa8mqRdNfku2KtMR3Ey"
				+ "QlwBXroOOdiCjsPzW7bTSWgGcNPhJHRAZDZD";

		FacebookClient fclient=new DefaultFacebookClient(accessToken,Version.VERSION_3_1);
		User me =fclient.fetchObject("me", User.class);
		System.out.println(me.getId());


		FacebookClient fbClient5 = new DefaultFacebookClient(accessToken,Version.VERSION_3_1);


		Connection<Post> result = fbClient5.fetchConnection("me/feed",Post.class);
		System.out.println("\nPosts:");
		int counter5 = 0;
		int counterTotal = 0;
		for (List<Post> page : result) {
			for (Post aPost : page) {
				// Filters only posts that contain the word "Inform"
				if (aPost.getMessage() != null ) {
					System.out.println("---- Post "+ counter5 + " ----");
					System.out.println("Id: "+"fb.com/"+aPost.getId());
					System.out.println("Message: "+aPost.getMessage());
					System.out.println("Created: "+aPost.getCreatedTime());
					counter5++;
				}
				counterTotal++;
			}
		}
		System.out.println("-------------\nNº of Results: " + counter5+"/"+counterTotal);	*/



		String accessToken="EAAJJrQIZCZBh4BAAinJRZAS5U2hyeal1ZAda1drmZAD85WjY4ZB1PklOubW8oyL1hrQcZAuZCwFwpCOIwx4qJvGQnSfuT53ZCXcLjxs3nDjk8eMzETcSHZBullLeyon0RNw8YZBZCBF1mLonRk3TPsga1OyZB9cvP4DV8LFikZCUwqcDqV6XKsRrKzCQ20j3iGE1E02CuRSulZAfKDB7gZDZD";

		//String apptoken="643957369338398|jE5c3Lrv9BjHn0Fl11nlvVw40bI";

		FacebookClient fclient=new DefaultFacebookClient(accessToken,Version.VERSION_3_1);
		Connection<Group> groupfeed= fclient.fetchConnection("me/groups",Group.class);


		int count=0;
		for(List<Group> listGroup: groupfeed) {

			for(Group group: listGroup) {
				/*if(group.getName().equals("ISCTE - IUL")) {
					System.out.println(group.getName());
					count++;

					Connection<Post> postfeed=fclient.fetchConnection(group.getId()+"/feed",Post.class);

					for(List<Post> listPost: postfeed){

						for(Post post: listPost) {

							System.out.println(post.getFrom().getName());
							System.out.println("-->"+post.getMessage());
							System.out.println("fb.com/"+post.getId());

						}

					}

				}*/
			}
		}

		System.out.println(count+"--> grupos");









	}




}
