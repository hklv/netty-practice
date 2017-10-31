package com.lhk;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/10/31 11:37
 */
public class TimerClientHandler1 extends ChannelInboundHandlerAdapter {
    private ByteBuf buf;

    public void handlerAdded(ChannelHandlerContext ctx) {
        buf = ctx.alloc().buffer();
    }

    public void handlerRemoved(ChannelHandlerContext context) {
        buf.release();
        buf = null;
    }
}
