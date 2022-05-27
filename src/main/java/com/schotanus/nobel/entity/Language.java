package com.schotanus.nobel.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Abstraction of a language.
 */
@Entity
@Table(name = "Languages")
public class Language {
    
    /**
     * The id should be an ISO 639-1 code.
     */
    @Id
    private String id;

    @Column(length = 50, nullable = false)
    private String description;

    public Language() {
        // As required by JPA framework.
    }

    public Language(final String id, final String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String toString() {
        return String.format("%s:id=%s,description=%s",
            this.getClass().getSimpleName(), this.id, this.description);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
          return true;
        }
      
        if (other instanceof Language language) {
            return this.id == language.id;
        }

        return false;
    }
  
    @Override
    public int hashCode() {
      return Objects.hash(this.id);
    }

}
