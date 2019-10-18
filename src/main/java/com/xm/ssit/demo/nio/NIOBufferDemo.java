package com.xm.ssit.demo.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName Main
 * @Description TODO
 * @Author yechengzong@ssit-xm.com.cn
 * Date 2019/10/18 9:12
 * Verion 1.0
 **/
public class NIOBufferDemo {

	public static void main(String[] args) {
		 int bufferSize = 1024;
		try {
			FileChannel fileChannel = new FileInputStream("E:/file.txt").getChannel();
			FileChannel fileChannel2 = new FileOutputStream("E:/file2.txt").getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
			while (fileChannel.read(byteBuffer)!=-1){
				byteBuffer.flip();
				fileChannel2.write(byteBuffer);
				byteBuffer.clear();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
