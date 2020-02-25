package com.mingran.project.trello.service.impl;

import com.google.common.collect.Lists;
import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.Board;
import com.julienvey.trello.domain.Card;
import com.julienvey.trello.domain.Member;
import com.mingran.common.utils.DateUtils;
import com.mingran.common.utils.StringUtils;
import com.mingran.project.trello.service.CardService;
import com.mingran.project.trello.vo.request.AddCardRequest;
import com.mingran.project.trello.vo.request.ListCardRequest;
import com.mingran.project.trello.vo.request.SaveCardRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 卡片服务
 *
 * @author aircjm
 */
@Service
@Slf4j
public class CardServiceImpl implements CardService {

    @Resource
    Trello trello;

    @Override
    public void saveCard(SaveCardRequest request) {
        Member member = trello.getMemberInformation("chenjiaming");
        List<Board> boards = member.getBoards();
        Board inbox = boards.stream().filter(board -> "inbox".equalsIgnoreCase(board.getName())).collect(Collectors.toList()).get(0);
        Card create = new Card();
        create.setName(request.getTitle());
        create.setDesc(request.getContentMd());
        Card card = trello.getBoardLists(inbox.getId()).get(0).createCard(create);
        log.info("新增卡片的id为：{}", card.getId());

    }

    @Override
    public Card addCard(AddCardRequest request) {
        Card create = new Card();
        if (StringUtils.isEmpty(request.getTitle())) {
            create.setName(DateUtils.getTime() + "【新增 待处理】");
        } else {
            create.setName(request.getTitle());
        }
        return trello.createCard(request.getListId(), create);
    }

    @Override
    public List<Card> list(ListCardRequest request) {
        if (StringUtils.isNotBlank(request.getBoardId())) {
            return trello.getBoardCards(request.getBoardId());
        }

        if (StringUtils.isNotBlank(request.getListId())) {
            return trello.getListCards(request.getListId());
        }

        return Lists.newArrayList();
    }
}
