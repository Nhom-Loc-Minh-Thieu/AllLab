/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author ADMIN
 */
import com.sun.security.ntlm.Client;
import java.io.*;
import java.net.*;
//Khai báo lớp NewThread cho phép tạo ra luồng mới
class NewThread extends Thread
{
 private final int count;
 private Socket cl=null;
 private BufferedReader inp=null;//luong nhap
 private PrintWriter outp=null;//luong xuat

NewThread(Socket cl, int count)
{
 super();//Truy xuất cấu tử lớp Thread
 this.cl=cl;
 this.count=count;
 start();
}
//cai dat phuong thuc run-Luong moi
 @Override
 public void run()
{
 try{
//tao luong nhap /xuat cho socket cl
inp=new BufferedReader(new InputStreamReader(cl.getInputStream()));
outp=new PrintWriter(cl.getOutputStream(),true);
//Doc ban kinh gui toi tu Client
double r=Double.parseDouble(inp.readLine().trim());
// lay dia chi Client
InetAddress addrClient=cl.getInetAddress();
//lay so cong phia Client
int portClient=cl.getPort();
//Tinh dien tich
double area=3.14*r*r;
//Hien thi
System.out.println("Luong thu:"+count, Client:"+addrClient.getHostName()+", ip:"+addrClient.getHostAddress()+",port:"+portClient+",r="+r+",area:"+area");
System.out.println(area);
//ket thuc luong
inp.close();
outp.close();
cl.close();
 }
 catch(IOException e)
 {
 System.out.println(e);
 }
 }
}