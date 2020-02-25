package com.mingran.project.trello.controller;

import com.julienvey.trello.domain.Card;
import com.mingran.common.vo.RestResponse;
import com.mingran.project.common.response.ListResponse;
import com.mingran.project.trello.service.CardService;
import com.mingran.project.trello.vo.request.AddCardRequest;
import com.mingran.project.trello.vo.request.ListCardRequest;
import com.mingran.project.trello.vo.request.SaveCardRequest;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * trello对外卡片card提供接口
 *
 * @author aircjm
 */
@RestController
@RequestMapping(value = "/api/card/")
@Api(value = "CardController", description = "卡片博客API")
public class CardController {


    @Resource
    private CardService cardService;


    @PostMapping("/add")
    public RestResponse<Card> addPage(@RequestBody @Valid AddCardRequest request) {
        Card card = cardService.addCard(request);
        return RestResponse.success(card);
    }


    @PostMapping("/save")
    public RestResponse savePage(@RequestBody @Valid SaveCardRequest request) {
        cardService.saveCard(request);
        return RestResponse.success();
    }



    @GetMapping("/list")
    public RestResponse savePage(@RequestBody @Valid ListCardRequest request) {
         List<Card> cardList = cardService.list(request);
        return RestResponse.success(new ListResponse<>(cardList));
    }



}
