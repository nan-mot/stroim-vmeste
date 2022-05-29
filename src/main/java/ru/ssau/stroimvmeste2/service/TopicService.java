package ru.ssau.stroimvmeste2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.stroimvmeste2.dto.MessageDto;
import ru.ssau.stroimvmeste2.dto.TopicFullDto;
import ru.ssau.stroimvmeste2.dto.TopicLiteDto;
import ru.ssau.stroimvmeste2.model.Message;
import ru.ssau.stroimvmeste2.model.Topic;
import ru.ssau.stroimvmeste2.repository.TopicRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicService {
    public final TopicRepository topicRepository;


    public List<TopicLiteDto> getAllTopics() {
        List<TopicLiteDto> topics = new ArrayList<>();
        for (Topic topic : topicRepository.findAll()) {
            topics.add(new TopicLiteDto(topic.getId(), topic.getTopicName()));
        }
        return topics;
    }

    public Optional<TopicFullDto> getTopic(Integer id) {
        Optional<Topic> topicOptional = topicRepository.findById(id);
        if (topicOptional.isPresent()) {

            Topic topic = topicOptional.get();
            List<MessageDto> messageDto = new ArrayList<>();
            for (Message message : topic.getTopicMessages()) {
                messageDto.add(new MessageDto(message.getId(), message.getMessageText(),message.getUser().getUserName()));
            }
            return Optional.of(new TopicFullDto(topic.getId(), topic.getTopicName(), topic.getTopicDescription(), topic.getProject().getId(), messageDto));
        } else {
            return Optional.empty();
        }
    }

    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public void deleteTopic(Integer id) {
        topicRepository.deleteById(id);
    }
}
