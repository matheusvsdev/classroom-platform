package com.matheusvsdev.classroom_platform.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class LessonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private SectionEntity section;

    @OneToMany(mappedBy = "lesson")
    private List<DeliverEntity> deliveries = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tb_lessons_done",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = {
                            @JoinColumn(name = "user_id"),
                            @JoinColumn(name = "offer_id")
            }
    )
    private Set<EnrollmentEntity> enrollmentsDone = new HashSet<>();

    public LessonEntity() {
    }

    public LessonEntity(Long id, String title, Integer position, SectionEntity section) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.section = section;
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public SectionEntity getSection() {
        return section;
    }

    public void setSection(SectionEntity section) {
        this.section = section;
    }

    public List<DeliverEntity> getDeliveries() {
        return deliveries;
    }

    public Set<EnrollmentEntity> getEnrollmentsDone() {
        return enrollmentsDone;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        LessonEntity that = (LessonEntity) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
