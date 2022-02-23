package com.powernow.usm.service.impl;

import com.alibaba.fastjson.JSON;
import com.powernow.usm.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @create: 2020/9/11 13:13
 * @update: 2020/9/11 13:13
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private SetOperations<String, String> setOperations() {
        return redisTemplate.opsForSet();
    }

    private HashOperations hashOperations() {
        return redisTemplate.opsForHash();
    }

    private ListOperations<String, String> listOperations() {
        return redisTemplate.opsForList();
    }

    private ValueOperations<String, String> valueOperations() {
        return redisTemplate.opsForValue();
    }

    @Override
    public void stringSet(String key, String value) {
        valueOperations().set(key, value);
    }

    @Override
    public String stringGet(String key) {
        return valueOperations().get(key);
    }

    @Override
    public void expire(String key, long mills) {
        expire(key, mills, TimeUnit.SECONDS);
    }

    @Override
    public void expire(String key, long mills, TimeUnit timeUnit) {
        redisTemplate.expire(key,mills,timeUnit);
    }

    @Override
    public Boolean remove(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Long incr(String key, Long value) {
        return valueOperations().increment(key, value);
    }

    @Override
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public List<String> moreGet(List<String> keys) {
        return valueOperations().multiGet(keys);
    }

    @Override
    public void moreSet(Map<String, String> map) {
        valueOperations().multiSet(map);
    }

    @Override
    public void expire(String key, Long seconds, String value, TimeUnit timeUnit) {
        valueOperations().set(key, value, seconds, timeUnit);
    }

    @Override
    public Set<String> keys(String patter) {
        return redisTemplate.keys(patter);
    }

    @Override
    public Boolean persist(String key) {
        return redisTemplate.persist(key);
    }

    @Override
    public void rename(String oldKey, String newKey) {
        redisTemplate.rename(oldKey, newKey);
    }

    @Override
    public Long ttlKeyExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    @Override
    public Long append(String key, String value) {
        return Long.valueOf(valueOperations().append(key,value));
    }

    @Override
    public Boolean hashExists(String key, Object childKey) {
        return hashOperations().hasKey(key,childKey);
    }

    @Override
    public Long hashRemove(String key, Object... childKey) {
        return hashOperations().delete(key,childKey);
    }

    @Override
    public Object hashGet(String key, Object childKey) {
        return hashOperations().get(key,childKey);
    }

    @Override
    public List<Object> hashValues(String key) {
        return hashOperations().values(key);
    }

    @Override
    public Set<Object> hashChildKeys(String key) {
        return hashOperations().keys(key);
    }

    @Override
    public Map<Object, Object> hashGetAll(String key) {
        return hashOperations().entries(key);
    }

    @Override
    public Long hashIncr(String key, Object childKey, Long delta) {
        return hashOperations().increment(key,childKey,delta);
    }

    @Override
    public List<Object> hashGetValueList(String key, List<? extends Object> childKeys) {
        return hashOperations().multiGet(key,childKeys);
    }

    @Override
    public void hashSet(String key, Object childKey, Object value) {
        hashOperations().put(key,childKey,value);
    }

    @Override
    public void hashPutAll(String key, Map<?, ?> map) {
        hashOperations().putAll(key,map);
    }

    @Override
    public Long hashLen(String key) {
        return hashOperations().size(key);
    }

    @Override
    public Long lpush(String key, String value) {
        return listOperations().leftPush(key,value);
    }

    @Override
    public Long rpush(String key, String value) {
        return listOperations().rightPush(key,value);
    }

    @Override
    public String lpop(String key) {
        return listOperations().leftPop(key);

    }

    @Override
    public String rpop(String key) {
        return listOperations().rightPop(key);
    }

    @Override
    public void linsert(String key, String element, String value) {
        listOperations().leftPush(key,element,value);
    }

    @Override
    public String lindex(String key, Long index) {
        return listOperations().index(key,index);
    }

    @Override
    public Long llen(String key) {
        return listOperations().size(key);
    }

    @Override
    public List<String> lrange(String key, Long start, Long end) {
        return listOperations().range(key,start,end);
    }

    @Override
    public Long lrem(String key, Long count, String value) {
        return listOperations().remove(key,count,value);
    }

    @Override
    public void lset(String key, Long index, String value) {
        listOperations().set(key,index,value);
    }

    @Override
    public void ltrim(String key, Long start, Long end) {
        listOperations().trim(key,start,end);
    }

    @Override
    public String rpoplpush(String key, String destination) {
        return listOperations().rightPopAndLeftPush(key,destination);
    }

    @Override
    public String brpoplpush(String srcKey, String destination, Long timeout, TimeUnit unit) {
        return listOperations().rightPopAndLeftPush(srcKey,destination,timeout,unit);
    }

    @Override
    public Long sAdd(String key, String... values) {
        return setOperations().add(key,values);
    }

    @Override
    public Long sLength(String key) {
        return setOperations().size(key);
    }

    @Override
    public Set<String> sMembers(String key) {
        return setOperations().members(key);
    }

    @Override
    public Set<String> sDifferent(String key, List<String> otherKeys) {
        return setOperations().difference(key,otherKeys);
    }

    @Override
    public Long sDifferentAndStore(String key, List<String> keys, String destKey) {
        return setOperations().differenceAndStore(key,keys,destKey);
    }

    @Override
    public Boolean sIsMember(String key, String target) {
        return setOperations().isMember(key,target);
    }

    @Override
    public Boolean sMove(String srcKey, String destKey, String member) {
        return setOperations().move(srcKey,member,destKey);
    }

    @Override
    public Set<String> sInterMembers(String key, List<String> keys) {
        return setOperations().intersect(key,keys);
    }

    @Override
    public String sPop(String key) {
        return setOperations().pop(key);
    }

    @Override
    public void sRemove(String key, String... values) {
        setOperations().remove(key,values);
    }

    @Override
    public Set<String> sUnion(String key, List<String> keys) {
        return setOperations().union(key,keys);
    }

    @Override
    public boolean setNx(String k, String v,Long s,  TimeUnit t){
        return valueOperations().setIfAbsent(k,v,s,t);
    }

    @Override
    public long getRemainingMillisecondToday() {
        Instant now = Instant.now();
        LocalDateTime midnight = LocalDateTime.ofInstant(now,
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(now,
                ZoneId.systemDefault());
        return ChronoUnit.MILLIS.between(currentDateTime, midnight);
    }

    @Override
    public void setSerializ(String k, Object v,Long s,  TimeUnit t){
        if(null==s){
            valueOperations().set(k, JSON.toJSONString(v));
            return;
        }
        valueOperations().set(k, JSON.toJSONString(v),s,t);
    }

    @Override
    public void setSerializ(String k, Object v){
        setSerializ(k, v,null,null);
    }

    @Override
    public <T> T get(String key, Class<T> type){
        String s = valueOperations().get(key);
        if(StringUtils.isEmpty(s)){
            return null;
        }
        return JSON.parseObject(s,type);
    }

    /**
     * 添加经纬度信息,时间复杂度为O(log(N))
     * redis 命令：geoadd cityGeo 116.405285 39.904989 "北京"
     * @param k     key
     * @param point 经纬度
     * @param m     名称（存放业务数据 如：店铺id等）
     */
    public Long geoAdd(String k, Point point, String m) {

        return redisTemplate.opsForGeo().add(k, point, m);
    }

    public Long geoAdd(String k, Double lng, Double lat, String m){
        Point point = new Point(lng,lat);
        return geoAdd(k,point,m);
    }
    /**
     * 删除经纬度信息,时间复杂度为O(log(N))
     * redis 删除geo数据
     * @param k     key
     * @param ms     名称（存放业务数据 如：店铺id等）
     */
    public Long geoRemove(String k, String... ms){
        return redisTemplate.opsForGeo().remove(k,ms);
    }
    /**
     * 查找指定key的经纬度信息，可以指定多个key，批量返回
     * redis命令：geopos cityGeo 北京
     * @param k     key
     * @param m
     */
    public List<Point> geoGet(String k, String... m) {
        return redisTemplate.opsForGeo().position(k,m);
    }

    /**
     * 返回两个地方的距离，可以指定单位，比如米m，千米km，英里mi，英尺ft
     * redis命令：geodist cityGeo 北京 上海
     * @param k     key
     * @param mk1
     * @param mk2
     * @param metric   距离单位 比如米m，千米km，英里mi，英尺ft
     * @return
     */
    public Distance geoDist(String k, String mk1, String mk2, Metric metric) {
        return redisTemplate.opsForGeo().distance(k, mk1, mk2, metric);
    }

    /**
     * 根据给定的经纬度，返回半径不超过指定距离的元素,时间复杂度为O(N+log(M))，N为指定半径范围内的元素个数，M为要返回的个数
     * redis命令：georadius cityGeo 116.405285 39.904989 100 km WITHDIST WITHCOORD ASC COUNT 5
     * @param k         key
     * @param circle    位置、距离
     * @param args
     */
    public void nearByXY(String k, Circle circle, RedisGeoCommands.GeoRadiusCommandArgs args) {
        //longitude,latitude
        //Circle circle = new Circle(116.405285, 39.904989, Metrics.KILOMETERS.getMultiplier());
        //RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().includeCoordinates().sortAscending().limit(5);

        GeoResults<RedisGeoCommands.GeoLocation<String>> results = redisTemplate.opsForGeo().radius(k, circle, args);
        System.out.println(results);
    }

    public GeoResults nearByXY(String k, Double lng,Double lat,Distance distance, RedisGeoCommands.GeoRadiusCommandArgs args){
        Point point = new Point(lng,lat);
        Circle circle = new Circle(point,distance);
        GeoResults<RedisGeoCommands.GeoLocation<String>> radius = redisTemplate.opsForGeo().radius(k, circle,args);
        return radius;
    }
    /**
     * 根据指定的地点查询半径在指定范围内的位置,时间复杂度为O(log(N)+M)，N为指定半径范围内的元素个数，M为要返回的个数
     * redis命令：georadiusbymember cityGeo 北京 100 km WITHDIST WITHCOORD ASC COUNT 5
     * @param k     key
     * @param mk    业务数据
     * @param distance  距离
     * @param args
     * @return
     */
    public GeoResults nearByPlace(String k, String mk, Distance distance, RedisGeoCommands.GeoRadiusCommandArgs args) {
//        Distance distance = new Distance(5, Metrics.KILOMETERS);
//        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().includeCoordinates().sortAscending().limit(5);
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = redisTemplate.opsForGeo().radius(k, mk, distance, args);
        return results;
    }

    /**
     * 返回的是geohash值,查找一个位置的时间复杂度为O(log(N))
     * redis命令：geohash cityGeo 北京
     * @param k
     * @param mks
     * @return
     */
    public List geoHash(String k, String... mks) {
        return redisTemplate.opsForGeo().hash(k,mks);
    }

}
