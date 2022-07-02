package com.schotanus.nobel.entity;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Abstraction of a scientist.
 */
@Entity
@Table(name = "Scientists")
public class Scientist extends AbstractAuditTrailEntity {
    @Column(length = 80, nullable = false)
    private String name;
    
    @Column(name = "displayname", length = 80)
    private String displayName;

    @Column(name = "birthdate", length = 10, nullable = false)
    private Date birthDate;

    @Column(name = "deathdate", length = 10)
    private Date deathDate;
               
    @ManyToOne()
    @JoinColumn(name = "birthcountryid", referencedColumnName = "id")
    private Country country;

    @Column(nullable = true)
    private byte[] image;

    @Column(length = 1024)
    private String description;

    @Column(name = "wikipediaurl", length = 256)
    private String wikipediaUrl;

    @OneToMany(mappedBy = "scientistId", fetch = FetchType.LAZY)
    private List<ScientistNationality> nationalities;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "NobelPrizeLaureates", joinColumns = @JoinColumn(name = "scientistid", referencedColumnName="id"),
     inverseJoinColumns = @JoinColumn(name = "nobelprizeid", referencedColumnName = "id"))
    private List<NobelPrize> nobelPrizes;

    public Scientist() {
        // As required by JPA framework.
    }

    public Scientist(final String name, final Date birthDate, final String description) {
        this.name = name;
        this.birthDate = birthDate;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(final Date deathDate) {
        this.deathDate = deathDate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(final byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getWikipediaUrl() {
        return wikipediaUrl;
    }

    public void setWikipediaUrl(final String wikipediaUrl) {
        this.wikipediaUrl = wikipediaUrl;
    }

    public List<ScientistNationality> getNationalities() {
        return nationalities;
    }

    public void setNationalities(final List<ScientistNationality> nationalities) {
        this.nationalities = nationalities;
    }

    public List<NobelPrize> getNobelPrizes() {
        return nobelPrizes;
    }

    public void setNobelPrizes(final List<NobelPrize> nobelPrizes) {
        this.nobelPrizes = nobelPrizes;
    }

    @Override
    public String toString() {
        return String.format("%s:name=%s,display=%s,birthDate=%tF,deathDate=%tF,country=%s,description=%s,wikipediaUrl=%s",
            super.toString(), this.name, this.displayName, this.birthDate, this.deathDate,
            this.country.getId(), this.description, this.wikipediaUrl);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
          return true;
        }
      
        if (super.equals(other) && other instanceof Scientist scientist) {
            return Objects.equals(this.name, scientist.name)
                && Objects.equals(this.displayName, scientist.displayName)
                && Objects.equals(this.birthDate, scientist.birthDate)
                && Objects.equals(this.deathDate, scientist.deathDate)
                && Objects.equals(this.country.getId(), scientist.country.getId())
                && Objects.equals(this.description, scientist.description)
                && Objects.equals(this.wikipediaUrl, scientist.wikipediaUrl);
        }

        return false;
    }
  
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.name, this.displayName, this.birthDate, this.deathDate,
            this.country.getId(), this.description, this.wikipediaUrl);
    }

}
