package com.dvortsov.cdstore.service;

import com.dvortsov.cdstore.dao.CDDao;
import com.dvortsov.cdstore.dao.entities.CD;
import com.dvortsov.cdstore.service.interfaces.CDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;

/**
 * @author Alexander Dvortsov
 * @version 1.0
 * @since 12.04.2016
 */

@Service
@Transactional
public class CDServiceImpl implements CDService {

    @Autowired
    private CDDao cdDao;

    @Override
    public List<CD> list(Integer offset, Integer maxResults) {
        return cdDao.list(offset, maxResults);
    }

    @Override
    public Long count() {
        return cdDao.count();
    }

    @Override
    public void parseXmlAndSave(File xmlFile) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("CD");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                CD cd = new CD();

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    cd.setTitle(eElement.getElementsByTagName("TITLE").item(0).getTextContent());
                    cd.setArtist(eElement.getElementsByTagName("ARTIST").item(0).getTextContent());
                    cd.setCountry(eElement.getElementsByTagName("COUNTRY").item(0).getTextContent());
                    cd.setCompany(eElement.getElementsByTagName("COMPANY").item(0).getTextContent());
                    cd.setPrice(Float.parseFloat(eElement.getElementsByTagName("PRICE").item(0).getTextContent()));
                    cd.setYear(Integer.parseInt(eElement.getElementsByTagName("YEAR").item(0).getTextContent()));
                    cdDao.merge(cd);
                }
                System.out.println(cd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<CD> getAll() {
        return cdDao.getAll();
    }
}
