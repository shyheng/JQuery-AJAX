import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryProviceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
//调用dao，获取所有省份的信息，list集合
        jquerydao dao = new jquerydao();
        List<Province> provinces  = dao.queryproniceList();
//        把list数据转为json格式的数据，输出给ajax请求
        if (provinces != null){
//            调用Jackson工具库，实现List---json
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(provinces);
        }

//        输出json数据，响应ajax请求，返回数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(json);
        pw.flush();
        pw.close();
    }
}
