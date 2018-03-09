package general.redis.pub.sub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Subscriber extends Thread {
	
	Jedis jedis;
	
	public Subscriber(Jedis j) {
		jedis = j;
	}

	@Override
	public void run() {
		
		for (;;) {
			jedis.subscribe(new JedisPubSub() {
				
				@Override
				public void onUnsubscribe(String arg0, int arg1) {
					System.out.println("Unsubscribing .....");
				}
				
				@Override
				public void onSubscribe(String arg0, int arg1) {
					System.out.println("Subscribing .....");
				}
				
				@Override
				public void onPUnsubscribe(String arg0, int arg1) {
				}
				
				@Override
				public void onPSubscribe(String arg0, int arg1) {
				}
				
				@Override
				public void onPMessage(String arg0, String arg1, String arg2) {
				}
				
				@Override
				public void onMessage(String channel, String message) {
					System.out.println("Recieved :: [ " + channel + ", " + message + " ]");
				}
			}, RedisClient.CHANNEL_NAME);
		}
	}

}
