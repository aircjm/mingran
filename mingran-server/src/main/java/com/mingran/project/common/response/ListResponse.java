package com.mingran.project.common.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

/**
 * @author aircjm
 */
@NoArgsConstructor
@AllArgsConstructor
public class ListResponse<T> {

    private Integer count;

    private Integer limit = 20;

    private List<T> list;

    private String scroll;


    public ListResponse(List<T> list) {
        if (Objects.nonNull(list) && list.size() > 0) {
            this.count = list.size();
            this.list = list;
        }
    }




}
