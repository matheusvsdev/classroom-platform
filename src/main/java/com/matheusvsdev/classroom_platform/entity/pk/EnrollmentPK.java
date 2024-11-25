package com.matheusvsdev.classroom_platform.entity.pk;

import com.matheusvsdev.classroom_platform.entity.OfferEntity;
import com.matheusvsdev.classroom_platform.entity.UserEntity;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class EnrollmentPK {

    private UserEntity user;

    private OfferEntity offer;

    public EnrollmentPK() {
    }

    public EnrollmentPK(UserEntity user, OfferEntity offer) {
        this.user = user;
        this.offer = offer;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public OfferEntity getOffer() {
        return offer;
    }

    public void setOffer(OfferEntity offer) {
        this.offer = offer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EnrollmentPK other = (EnrollmentPK) obj;
        return Objects.equals(offer, other.offer) && Objects.equals(user, other.user);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(user);
        result = 31 * result + Objects.hashCode(offer);
        return result;
    }
}
