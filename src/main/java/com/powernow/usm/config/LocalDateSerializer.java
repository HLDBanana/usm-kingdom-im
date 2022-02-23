package com.powernow.usm.config;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;

public class LocalDateSerializer implements ObjectSerializer {
    public static final LocalDateSerializer instance = new LocalDateSerializer();
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        SerializeWriter out = jsonSerializer.out;
        if(o==null){
            out.writeNull();
        }else{
            LocalDate time = (LocalDate) o;
            out.write(LocalDateTimeUtil.format(time, DatePattern.NORM_DATE_PATTERN));
        }
    }
}
