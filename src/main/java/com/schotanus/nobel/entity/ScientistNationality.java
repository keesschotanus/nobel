package com.schotanus.nobel.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Keeps track of the nationality of a scientist, over time.
 */
@Entity
@Table(name = "Scientistnationalities")
public class ScientistNationality extends AbstractAuditTrailEntity {

    @Column(name = "scientistid", nullable = false)
    private Long scientistId;

    @Column(name = "countryid", nullable = false)
    private String countryId;

    @Column(name = "fromdate", length = 10, nullable = false)
    private Date fromDate;

    @Column(name = "untildate", length = 10)
    private Date untilDate;
               
    public ScientistNationality() {
        // As required by JPA framework.
    }

    public ScientistNationality(final Long scientistId, final String countryId, final Date fromDate, final Date untilDate) {
        this.scientistId = scientistId;
        this.countryId = countryId;
        this.fromDate = fromDate;
        this.untilDate = untilDate;
    }

    public Long getScientistId() {
        return scientistId;
    }

    public void setScientistId(final Long scientistId) {
        this.scientistId = scientistId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(final String countryId) {
        this.countryId = countryId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(final Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(final Date untilDate) {
        this.untilDate = untilDate;
    }

    @Override
    public String toString() {
        return String.format("%s:scientist=%d,country=%s,from=%tF,until=%tF",
            super.toString(), scientistId, countryId, fromDate, untilDate);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
          return true;
        }
      
        if (super.equals(other) && other instanceof ScientistNationality scientistNationality) {
            return Objects.equals(this.scientistId, scientistNationality.scientistId)
                && Objects.equals(this.countryId, scientistNationality.countryId)
                && Objects.equals(this.fromDate, scientistNationality.fromDate)
                && Objects.equals(this.untilDate, scientistNationality.untilDate);
        }

        return false;
    }
  
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), scientistId, countryId, fromDate, untilDate);
    }

}
