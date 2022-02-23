package com.powernow.usm.service.impl;

import com.powernow.usm.netty.protocol.Message;
import com.powernow.usm.netty.protocol.MessageHolder;
import com.powernow.usm.netty.protocol.ProtocolHeader;
import com.powernow.usm.service.PersonMessageService;
import com.powernow.usm.utils.Serializer;
import io.netty.channel.Channel;
import io.netty.util.concurrent.Future;
import org.springframework.stereotype.Service;

/**
 * @destription
 */
@Service
public class PersonMessageServiceImpl implements PersonMessageService {
    @Override
    public Future sendMessage(Channel channel, Message message) {
        MessageHolder messageHolder = new MessageHolder();
        messageHolder.setSign(ProtocolHeader.NOTICE);
        messageHolder.setType(ProtocolHeader.PERSON_MESSAGE);
        messageHolder.setStatus((byte) 0);
        messageHolder.setBody(Serializer.serialize(message));
        return channel.writeAndFlush(messageHolder);
    }

}
