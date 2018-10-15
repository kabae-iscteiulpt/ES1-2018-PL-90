package ComunPackage;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;

public class Main {
	
	
	public static void main(String[] args) {

		String accessToken="EAAJJrQIZCZBh4BAF9apyzcGqX4H4No8KZAetebSqOvukSnlWYCzyNq0aDooAKSXo3NsO0g6cO6WpCR"
				+ "VNYQebAlUQx74VWZBpRTRhK1RYLnL0ZAB8P450M1zTbIKulUpub0ScWl6hXamnNW3bIBsZC3s0trS4EhTveiWrOIN"
				+ "Eu1Iu4igrmUxUwPZALvTVSkZC2ZCrxet4ZCfrdbRwZDZD";
		
		FacebookClient fclient=new DefaultFacebookClient(accessToken,Version.VERSION_2_11);
		User me =fclient.fetchObject("me", User.class);
		System.out.println(me.getEmail());
		
		
		/*FacebookClient fbClient4 = new DefaultFacebookClient(accessToken);
		AccessToken extendedAccessToken4 = fbClient4.obtainExtendedAccessToken("490458541421089","b4b0922f88578643b1c3795ed4cde605");
		System.out.println("ExtendedAccessToken: "+extendedAccessToken4.getAccessToken());
		System.out.println("Expires: " + extendedAccessToken4.getExpires());
		
		String accessToken5 ;//= "EAAGZBEccjciEBAJ37ZAIbHKiL1Mo1HHex2pQTcs41dq8azfBvFGgt4eGgKBq12kSssOof51FKO0niKu7AaVKs3dy8W1ilqp4xcjFD1F9mmjJpVyeDnZAffUXRfh7zXL06BuSwQtfHMJbmJ079qCnkT844brHx966cz73JZBZBFy2Bv1rWu7T1rQddZCVpxywZCO6lDxoWDk2gZDZD";
		accessToken5 = "EAAGZBEccjciEBACLQCLnTN82o8ZBa7EtfC80jeEkPFSrZAZB8zunAsYFgo9g0CSWN7jFcXSVuIaqQlN09RBe4IIaQAGc7SqQdedtTQ0wz3Oug6VZAgZA6jNxeWkGE7mjp06s3t3nSgGmTOa4zaV3ZCaZCBPV5PjfcvLQ0rZB1ISq2zNoBjjLs5C7uz6c5e0d6ogItNRM0KbRJQwZDZD";			
		FacebookClient client = new DefaultFacebookClient(Version.LATEST);
		AccessToken userToken = client.obtainUserAccessToken(, clientSecret, redirectOnSuccessURI, code);			
		System.out.println(user.getUsername());*/
		

		
		
	}




}
