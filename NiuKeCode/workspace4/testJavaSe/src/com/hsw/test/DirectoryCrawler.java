package com.hsw.test;

import java.io.File;
import java.util.Scanner;

/**
 * 这是一个简单的目录结构爬虫程序，如果传入的是一个文件则直接打印文件名 如果传入的是一个文件夹，则答应该文件夹的名字和其中所有文件的名字
 * (包括其中的子文件夹名，和子文件名)
 * 
 * @author Administrator
 * 
 */
public class DirectoryCrawler {

	public static void main(String[] args) {
	
		File f = new File("C:\\Users\\Administrator\\Desktop\\论文");

		if (!f.exists()) {
			System.out.println("NO such file/directory");
		} else {
			outPut(f, 0);
		}
	}

	private static void outPut(File f, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print(" ");
		}
		System.out.println(f.getName());
		if (f.isDirectory()) {
			for (File subF : f.listFiles()) {
				outPut(subF, level + 1);
			}
		}
	}

}
