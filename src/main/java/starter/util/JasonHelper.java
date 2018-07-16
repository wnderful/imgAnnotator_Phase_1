package starter.util;

import com.alibaba.fastjson.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/* not use */
public class JasonHelper {
    public static JSONObject requestToJson(HttpServletRequest request){
            StringBuilder jsonStr = new StringBuilder();
            try(InputStream inputStream = request.getInputStream() ){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                String input;
                while((input = bufferedReader.readLine()) != null){
                    jsonStr.append(input);
                }
                bufferedReader.close();

            }catch (Exception ex){
                ex.getStackTrace();
            }
            //return new JSONObject(jsonStr.toString());
        return new JSONObject();
    }

    public static void jsonToResbonse(JSONObject jsonObject, HttpServletResponse response){
        response.setContentType("application/json;charset = UTF-8");
        try(PrintWriter writer = new PrintWriter(response.getWriter())){
            writer.append(jsonObject.toString());
        }catch(Exception ex){
            ex.getStackTrace();
        }
    }
}
