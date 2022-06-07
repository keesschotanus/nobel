package com.schotanus.nobel.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Category for which one can win a Nobel prize.
 */
@Entity
@Table(name = "Nobelprizecategories")
public class NobelPrizeCategory {   

    /**
     * The id of this category.
     */
    @Id
    private char id;

    @Column(length = 50, nullable = false)
    private String description;

    public NobelPrizeCategory() {
        // As required by JPA framework.
    }

    public NobelPrizeCategory(final char id) {
        this(id, "");
    }

    public NobelPrizeCategory(final char id, final String description) {
        this.id = id;
        this.description = description;
    }

    public char getId() {
        return id;
    }

    public void setId(final char id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String toString() {
        return String.format("%s:id=%c,description=%s",
            this.getClass().getSimpleName(), this.id, this.description);
    }

    /**
     * Since the id is not generated, it is the ony field used to check for equality.
     */
    @Override
    public boolean equals(final Object other) {
        if (this == other) {
          return true;
        }
      
        if (other instanceof NobelPrizeCategory nobelPrizeCategory ) {
            return this.id == nobelPrizeCategory.id;
        }

        return false;
    }
  
    @Override
    public int hashCode() {
      return Objects.hash(this.id);
    }


}
