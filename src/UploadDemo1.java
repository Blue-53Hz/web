import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class UploadDemo1 extends HttpServlet {

    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1)获取实体内容
        InputStream in = request.getInputStream();
        //2)转为字符输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //读取一行

        //文件开始分割符
        String fileTag = br.readLine();

        String str = br.readLine();
        //获取文件名称
        String fileName = str.substring(str.indexOf("filename=\"")+10,str.length()-1);

        //跳过两行
        br.readLine();
        br.readLine();

        //读取文件内容
        String content = null;

        BufferedWriter bw = new BufferedWriter(new FileWriter("e:/"+fileName));
        while( (content=br.readLine())!=null){
            //遇到文件结束符号，排除文件的结束符号
            if(content.equals(fileTag+"--")){
                continue;
            }

            //写出到服务器的一个文件中
            bw.write(content);
            //写入换行符
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
