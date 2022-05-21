package cargomanage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Edit {
    //实现增删改查的方法

    DataBase bd = new DataBase();
    List<Cargo> list1 = new ArrayList<Cargo>();
    Connection conn = null;
    Statement state = null;
    ResultSet rs = null;
    PreparedStatement pstate;
    String [] str = new String[4];

    //将数据库数据导出
    public java.util.List<Cargo> ScoreDao() {
        conn = bd.getConn();
        try {
            state = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select * from goods";
        try {
            rs = state.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(rs.next()) {
                Cargo stu = new Cargo();
                stu.setId(rs.getInt("序号"));
                stu.setName(rs.getString("商品名"));
                stu.setPrice(rs.getString("价格"));
                stu.setNums(rs.getInt("数量"));
                list1.add(stu);
            }
            bd.close(rs, pstate, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list1;
    }

    //添加数据入库
    @SuppressWarnings("finally")
    public String Insert(String id,String name ,String price,String nums) {
        conn = bd.getConn();
        int result = -1;
        String sql = "insert into goods values("+id+",'"+name+"','"+price+"',"+nums+") ";
        try {
            pstate = conn.prepareStatement(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            result = pstate.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            bd.close(null, pstate, conn);
            if(result > 0) {
                return "添加成功";
            }else {
                return "添加失败";
            }
        }
    }


    //删除数据
    @SuppressWarnings("finally")
    public String Del(int row) {
        conn = bd.getConn();
        int result = -1;
        String sql = "delete from goods where 序号 = ? ";
        try {
            pstate = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            pstate.setInt(1, row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            result = pstate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            bd.close(null, pstate, conn);
            if(result > 0) {
                return "删除成功";
            }else {
                return "删除失败";
            }
        }
    }

    //修改数据，会把所有数据修改一遍id除外
    @SuppressWarnings("finally")
    public String Update(String id,String name ,String price,String nums) {
        conn = bd.getConn();
        int result = -1;
        String sql = "update goods set  商品名 ='"+name+"',价格 ='"+price+"',数量="+nums+" where 序号="+id+"";
        try {
            pstate = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            result = pstate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            bd.close(null, pstate, conn);
            if(result > 0) {
                return "修改成功";
            }else {
                return "修改失败";
            }
        }
    }


    //查询，返回查询出来的数据
    public String[] Select(String id) {
        conn = bd.getConn();
        int result = -1;
        String sql = "select * from goods where 序号 = ?";
        try {
            pstate = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstate.setString(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = pstate.executeQuery();
            while(rs.next()) {
                str[0] = rs.getString("序号");
                str[1] = rs.getString("商品名");
                str[2] = rs.getString("价格");
                str[3] = rs.getString("数量");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            bd.close(null, pstate, conn);
        }return str;
    }

}
