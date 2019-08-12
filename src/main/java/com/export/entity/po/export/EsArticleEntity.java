package com.export.entity.po.export;

import com.export.entity.enums.export.SourceEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * @author Xu DoubleS
 * @date 2017/12/6 - 星期三 - 17:47
 * @desc 文章搜索实体
 */

@Data
public class EsArticleEntity {

    /* id */
    private Integer id;

    /* 慧科API文章ID */
    private String docId;

    /* 标题 */
    private String title;

    /* 作者 */
    private String author;

    /* 来源 */
    private SourceEnum source;

    /* 原文地址 */
    private String sourceUrl;

    /* 正文 */
    private String content;

    /* 小型图片地址 */
    private String smallImageUrl;

    /* 热点大图片地址 */
    private String largeImageUrl;

    /* 正文大图图片地址 */
    private String contentImageUrl;

    /* 详情页相关文章地址 */
    private String similarImageUrl;

    /* 一级分类导航ID */
    private Integer firstCategoryId;

    /* 一级分类导航名称 */
    private String firstCategoryName;

    /* 二级分类导航ID */
    private Integer secondCategoryId;

    /* 二级分类导航名称 */
    private String secondCategoryName;

    /* 发布日期 */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishOn;

    /* 发布日期（秒级别，因目前ES时间查询有问题，则暂时根据秒来查询） */
    private Long publishOnSecond;

    /* 发布区域 */
    private String pubRegion;

    /* 文章分类ID */
    private Integer headerId;

    /* 文章分类ID */
    private String typeId;

    /* 文章状态 */
    private String status;

    /* 文章来源ID */
    private Integer sourceId;

    private String section;

    private String columnName;

    /* 相似文章数量 */
    private Integer similarCount;

    /* 修改时间 */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyOn;

    /* 同步时间 */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime syncOn;

    private Long syncOnSecond;

    public String getSource(){
        return this.source.getValue();
    }
}
