package com.site.service.simple.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.entity.simple.News;
import com.site.service.simple.NewsService;
import com.site.service.simple.SimpleService;

@Service
public class SimpleServiceImpl implements SimpleService {

    @Autowired
    private NewsService newsService;

    @Override
    public boolean saveNews(News news) {

        boolean mf = newsService.addNews(news);// save master db

        boolean sf = newsService.addSlaveNews(news);// save slave db
        if (mf && sf)
            return true;
        else
            return false;
    }

}