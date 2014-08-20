package com.star.lucene;

import java.util.Random;



public class TestIndexFile {

	public static void main(String[] args) {
		Long size = 164278272L + 1024*1024*1024 + 1024*1024*1024 +1;
		Long formatSize = size / (1024L * 1024L * 1024L);
		System.out.println(formatSize);
		
		
		System.out.println(new Random().nextInt(10) + new Random().nextInt(10) + new Random().nextInt(10));
	}
	
}
