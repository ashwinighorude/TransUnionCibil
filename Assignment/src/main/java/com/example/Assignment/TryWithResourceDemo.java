package com.example.Assignment;

import java.io.FileInputStream;
import java.io.IOException;

public  class TryWithResourceDemo {

	private static void printFile() throws IOException {

	    try(FileInputStream input = new FileInputStream("D:\\ash.txt")) {

	        int data = input.read();
	        while(data != -1){
	            System.out.print((char) data);
	            data = input.read();
	        }
	    }
	}
	
	public static void main(String[] args) {

		try {
			TryWithResourceDemo.printFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
