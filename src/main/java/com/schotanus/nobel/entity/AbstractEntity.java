package com.schotanus.nobel.entity;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

/**
 * Abstraction of an entity that uses a generated id and a version.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nobel_id_generator")
    @SequenceGenerator(name="nobel_id_generator", sequenceName="nobel_id_generator", initialValue = 1, allocationSize = 1)
    Long id;

    @Version
    Integer version;

    public Long getId() {
        return id;
    }
    
    public Integer getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return String.format("%s:id=%d,version=%d",
            this.getClass().getSimpleName(), this.id, this.version);
    }

    /**
     * Note: The id is not used to check for equality since it is automatically generated.
     */ 
    @Override
    public boolean equals(final Object other) {
          if (this == other) {
          return true;
        }
      
        if (other instanceof AbstractEntity entity) {
            return Objects.equals(this.version, entity.version);
        }

        return false;
    }
  
    @Override
    public int hashCode() {
      return Objects.hash(this.version);
    }
}
