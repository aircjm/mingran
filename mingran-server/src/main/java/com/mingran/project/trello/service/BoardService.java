package com.mingran.project.trello.service;

import com.julienvey.trello.domain.Board;
import com.mingran.project.trello.vo.request.GetBoardRequest;

import java.util.List;

/**
 * 卡片service接口
 *
 * @author aircjm
 */
public interface BoardService {

    List<Board> getBoardList(GetBoardRequest request);


    Board getBoardDetail(GetBoardRequest request);

}
