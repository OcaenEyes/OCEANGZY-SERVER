package com.gzy.oceangzy.service;

import com.gzy.oceangzy.entity.YouoneEntity;
import com.gzy.oceangzy.repository.YouoneRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class YouoneServiceImpl implements com.gzy.oceangzy.service.YouoneService {

    @Autowired
    private YouoneRepositoy youoneRepositoy;

    @Override
    public Page<YouoneEntity> listYouone(Pageable pageable) {
        return youoneRepositoy.findAll(pageable);
    }

    @Override
    public Page<YouoneEntity> getPage(Integer pageNum, Integer pageLimit) {
        Pageable pageable = PageRequest.of(pageNum-1,pageLimit);
        return youoneRepositoy.findAll(pageable);
    }

    @Override
    public Page<YouoneEntity> getPageSort(Integer pageNum, Integer pageLimit) {
        Sort sort = Sort.by(Sort.Order.desc("id"));
        PageRequest pageRequest = PageRequest.of(pageNum-1,pageLimit,sort);
        return youoneRepositoy.findAll(pageRequest);
    }
}
