package com.tuana9a.controller;

import com.tuana9a.entities.query.PageJson;
import com.tuana9a.service.BaseService;
import com.tuana9a.entities.query.JsonResult;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public abstract class BaseController<T> {
    private final BaseService<T> service;

    public BaseController(BaseService<T> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<JsonResult<List<T>>> search(
            @RequestParam(value = "searches", required = false) List<String> searches,
            @RequestParam(value = "sort", required = false) String sort) throws Exception{
        return JsonResult.success(service.filter(searches, sort));
    }

    @GetMapping("/page")
    public ResponseEntity<JsonResult<PageJson<T>>> searchWithPage(
            @RequestParam(value = "searches", required = false) List<String> searches,
            @RequestParam(value = "sort", required = false) String sort,
            Pageable pageable) throws Exception{
        return JsonResult.success(service.filterPageable(searches, pageable, sort));
    }
}
