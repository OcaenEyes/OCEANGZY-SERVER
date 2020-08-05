package com.gzy.oceangzy.service;

import com.gzy.oceangzy.entity.YouoneEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface YouoneService {

    Page<YouoneEntity> listYouone(Pageable pageable);

    Page<YouoneEntity> getPage(Integer pageNum , Integer pageLimit);

    Page<YouoneEntity> getPageSort(Integer pageNum , Integer pageLimit);
}
