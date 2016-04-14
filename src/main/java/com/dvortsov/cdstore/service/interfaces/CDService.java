package com.dvortsov.cdstore.service.interfaces;

import com.dvortsov.cdstore.dao.entities.CD;

import java.io.File;
import java.util.List;

/**
 * @author Alexander Dvortsov
 * @version 1.0
 * @since 12.04.2016
 */
public interface CDService {

    List<CD> list(Integer offset, Integer maxResults);

    Long count();

    void parseXmlAndSave(File xmlFile);

    List<CD> getAll();
}
