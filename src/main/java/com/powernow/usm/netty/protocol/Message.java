package com.powernow.usm.netty.protocol;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 */
@Data
@ApiModel("聊天消息")
public class Message {
    // PERSON_MESSAGE, GROUP_MESSAGE
    @ApiModelProperty("发送人")
    private String sender;

    @ApiModelProperty("接收人")
    private String receiver;

    @ApiModelProperty("聊天内容")
    private String content;

    private Long time;

}
