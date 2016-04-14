package com.dvortsov.cdstore.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alexander Dvortsov
 * @version 1.0
 * @since 12.04.2016
 */

@Entity
@Table(name = "cd")
@XmlRootElement(name = "CD")
@XmlAccessorType(XmlAccessType.FIELD)
public class CD {

    @Id
    @Column(name = "name", unique = true, nullable = false)
    @XmlElement(name = "TITLE")
    private String title;

    @Column(name = "artist", nullable = false)
    @XmlElement(name = "ARTIST")
    private String artist;

    @Column(name = "country", nullable = false)
    @XmlElement(name = "COUNTRY")
    private String country;

    @Column(name = "company", nullable = false)
    @XmlElement(name = "COMPANY")
    private String company;

    @Column(name = "price", nullable = false)
    @XmlElement(name = "PRICE")
    private float price;

    @Column(name = "year", nullable = false)
    @XmlElement(name = "YEAR")
    private int year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    // equals-hash-code//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CD cd = (CD) o;

        if (Float.compare(cd.price, price) != 0) return false;
        if (year != cd.year) return false;
        if (!title.equals(cd.title)) return false;
        if (artist != null ? !artist.equals(cd.artist) : cd.artist != null) return false;
        if (country != null ? !country.equals(cd.country) : cd.country != null) return false;
        return !(company != null ? !company.equals(cd.company) : cd.company != null);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + year;
        return result;
    }

    // toString
    @Override
    public String toString() {
        return "CD{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", country='" + country + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", year=" + year +
                '}';
    }
}
