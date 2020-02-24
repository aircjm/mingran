package com.mingran.project.trello.vo.request;

import lombok.Data;

/**
 * 请求获取Board数据vo
 *
 * @author aircjm
 */
@Data
public class GetBoardRequest {

    private String boardName;

    private String boardId;

}
