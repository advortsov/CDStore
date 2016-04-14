package com.dvortsov.cdstore.service.objects;

import com.dvortsov.cdstore.dao.entities.CD;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "CATALOG")
public class Catalog {

    private List<CD> allCDs;

    protected Catalog() {
    }

    public Catalog(List<CD> allCDs) {
        this.allCDs = allCDs;
    }

    @javax.xml.bind.annotation.XmlElement(name = "CD")
    public List<CD> getAllCDs() {
        return allCDs;
    }
}