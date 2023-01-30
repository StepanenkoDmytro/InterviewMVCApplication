package com.dmytro.webquestion.PrepareForInterview.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class QuestionTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;
    @Column(name = "question_name")
    private String question;
    @Column(name = "question_answer")
    private String answer;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,
            CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "topic_java_id")
    private TopicJavaDeveloper topic;

    public QuestionTopic() {
    }

    public Long getId() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public TopicJavaDeveloper getTopic() {
        return this.topic;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setTopic(TopicJavaDeveloper topic) {
        this.topic = topic;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof QuestionTopic)) return false;
        final QuestionTopic other = (QuestionTopic) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$question = this.getQuestion();
        final Object other$question = other.getQuestion();
        if (this$question == null ? other$question != null : !this$question.equals(other$question)) return false;
        final Object this$answer = this.getAnswer();
        final Object other$answer = other.getAnswer();
        if (this$answer == null ? other$answer != null : !this$answer.equals(other$answer)) return false;
        final Object this$topic = this.getTopic();
        final Object other$topic = other.getTopic();
        if (this$topic == null ? other$topic != null : !this$topic.equals(other$topic)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof QuestionTopic;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $question = this.getQuestion();
        result = result * PRIME + ($question == null ? 43 : $question.hashCode());
        final Object $answer = this.getAnswer();
        result = result * PRIME + ($answer == null ? 43 : $answer.hashCode());
        final Object $topic = this.getTopic();
        result = result * PRIME + ($topic == null ? 43 : $topic.hashCode());
        return result;
    }

    public String toString() {
        return "QuestionTopic(id=" + this.getId() + ", question=" + this.getQuestion() + ", answer=" + this.getAnswer() + ", topic=" + this.getTopic() + ")";
    }
}
