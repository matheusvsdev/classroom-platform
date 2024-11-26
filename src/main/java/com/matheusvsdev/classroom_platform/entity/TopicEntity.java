package com.matheusvsdev.classroom_platform.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_topic")
public class TopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private OfferEntity offer;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private LessonEntity lesson;

    @ManyToOne
    @JoinColumn(name = "reply_id")
    private ReplyEntity answer;

    @ManyToMany
    @JoinTable(name = "tb_topic_likes",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserEntity> likes = new HashSet<>();

    @OneToMany(mappedBy = "topic")
    private List<ReplyEntity> replies = new ArrayList<>();

    public TopicEntity() {
    }

    public TopicEntity(Long id, String title, String body, Instant moment, UserEntity author, OfferEntity offer, LessonEntity lesson) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.moment = moment;
        this.author = author;
        this.offer = offer;
        this.lesson = lesson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public OfferEntity getOffer() {
        return offer;
    }

    public void setOffer(OfferEntity offer) {
        this.offer = offer;
    }

    public LessonEntity getLesson() {
        return lesson;
    }

    public void setLesson(LessonEntity lesson) {
        this.lesson = lesson;
    }

    public ReplyEntity getAnswer() {
        return answer;
    }

    public void setAnswer(ReplyEntity answer) {
        this.answer = answer;
    }

    public Set<UserEntity> getLikes() {
        return likes;
    }

    public List<ReplyEntity> getReplies() {
        return replies;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        TopicEntity that = (TopicEntity) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
