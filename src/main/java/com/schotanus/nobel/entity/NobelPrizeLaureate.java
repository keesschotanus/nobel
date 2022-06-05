package com.schotanus.nobel.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A Nobel prize laureate.
 */
@Entity
@Table(name = "Nobelprizelaureates")
public class NobelPrizeLaureate extends AbstractAuditTrailEntity {

    @Column(name = "nobelprizeid", nullable = false)
    private Long nobelPrizeId;

    @Column(name = "scientistid", nullable = false)
    private Long scientistId;

    @Column(length = 1024)
    private String description;

    @Column(name = "fractionnominator", length = 1, nullable = false)
    private int fractionNominator;

    @Column(name = "fractiondenominator", length = 1, nullable = false)
    private int fractionDenominator;

    @Override
    public String toString() {
        return String.format("%s:nobelPrize=%d,scientist=%d,nominator=%d,denominator=%d",
            super.toString(), this.nobelPrizeId, this.scientistId, this.fractionNominator, this.fractionDenominator);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
          return true;
        }
      
        if (super.equals(other) && other instanceof NobelPrizeLaureate nobelPrizeLaureate) {
            return Objects.equals(this.nobelPrizeId, nobelPrizeLaureate.nobelPrizeId)
                && Objects.equals(this.scientistId, nobelPrizeLaureate.scientistId)
                && Objects.equals(this.description, nobelPrizeLaureate.description)
                && Objects.equals(this.fractionNominator,nobelPrizeLaureate.fractionNominator)
                && Objects.equals(this.fractionDenominator,nobelPrizeLaureate.fractionDenominator);
        }

        return false;
    }
  
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.nobelPrizeId, this.scientistId,
            this.description, this.fractionNominator, this.fractionDenominator);
    }

}
