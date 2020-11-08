import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jquerydao {
    private Connection coon;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private String url = "jdbc:mysql://localhost:3306/shy1?useUnicode=true&characterEncoding=utf8";
    private String username = "root";
    private String password = "3333";

    //    查询所有省份的信息
    public List<Province> queryproniceList() {
        List<Province> provinces = new ArrayList<>();
        try {
            Province p = null;
            Class.forName("com.mysql.jdbc.Driver");
            coon = DriverManager.getConnection(url, username, password);
            sql = "select id,name,jiancheng,shenghui from province order by id";
            ps = coon.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Province();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setJiancheng(rs.getString("jiancheng"));
                p.setShenghui(rs.getString("shenghui"));
                provinces.add(p);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (coon != null) {
                try {
                    coon.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return provinces;
    }

    //    查询所有省份的信息
    public List<City> querycityList(Integer provinceid) {
        List<City> cities = new ArrayList<>();
        try {
            City city = null;
            Class.forName("com.mysql.jdbc.Driver");
            coon = DriverManager.getConnection(url, username, password);
            sql = "select id,name from  city where provinceid=?";
            ps = coon.prepareStatement(sql);
//            设置省份的参数值
            ps.setInt(1, provinceid);
            rs = ps.executeQuery();
            while (rs.next()) {
                city = new City();
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("name"));
                cities.add(city);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (coon != null) {
                try {
                    coon.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

            return cities;

    }
}