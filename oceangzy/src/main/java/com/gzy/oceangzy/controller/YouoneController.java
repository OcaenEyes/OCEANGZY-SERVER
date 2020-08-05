package com.gzy.oceangzy.controller;

import com.gzy.oceangzy.entity.YouoneEntity;
import com.gzy.oceangzy.service.YouoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "V0.0.1-20191210",description = "ONE 一个")
public class YouoneController {
    @Autowired
    private YouoneService youoneService;



    @ApiOperation(value = "倒序分页获取ONE返回map", notes = "默认的倒序，每页10条")
    @ApiImplicitParam(name = "page", value = "页码")
    @GetMapping("/getYouOneInfo")
    public Map getYouOneInfo(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<YouoneEntity> youoneEntityPage=  youoneService.listYouone(pageable);
        Map map = new HashMap();
        map.put("content",youoneEntityPage.getContent());
        map.put("totalPages",youoneEntityPage.getTotalPages());
        map.put("pageSize",youoneEntityPage.getSize());
        map.put("pageNum",youoneEntityPage.getNumber());
        map.put("first",youoneEntityPage.isFirst());
        map.put("last",youoneEntityPage.isLast());
        return map;
    }

}
