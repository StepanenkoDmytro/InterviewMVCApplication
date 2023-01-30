package com.dmytro.webquestion.PrepareForInterview.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topics_java")
public class TopicJavaDeveloper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_java_id")
    private Long id;
    @Column(name = "topic_java_name")
    private String name;
    @Column(name = "topic_java_desc")
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,
            CascadeType.REFRESH,CascadeType.MERGE},
            mappedBy = "topic")
    private List<QuestionTopic> questionToTopic;

    public TopicJavaDeveloper() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public List<QuestionTopic> getQuestionToTopic() {
        return this.questionToTopic;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuestionToTopic(QuestionTopic question) {
        if(questionToTopic == null){
            questionToTopic = new ArrayList<>();
        }
        questionToTopic.add(question);
        question.setTopic(this);
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TopicJavaDeveloper)) return false;
        final TopicJavaDeveloper other = (TopicJavaDeveloper) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$questionToTopic = this.getQuestionToTopic();
        final Object other$questionToTopic = other.getQuestionToTopic();
        if (this$questionToTopic == null ? other$questionToTopic != null : !this$questionToTopic.equals(other$questionToTopic))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TopicJavaDeveloper;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $questionToTopic = this.getQuestionToTopic();
        result = result * PRIME + ($questionToTopic == null ? 43 : $questionToTopic.hashCode());
        return result;
    }

    public String toString() {
        return "TopicJavaDeveloper(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ")";
    }
}
