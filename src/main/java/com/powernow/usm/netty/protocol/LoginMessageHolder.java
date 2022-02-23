package com.powernow.usm.netty.protocol;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @destription
 */
@Data
@ApiModel("登录消息")
public class LoginMessageHolder {

    @ApiModelProperty("发送人")
    private String sender;

    @ApiModelProperty("时间戳")
    private Long time;

}
