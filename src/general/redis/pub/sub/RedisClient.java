package general.redis.pub.sub;

import java.util.Scanner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClient {
	
	JedisPool jedisPool;
	
	public static final String CHANNEL_NAME = "kaushik-yogesh";
	
	public static void main(String[] args) {
		RedisClient rClient = new RedisClient();
		JedisPoolConfig config = new JedisPoolConfig();
		rClient.jedisPool = new JedisPool(config, "localhost", 6363, 30000, "redissingle6363", 7);
		rClient.startSubscriber();
		rClient.invoke();
	}

	private void startSubscriber() {
		Subscriber s = new Subscriber(jedisPool.getResource());
		s.start();		
	}

	private void invoke() {
		Jedis jedis = jedisPool.getResource();
		System.out.println("Type message to publish");
		Scanner in = new Scanner(System.in);
		String msg = "";
		while(true) {
			msg = in.nextLine();
			jedis.publish(CHANNEL_NAME, msg);
		}		
	}
}
