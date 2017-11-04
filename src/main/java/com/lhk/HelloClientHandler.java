package com.lhk;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: HuiKang Lv
 * @Description: 客户端
 * @Date: create at 2017/11/4 21:15
 */
public class HelloClientHandler extends SimpleChannelInboundHandler<String> {
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("Server say: " + msg);
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client active");
        super.channelActive(ctx);
    }

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client Close ");
        super.channelInactive(ctx);
    }
}
