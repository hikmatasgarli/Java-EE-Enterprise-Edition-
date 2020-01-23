package hikmat.dao;

import hikmat.model.Message;
import hikmat.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {


    @Override
    public boolean addMessage(Message message) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        // ResultSet rs = null; Netice qaitmir die ehtiyyac yoxdur
        String sorgu = "INSERT INTO MESSAGE(NAME ,MESSAGE) VALUE (?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sorgu);
                ps.setString(1,message.getName());
                ps.setString(2,message.getMessage());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //c.commit();   //  DML emeliyyatlarndan sonra commit etmek lazimdir.
            JdbcUtility.close(c, ps, null);
        }

        return result;
    }

    @Override
    public List<Message> getMessage() throws Exception {
        List<Message> messageList = new ArrayList<>();
        Connection c = null; // baza ile elaqe yaradir.
        PreparedStatement ps = null; // sql - i run etmek ucun hazirlayir
        ResultSet rs = null; // sql -den qayidan neticeni ozunde saxlayir
        String sql = "SELECT NAME,MESSAGE FROM MESSAGE";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Message message = new Message();
                    message.setName(rs.getString("NAME"));
                    message.setMessage(rs.getString("MESSAGE"));
                    messageList.add(message);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return messageList;
    }
}
