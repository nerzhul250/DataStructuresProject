package algoritmo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Algoritmo_1 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		String a=br.readLine();
		long b=Long.parseLong(a);
	
		bw.write(algoritmo(b)+"");
		br.close();
		bw.close();
		
		
	}
	
	public static long algoritmo(long n) {
		return n*(n+1)/2;
	}
	

}
