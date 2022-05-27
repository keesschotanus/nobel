package com.schotanus.nobel.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Entity used for translations of text in columns.
 */
@Entity
@Table(name = "translations")
public class Translation extends AbstractEntity {
    @Column(name = "tablename", length = 50)
    private String tableName;

    @Column(name = "columnname", length = 50)
    private String columnName;

    @ManyToOne()
    @JoinColumn(name = "languageid", referencedColumnName = "id")
    private Language language;

    @Column(name = "translation", length = 50)
    private String description;

    public Translation() {
        // As required by JPA framework.
    }

    public Translation(final String tableName, final String columnName, final Language language, final String description) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.language = language;
        this.description = description;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(final String columnName) {
        this.columnName = columnName;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(final Language language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s:tbl=%s,col=%s,language=%s,descriptions=%s",
            super.toString(), this.tableName, this.columnName, this.language.getId(), this.description);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
          return true;
        }
      
        if (super.equals(other) && other instanceof Translation translation) {
            return Objects.equals(this.tableName, translation.tableName)
                && Objects.equals(this.columnName, translation.columnName)
                && Objects.equals(this.language.getId(), translation.language.getId())
                && Objects.equals(this.description, translation.description);
        }

        return false;
    }
  
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.tableName, this.columnName, this.language.getId(), this.description);
    }

}
