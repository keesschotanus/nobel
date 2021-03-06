package com.schotanus.nobel.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * A Nobel prize.
 */
@Entity
@Table(name = "Nobelprizes", indexes = {
    @Index(name = "np_year_cat_u", columnList = "year,categoryId", unique = true)
})
public class NobelPrize extends AbstractAuditTrailEntity {

    @ManyToOne()
    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    private NobelPrizeCategory category;

    @Column(name = "year", nullable = false, unique = true)
    private int year;

    @Column(name = "nobelurl", length = 256, nullable = true)
    private String nobelUrl;

    @JsonIgnore
    @ManyToMany(mappedBy = "nobelPrizes", fetch = FetchType.LAZY)
    private List<Scientist> scientists;

    public NobelPrizeCategory getCategory() {
        return category;
    }

    public void setCategory(final NobelPrizeCategory category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNobelUrl() {
        return nobelUrl;
    }

    public void setNobelUrl(String nobelUrl) {
        this.nobelUrl = nobelUrl;
    }

    public List<Scientist> getScientists() {
        return scientists;
    }

    public void setScientists(final List<Scientist> scientists) {
        this.scientists = scientists;
    }

    @Override
    public String toString() {
        return String.format("%s:cat=%c,year=%d,url=%s",
            super.toString(), this.category.getId(), this.year, this.nobelUrl);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
          return true;
        }
      
        if (super.equals(other) && other instanceof NobelPrize nobelPrize) {
            return Objects.equals(this.category.getId(), nobelPrize.category.getId())
                && Objects.equals(this.year, nobelPrize.year)
                && Objects.equals(this.nobelUrl, nobelPrize.nobelUrl);
        }

        return false;
    }
  
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.category.getId(), this.year, this.nobelUrl);
    }

}
