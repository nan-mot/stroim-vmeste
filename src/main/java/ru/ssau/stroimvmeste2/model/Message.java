package ru.ssau.stroimvmeste2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "message_text")
    private String messageText;
    @ManyToOne
    @JoinColumn(name="topicId", insertable=false, updatable=false)
    private Topic topic;
    @ManyToOne
    @JoinColumn(name="userId", insertable=false, updatable=false)
    private User user;
}
