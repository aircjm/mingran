package com.aircjm.mingran.domain;

import java.time.LocalDateTime;

/**
 * 页面实体
 *
 * @author aircjm
 */
public class Page {

    /**
     * id
     */
    private Long id;


    /**
     * 文章个人分类
     */
    private String category;

    /**
     * 文章的封面图片路径
     */

    private String coverPath;

    /**
     * 文章的标题
     */
    private String title;

    /**
     * 文章内容的html形式
     */
    private String contentHtml;

    /**
     * 文章内容的md形式
     */
    private String contentMd;

    /**
     * 文章的摘要
     */
    private String summary;


    /**
     * 文章口令(公开文章口令为空)
     */
    private String password;

    /**
     * 文章阅读量
     */
    private int reads;

    /**
     * 文章点赞数
     */
    private int likes;

    /**
     * 文章评论数
     */
    private int comments;

    /**
     * 创建人
     */
    private Integer createMan;


    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private Integer updateMan;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


    /**
     * 是否删除
     */
    private Integer isDel;
}
