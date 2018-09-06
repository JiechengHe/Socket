package base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author hejiecheng
 * @Date 2018/9/6
 */
public class ClientItem {

    public static void main(String[] args) {
        try{
            // 创建一个socket并将其链接到指定的IP和端口
            Socket socket = new Socket("127.0.0.1" , 2013) ;
            // 设置60S超时
            socket.setSoTimeout(60000);

            /** 给服务端发送信息 **/
            // 从socket中获取到输出流，并构造成PrintWriter
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream() , true) ;
            // 将输入的字符串输出到server
            BufferedReader sysBuff = new BufferedReader(new InputStreamReader(System.in)) ;
            printWriter.println(sysBuff.readLine()) ;
            // 刷新输出流
            printWriter.flush();

            /** 接收服务端返回的信息 **/
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
            String result = bufferedReader.readLine() ;
            System.out.println("result:" + result);

            /** 关闭socket **/
            sysBuff.close();
            printWriter.close();
            bufferedReader.close();
            socket.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
