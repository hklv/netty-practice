package com.lhk;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/10/31 14:53
 */
public class HelloServerHandler extends SimpleChannelInboundHandler<String> {
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "say： " + msg);
        ctx.writeAndFlush("Received Messages!\n");
    }

    @Override
    public void channelActive(ChannelHandlerContext context) throws Exception {
        System.out.println("RemoteAddress : " + context.channel().remoteAddress() + " active !");
        context.writeAndFlush("Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");
        super.channelActive(context);
    }
}
