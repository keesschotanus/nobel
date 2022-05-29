package com.schotanus.nobel.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * ISO-3166 country.
 */
@Entity
@Table(name = "Countries")
public class Country {
    
    /**
     * The id should be an ISO 3166-1 alpha-2 code.
     */
    @Id
    private String id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String nationality;

    public Country() {
        // As required by JPA framework.
    }

    public Country(final String id, final String name, final String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(final String nationality) {
        this.nationality = nationality;
    }

    public String toString() {
        return String.format("%s:id=%s,name=%s,nationality=%s",
            this.getClass().getSimpleName(), this.id, this.name, this.nationality);
    }

    /**
     * Since the id is not generated, it is the ony field used to check for equality.
     */
    @Override
    public boolean equals(final Object other) {
        if (this == other) {
          return true;
        }
      
        if (other instanceof Country country) {
            return this.id == country.id;
        }

        return false;
    }
  
    @Override
    public int hashCode() {
      return Objects.hash(this.id);
    }

}
