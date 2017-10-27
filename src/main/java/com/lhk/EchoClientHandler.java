package com.lhk;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/10/27 15:38
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {
    private final ByteBuf message;

    public EchoClientHandler() {
        message = Unpooled.buffer(EchoClient.SIZE);
        for (int i = 0; i < message.capacity(); i++) {
            message.writeByte(i);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(message);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) {
        cause.printStackTrace();
        context.close();
    }
}
