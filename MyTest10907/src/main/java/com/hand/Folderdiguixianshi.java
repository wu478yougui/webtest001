package com.hand;

import java.io.File;

public class Folderdiguixianshi {

	public static void main(String[] args) {
		printFolder(new File("D:/MyEclipes"), 1);
	}
	public static void  printFolder(File dir,int tab){
		if(dir.isDirectory()){
			File list[] = dir.listFiles();
			for(int i=0;i<list.length;i++){
				for (int j = 0; j < tab; j++) {
					System.out.print("|--");
					
				}
				System.out.println(list[i].getName());
				if (list[i].isDirectory()) {
					printFolder(list[i],tab+1);
				}
			}
		}
	}
}