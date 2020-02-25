package com.mingran.project.trello.service;

import com.julienvey.trello.domain.Card;
import com.mingran.project.trello.vo.request.AddCardRequest;
import com.mingran.project.trello.vo.request.ListCardRequest;
import com.mingran.project.trello.vo.request.SaveCardRequest;

import java.util.List;

/**
 * 卡片service接口
 *
 * @author aircjm
 */
public interface CardService {

    /**
     * 保存更新卡片
     *
     * @param request 请求入参
     */
    void saveCard(SaveCardRequest request);

    /**
     * 新增卡片
     *
     * @param request 新增卡片请求入参
     * @return 卡片信息（主要为卡片id）
     */
    Card addCard(AddCardRequest request);

    /**
     * 获取卡片集合
     *
     * @param request 入参集合
     * @return list集合
     */
    List<Card> list(ListCardRequest request);
}
