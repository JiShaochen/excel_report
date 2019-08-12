package com.export.entity.dto.export;

import com.export.common.util.excelutil.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author JiShaochen
 * @date 2019/8/9 10:02
 * @desc 导出模板
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExportModelDTO {
    @Excel(name = "序号")
    private Integer serialNumber;
    @Excel(name = "来源")
    private String source;
    @Excel(name = "标题")
    private String title;
    @Excel(name = "原文链接")
    private String url;
    @Excel(name = "发布时间")
    private LocalDateTime publishOn;

//    public void getPublishOn(LocalDateTime now){
//        this.publishOn = "asoihgaosihg";
//    }


}