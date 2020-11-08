import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class cityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
//获取请求传过来的省份id
        String strid = request.getParameter("proid");
        if (strid != null && !"".equals(strid.trim())){
            jquerydao dao = new jquerydao();
            List<City> cities = dao.querycityList(Integer.valueOf(strid));
//            把list转json
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(cities);
        }
//        输出数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(json);
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
