package com.xm.ssit.demo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NIOMappedByteBufferDemo
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/18 9:28
 * Verion 1.0
 **/
public class NIOMappedByteBufferDemo {
	public static void main(String[] args) {
		int length = 1024 * 1024 *10;
		try {
			MappedByteBuffer out = new RandomAccessFile("e:\\bigFile.txt","rw").getChannel().map(FileChannel.MapMode.READ_WRITE,0,length);
			for (int i=0;i<length;i++){
				out.put((byte)'a');
			}
			 for (int i =0 ;i<10;i++){
				 System.out.println(out.get(i));
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
