package com.mingran.project.trello.controller;

import com.mingran.common.vo.RestResponse;
import com.mingran.project.trello.service.CardService;
import com.mingran.project.trello.vo.request.SaveCardRequest;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

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

    @PostMapping("/save")
    public RestResponse savePage(@RequestBody @Valid SaveCardRequest request) {
        cardService.saveCard(request);
        return RestResponse.success();
    }
}
