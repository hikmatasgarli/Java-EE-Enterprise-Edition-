package hikmat.service;

import hikmat.model.Message;

import java.util.List;

public interface MessageService {
    boolean addMessage (Message message) throws Exception;
    List<Message> getMessage() throws Exception;


}
