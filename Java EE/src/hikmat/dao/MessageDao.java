package hikmat.dao;

import hikmat.model.Message;

import java.util.List;

public interface MessageDao {
    boolean addMessage (Message message) throws Exception;
    List<Message> getMessage() throws Exception;
}
