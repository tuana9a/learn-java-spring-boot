package com.tuana9a.entities.query;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageJson<T> {

    public PageJson(Page<T> page) {
        this.content = page.getContent();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.last = page.isLast();
    }

    private List<T> content;
    private int totalPages;
    private long totalElements;
    private boolean last;
}
