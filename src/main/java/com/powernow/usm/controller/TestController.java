package com.powernow.usm.controller;

import com.powernow.usm.common.HttpResult;
import com.powernow.usm.service.RedisService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName TestController
 * @Description
 * @Date 2021-7-12 9:51)
 */
@RestController
@RequestMapping("/usm-assets/test")
public class TestController {

    @Autowired
    private RedisService redisService;



    Logger log = LoggerFactory.getLogger(TestController.class);

    @ApiOperation(value="get请求",notes="swagger get请求")
    @GetMapping("/get")
    public HttpResult<String> test(@RequestParam("name") @ApiParam(name="name",value="名称",required=true,allowableValues = "张三,李四") @Valid @NotNull String name){
        return HttpResult.successResult(name);
    }


    @ApiOperation(value="redis测试",notes="redis测试")
    @GetMapping("/redis")
    public HttpResult<String> redis(){
        redisService.geoAdd("geokeys",11.01,22.01,"5");
        redisService.geoAdd("geokeys",11.02,22.02,"1");
        redisService.geoAdd("geokeys",11.00,22.00,"2");
        redisService.geoAdd("geokeys",11.03,22.03,"3");
        redisService.geoAdd("geokeys",11.04,22.04,"4");

        List<Point> geokeys = redisService.geoGet("geokeys", "5");
        // 指定范围和单位
        Distance distance = new Distance(Double.valueOf(5), Metrics.KILOMETERS);
        RedisGeoCommands.GeoRadiusCommandArgs radius = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().includeCoordinates().sortAscending();

        GeoResults geoResults = redisService.nearByXY("geokeys", 11.01, 22.0001, distance,radius);
        return HttpResult.successResult("请求成功",redisService.stringGet("test"));
    }

}
