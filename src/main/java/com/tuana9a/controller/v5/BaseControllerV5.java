package com.tuana9a.controller.v5;

import com.tuana9a.service.BaseService;
import com.tuana9a.models.JsonResponse;
import com.tuana9a.utils.JsonResponseUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public abstract class BaseControllerV5<T> {
    private final BaseService<T> service;
    private final JsonResponseUtils jsonResponseUtils;

    public BaseControllerV5(BaseService<T> service, JsonResponseUtils jsonResponseUtils) {
        this.service = service;
        this.jsonResponseUtils = jsonResponseUtils;
    }

    @GetMapping()
    public ResponseEntity<JsonResponse> search(
            @RequestParam(value = "queries", required = false) List<String> queries,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "isPageable") Boolean isPageable,
            Pageable pageable) throws Exception {

        Object result = isPageable ?
                service.filter(queries, pageable, sort) :
                service.filter(queries, sort);

        return jsonResponseUtils.ok(result);
    }
}
