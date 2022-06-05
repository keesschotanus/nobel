package com.schotanus.nobel.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Account a user has, to access the application.
 */
@Entity
@Table(name = "Useraccounts")
public class UserAccount extends AbstractAuditTrailEntity {
    
    @Column
    private boolean active = true;

    @Column(length = 60, unique = true)
    private String name;

    @Column(length = 50)
    private String password;

    @Column(name = "passwordsalt", length = 20)
    private String salt;

    @Column(name = "passwordexpires")
    private Date expires;

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(final String salt) {
        this.salt = salt;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(final Date expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return String.format("%s:active=%b,name=%s,expires=%s",
            super.toString(), this.active, this.name, this.expires);
    }

    @Override
    public boolean equals(final Object other) {
          if (this == other) {
          return true;
        }
      
        if (super.equals(other) && other instanceof UserAccount account) {
            return this.active == account.active
                && Objects.equals(this.name, account.name)
                && Objects.equals(this.password, account.password)
                && Objects.equals(this.salt, account.salt)
                && Objects.equals(this.expires, account.expires);
        }

        return false;
    }
  
    @Override
    public int hashCode() {
      return Objects.hash(super.hashCode(), this.active, this.name,this.password, this.salt, this.expires);
    }
    
}
