package com.mingran.project.trello.service;

import com.mingran.project.trello.vo.request.SaveCardRequest;

/**
 * 卡片service接口
 *
 * @author aircjm
 */
public interface CardService {

    void saveCard(SaveCardRequest request);

}
