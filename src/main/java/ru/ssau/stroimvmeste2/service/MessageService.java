package ru.ssau.stroimvmeste2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ssau.stroimvmeste2.dto.MessageDto;
import ru.ssau.stroimvmeste2.dto.UserLiteDto;
import ru.ssau.stroimvmeste2.model.Message;
import ru.ssau.stroimvmeste2.model.User;
import ru.ssau.stroimvmeste2.repository.MessageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MessageService {

    public final MessageRepository messageRepository;

    public List<MessageDto> getAllMessages() {
        List<MessageDto> messages = new ArrayList<>();
        for (Message message : messageRepository.findAll()) {
            messages.add(new MessageDto(message.getId(), message.getMessageText(), message.getUser().getUserName()));
        }
        return messages;
    }

    public Optional<Message> getMessage(Integer id) {
        return messageRepository.findById(id);
    }

    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message updateMessage(Message message) {
        return messageRepository.save(message);
    }

    public void deleteMessage(Integer id) {
        messageRepository.deleteById(id);
    }
}

