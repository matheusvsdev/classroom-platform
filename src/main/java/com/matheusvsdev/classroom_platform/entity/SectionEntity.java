package com.matheusvsdev.classroom_platform.entity;

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

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private ResourceEntity resource;

    @ManyToOne
    @JoinColumn(name = "prerequisite_id")
    private SectionEntity prerequisite;

    public SectionEntity() {
    }

    public SectionEntity(Long id, String title, String description, Integer position, String imgUri, ResourceEntity resource, SectionEntity prerequisite) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.position = position;
        this.imgUri = imgUri;
        this.resource = resource;
        this.prerequisite = prerequisite;
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

    public ResourceEntity getResource() {
        return resource;
    }

    public void setResource(ResourceEntity resource) {
        this.resource = resource;
    }

    public SectionEntity getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(SectionEntity prerequisite) {
        this.prerequisite = prerequisite;
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
