package com.mingran.project.trello.vo.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 新增card数据vo
 *
 * @author aircjm
 */
@Data
public class AddCardRequest {

    /**
     * 集合id
     */
    @NotEmpty(message = "对应集合id不能为空")
    private String listId;

    private String title;

    private String contentMd;

}
