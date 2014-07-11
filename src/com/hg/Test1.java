package com.hg;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class Test1 {
	    private static final int MAXSIZE=5;
	    public static final void main( String argc[] ) throws IOException {
	        Selector [] sels = new Selector[ MAXSIZE];
	 
	            try{
	                for( int i = 0 ;i< MAXSIZE ;++i ) {
	                    sels[i] = Selector.open();
	                    //sels[i].close();
	                }
	                Thread.sleep(30000);
	            }catch( Exception ex ){
	                throw new RuntimeException( ex );
	            }
	            Selector selector = Selector.open();
	            
	           
	            
	            Set<SelectionKey> keys = selector.keys();
	            
	            
	            for(Iterator<SelectionKey> it= keys.iterator();;it.hasNext()){
	            	SelectionKey key = (SelectionKey)it.next();
	            }
	            
	            
	            
	    }
	    
	    
}
