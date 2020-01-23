package hikmat.service;

import hikmat.dao.MessageDao;
import hikmat.model.Message;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    private MessageDao messageDao;

    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }


    @Override
    public boolean addMessage(Message message) throws Exception {
        return messageDao.addMessage(message);
    }

    @Override
    public List<Message> getMessage() throws Exception {
        return messageDao.getMessage();
    }
}
