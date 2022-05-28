package com.schotanus.nobel.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.schotanus.util.DateUtil;


/**
 * Entity that allows tracking of the creation and last modification date.
 * For a created entity the version will be 0.
 */
@MappedSuperclass
public abstract class AbstractAuditTrailEntity extends AbstractEntity {
    
    @Column(name = "modifiedby")
    private Long modifiedBy;

    /**
     * Determines at which time this entity has been created/changed.
     * Note the "insertable = false", without it a null value will be inserted.
     */
    @Column(name = "modifiedat", insertable = false, updatable = false)
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
        return String.format("%s:id=%d,version=%d,modifiedBy=%d,modifiedAt=%s",
            this.getClass().getSimpleName(), this.id, this.version, this.modifiedBy,
            DateUtil.dateToIsoDateTime(this.modifiedAt));
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
