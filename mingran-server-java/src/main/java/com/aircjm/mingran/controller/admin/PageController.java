package com.aircjm.mingran.controller.admin;

import com.aircjm.mingran.controller.BaseController;
import com.aircjm.mingran.service.PageService;
import com.aircjm.mingran.vo.page.request.SavePageRequest;
import com.aircjm.mingran.vo.response.RestResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 后台文章管理 Controller
 *
 * @author bihell
 * @since 2017/7/11 19:52
 */
@RestController
@RequestMapping("/v1/api/admin/page")
@Api(value = "页面管理api")
public class PageController extends BaseController {

    /**
     * 页面service
     */
    @Resource
    private PageService pageService;


    @PostMapping(value = "save")
    @ApiOperation(value = "保存和更新页面")
    public RestResponseVo savePage(@RequestBody @Valid SavePageRequest request) {
        pageService.savePage(request);
        return RestResponseVo.success();
    }


}
