package com.matheusvsdev.classroom_platform;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_section")
public class SectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Integer position;

    private String imgUri;

    public SectionEntity() {
    }

    public SectionEntity(String imgUri, Integer position, String description, String title, Long id) {
        this.imgUri = imgUri;
        this.position = position;
        this.description = description;
        this.title = title;
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        SectionEntity that = (SectionEntity) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
