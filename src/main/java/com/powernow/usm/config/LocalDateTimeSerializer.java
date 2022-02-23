package com.powernow.usm.config;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class LocalDateTimeSerializer implements ObjectSerializer {
    public static final LocalDateTimeSerializer instance = new LocalDateTimeSerializer();
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        SerializeWriter out = jsonSerializer.out;
        if(o==null){
            out.writeNull();
        }else{
            LocalDateTime time = (LocalDateTime) o;
            out.writeString(LocalDateTimeUtil.format(time, DatePattern.NORM_DATETIME_PATTERN));
        }
    }
}
