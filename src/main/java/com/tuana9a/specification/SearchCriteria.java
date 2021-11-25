package com.tuana9a.specification;

import lombok.*;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}
