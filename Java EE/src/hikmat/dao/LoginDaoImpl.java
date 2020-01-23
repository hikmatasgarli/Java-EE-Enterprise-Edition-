
package hikmat.dao;


import hikmat.model.Login;
import hikmat.model.Role;
import hikmat.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {

    @Override
    public Login login(String username, String password) throws Exception {
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT LU.ID,LU.USERNAME,LU.NAME,LU.SURNAME,R.ID ROLE_ID,ROLE_NAME FROM USERS LU "
                + "INNER JOIN ROLE R ON LU.ROLE_ID = R.ID "
                + "WHERE LU.ACTIVE = 1 AND LU.USERNAME = ? AND LU.PASSWORD = ? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    login.setId(rs.getLong("ID"));
                    login.setUsername(rs.getString("USERNAME"));
                    login.setName(rs.getString("NAME"));
                    login.setSurname(rs.getString("SURNAME"));

                    Role role = new Role();
                    role.setId(rs.getLong("ROLE_ID"));
                    role.setRoleName(rs.getString("ROLE_NAME"));
                    login.setRole(role);
                } else {
                    login = null;
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            // login = null;
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }


        return login;
    }

    @Override
    public Login checkEmail(String email) throws Exception {
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT LU.ID,LU.USERNAME,LU.NAME,LU.SURNAME FROM USERS LU "
                + "WHERE LU.USERNAME = ? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, email);
                rs = ps.executeQuery();
                if (rs.next()) {
                    login.setId(rs.getLong("ID"));
                    login.setUsername(rs.getString("USERNAME"));
                    login.setName(rs.getString("NAME"));
                    login.setSurname(rs.getString("SURNAME"));

                    Role role = new Role();
                    role.setId(rs.getLong("ROLE_ID"));
                    role.setRoleName(rs.getString("ROLE_NAME"));
                    login.setRole(role);
                } else {
                    login = null;
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            // login = null;
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }


        return login;
    }

    @Override
    public boolean updateToken(String token, Long userId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE LOGIN SET TOKEN = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, token);
                ps.setLong(2, userId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean addUser(Login login) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sorgu = "INSERT INTO USERS (USERNAME,PASSWORD,NAME,SURNAME) VALUES (?,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sorgu);
                ps.setString(1, login.getUsername());
                ps.setString(2, login.getPassword());
                ps.setString(3, login.getName());
                ps.setString(4, login.getSurname());
                ps.execute();
                result = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

}
