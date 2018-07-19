package starter.serviceimpl;

import starter.service.MarkService;

import java.io.*;

public class MarkServiceImpl implements MarkService {

    public MarkServiceImpl(){

    }

    public String write(String name,String content){
        try{
            PrintWriter out = new PrintWriter(new FileWriter("d:\\project\\"+name+".txt"));
            out.write(content);
            out.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public String read(String name){
        String content = "";
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\project\\"+name+".txt")));
            String str = "";
            while ((str=in.readLine())!=null){
                content = content + str;
            }
            in.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return content;
    }

    public String delete(String name){
        File file = new File("d:\\project\\"+name+".txt");
        file.delete();
        return "done";
    }

    public String renew(String name,String content){
        return write(name,content);
    }
}
