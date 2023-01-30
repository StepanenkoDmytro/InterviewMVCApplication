package com.dmytro.webquestion.PrepareForInterview.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long id;
    @Column(name = "post_name")
    private String name;
    @Column(name = "post_anons")
    private String anons;
    @Column(name = "post_full_text")
    private String fullText;

    public Post() {
    }

    public Post(String name, String anons, String fullText) {
        this.name = name;
        this.anons = anons;
        this.fullText = fullText;
    }

    public Post(long id, String name, String anons, String fullText) {
        this.id = id;
        this.name = name;
        this.anons = anons;
        this.fullText = fullText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", anons='" + anons + '\'' +
                ", fullText='" + fullText + '\'' +
                '}';
    }
}
