package com.schotanus.nobel.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;


/**
 * Entity that allows tracking of the creation and last modification date.
 * For a created entity the version will be 0.
 */
@MappedSuperclass
public abstract class AbstractAuditTrailEntity extends AbstractEntity {
    
    @Column(name = "modifiedby")
    private Long modifiedBy;

    @Column(name = "modifiedat")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date modifiedAt;

    AbstractAuditTrailEntity() {
        // As required by JPA framework.
    }

    AbstractAuditTrailEntity(final Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    @Override
    public String toString() {
        return String.format("%s:id=%d,version=%d,modifiedBy=%d,modifiedAt=%tc",
            this.getClass().getSimpleName(), this.id, this.version, this.modifiedBy, this.modifiedAt);
    }

    /**
     * Note: The modifiedAt field is not used to check for equality since it is automatically generated.
     */ 
    @Override
    public boolean equals(final Object other) {
  
        if (this == other) {
          return true;
        }
      
        if (super.equals(other) && other instanceof AbstractAuditTrailEntity entity) {
            return Objects.equals(this.modifiedBy, entity.modifiedBy);
        }

        return false;
    }

    @Override
    public int hashCode() {
      return Objects.hash(super.hashCode(), this.modifiedBy);
    }

}
