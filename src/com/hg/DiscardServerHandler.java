package com.hg;

import io.netty.bootstrap.ChannelFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * Handles a server-side channel.
 */
public class DiscardServerHandler  extends ChannelHandlerAdapter {
	
	private static String message=""; 
	

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {

		ChannelFactory  factory ;
			
		
		ByteBuf in = (ByteBuf) msg;
	  //  in.readByte();
	//    count = in.readableBytes();
	    
	    message+= in.readByte();
	    
	    System.out.println(message);
	    if(message.length() >10){
	    	
	    	ctx.write(message.getBytes()); // (1)
	    	  ctx.flush(); // (2)	
	    	  message ="";
	    }
	   
	    
	   
	    
//	    try {
//	        while (in.isReadable()) { // (1)
//	            System.out.print((char) in.readByte());
//	            System.out.flush();
//	        }
//	    } finally {
//	        ReferenceCountUtil.release(msg); // (2)
//	    }
		
//		 ctx.write(msg); // (1)
//	        ctx.flush(); // (2)
//		
	}

	    @Override
	    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
	        // Close the connection when an exception is raised.
	        cause.printStackTrace();
	        ctx.close();
	    }
}
