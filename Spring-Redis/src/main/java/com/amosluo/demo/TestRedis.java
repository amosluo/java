package com.amosluo.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
public class TestRedis {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    MyTemplate myTemplate;

    ///从自定义模板获取模板
    @Autowired
    @Qualifier("GetTemplate") //自定义获取模板的方法
    StringRedisTemplate stringRedisTemplate2;


    @Autowired
    ObjectMapper objectMapper;
    public void testRedis(){
//        redisTemplate.opsForValue().set("k1","124");
//        System.out.println(redisTemplate.opsForValue().get("k1"));
//        stringRedisTemplate.opsForValue().set("k1","124");
//        System.out.println(stringRedisTemplate.opsForValue().get("k1"));
//
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.set("luox".getBytes(), "xuan".getBytes());
//        System.out.println(new String(connection.get("luox".getBytes())));
//
//        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
//        hash.put("user", "name","luox");
//        hash.put("user","age",20);
//        System.out.println(hash.entries("user"));

//        Person person = new Person();
//        person.setName("hello BADY");
//        person.setAge(130);

//        stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
//        Jackson2HashMapper jm = new Jackson2HashMapper(objectMapper,false);
//
//
//        stringRedisTemplate.opsForHash().putAll("user",jm.toHash(person));
//
//        Map map = stringRedisTemplate.opsForHash().entries("user");
//        Person person1 = objectMapper.convertValue(map, Person.class);

//        Jackson2HashMapper jm = new Jackson2HashMapper(objectMapper,false);
//
//        stringRedisTemplate2.opsForHash().putAll("user3",jm.toHash(person));
//
//        Map map = stringRedisTemplate2.opsForHash().entries("user3");
//        Person person1 = objectMapper.convertValue(map, Person.class);
//
//        System.out.println(person1.getName());

        //发布消息
        //stringRedisTemplate2.convertAndSend("501","hello little boby!");

        //订阅消息
        stringRedisTemplate2.getConnectionFactory().getConnection().subscribe(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] bytes) {
                System.out.println(new String(message.getBody()));
            }
        }, "501".getBytes()

                );

        while (true){

            try {
                stringRedisTemplate2.convertAndSend("501", "hello little boby!");
                Thread.sleep(3000);
            }
            catch (InterruptedException ex){

            }
        }

    }
}
