package com.learn.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;



/**
 * @author: ZhouJie
 * @date: Create in 2018-05-14 18:31
 * @description:
 * @modified By:
 */
// @Sharable 标识这类的实例之间可以在 channel 里面共享
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf ) msg;
        System.out.println("Server received: " + in.toString(CharsetUtil.UTF_8));// 日志消息输出到控制台
        ctx.write(in);// 将所接收的消息返回给发送者。注意，这还没有冲刷数据
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)// 冲刷所有待审消息到远程节点。关闭通道后，操作完成
                .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();// 打印异常堆栈跟踪
        ctx.close();// 关闭通道
    }
}
