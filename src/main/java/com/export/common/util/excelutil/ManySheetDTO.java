package com.export.common.util.excelutil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author JiShaochen
 * @date 2019/8/9 11:12
 * @desc 导出多sheet文件的时候的请求体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManySheetDTO<T> {
    private List<T> data;
    private String sheetName;
}