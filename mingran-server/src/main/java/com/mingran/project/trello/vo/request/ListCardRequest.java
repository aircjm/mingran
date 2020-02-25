package com.mingran.project.trello.vo.request;

import lombok.Data;

/**
 * 卡片搜索
 *
 * @author aircjm
 */
@Data
public class ListCardRequest {

    /**
     * 看板id
     */
    private String boardId;

    /**
     * 集合id
     */
    private String listId;

    /**
     * 模糊搜索
     */
    private String name;
}
