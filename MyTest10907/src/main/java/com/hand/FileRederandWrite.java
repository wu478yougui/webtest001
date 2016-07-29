package com.hand;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileRederandWrite {

	public static void main(String[] args) {

		File file = new File("D:/hello.txt");
		while (file.exists()) {
			System.out.println("文件存在！！ ");
			break;
		}
		try {

			FileInputStream fis;
			fis = new FileInputStream(file);
			InputStreamReader isr;
			isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			try {
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);

				}
				br.close();
				isr.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 文件写入

		File file1 = new File("D:/my.txt");
		try {
			FileOutputStream fop = new FileOutputStream(file1);
			OutputStreamWriter osw = new OutputStreamWriter(fop, "utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write("lskdjflskdjfsldfj " + "\n");
			bw.write("lskdjflskdjfsldfj\n");
			bw.write("lskdjflskdjfsldfj\n");
			bw.write("lskdjflskdjfsl斯蒂芬斯蒂芬\n");
			bw.write("lskdjflskd士大夫士大夫fj\n");
			bw.write("lskdjflskSSDFSD\n");

			bw.close();
			osw.close();
			fop.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
