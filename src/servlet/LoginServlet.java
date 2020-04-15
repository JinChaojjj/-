package servlet;

import entity.Manager;
import entity.User;
import util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        String is=request.getParameter("is");
        if (is==null){
            if ("/login".equals(path)) {
                login(request, response);
            }
        }else {
            if ("/login".equals(path)) {
                managerLogin(request, response);
            }
        }
    }

    protected void managerLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String managerId=request.getParameter("userId");
        String password=request.getParameter("password");
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        Manager manager =null;
        try {
            con= JDBCUtil.getConnection();
            con.setAutoCommit(false);
            String sql="select * from manager where manager_number=? and manager_password=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,managerId);
            ps.setString(2,password);
            resultSet=ps.executeQuery();
            if(resultSet.next()){
                manager=new Manager();
                manager.setManager_id(resultSet.getInt("manager_id"));
                manager.setManager_username(resultSet.getString("manager_number"));
                con.commit();

                request.getSession().setAttribute("manager", manager);
                response.sendRedirect(request.getContextPath() + "/manager.jsp");
                return;
            }else {
                con.commit();

                request.getSession().setAttribute("message", "管理员登录失败");
                response.sendRedirect(request.getContextPath() + "/login.jsp");


                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(con,ps,resultSet);
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId=request.getParameter("userId");
        String password=request.getParameter("password");

        Connection con=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        User user=null;
        try {
            con= JDBCUtil.getConnection();
            con.setAutoCommit(false);
            String sql="select * from user where user_userId=? and user_password=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,userId);
            ps.setString(2,password);
            resultSet=ps.executeQuery();
            if(resultSet.next()){
                user=new User();
                user.setId(resultSet.getInt("user_id"));
                user.setUser_userId(resultSet.getString("user_userId"));
                user.setUser_username(resultSet.getString("user_username"));
                user.setUser_password(resultSet.getString("user_password"));
                con.commit();

                request.getSession().setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/index1.jsp");
                return;
            }else {
                con.commit();

                request.getSession().setAttribute("message", "用户登录失败");
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(con,ps,resultSet);
        }
    }
}