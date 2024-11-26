package com.matheusvsdev.classroom_platform.entity;

import com.matheusvsdev.classroom_platform.entity.pk.EnrollmentPK;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_enrollment")
public class EnrollmentEntity {

    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant enrollMoment;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant refundMoment;
    private boolean available;
    private boolean onlyUpdate;

    @ManyToMany(mappedBy = "enrollmentsDone")
    private Set<LessonEntity> lessonsDone = new HashSet<>();

    @OneToMany(mappedBy = "enrollment")
    private List<DeliverEntity> deliveries = new ArrayList<>();

    public EnrollmentEntity() {
    }

    public EnrollmentEntity(EnrollmentPK id, Instant enrollMoment, Instant refundMoment, boolean available, boolean onlyUpdate) {
        this.id = id;
        this.enrollMoment = enrollMoment;
        this.refundMoment = refundMoment;
        this.available = available;
        this.onlyUpdate = onlyUpdate;
    }

    public EnrollmentPK getId() {
        return id;
    }

    public void setId(EnrollmentPK id) {
        this.id = id;
    }

    public Instant getEnrollMoment() {
        return enrollMoment;
    }

    public void setEnrollMoment(Instant enrollMoment) {
        this.enrollMoment = enrollMoment;
    }

    public Instant getRefundMoment() {
        return refundMoment;
    }

    public void setRefundMoment(Instant refundMoment) {
        this.refundMoment = refundMoment;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isOnlyUpdate() {
        return onlyUpdate;
    }

    public void setOnlyUpdate(boolean onlyUpdate) {
        this.onlyUpdate = onlyUpdate;
    }

    public Set<LessonEntity> getLessonsDone() {
        return lessonsDone;
    }

    public List<DeliverEntity> getDeliveries() {
        return deliveries;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        EnrollmentEntity that = (EnrollmentEntity) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
