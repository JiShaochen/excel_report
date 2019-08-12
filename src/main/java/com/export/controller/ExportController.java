package com.export.controller;

import com.export.entity.enums.export.SourceEnum;
import com.export.service.ExportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author JiShaochen
 * @date 2019/8/9 9:47
 * @desc 测试导出功能
 */
@RestController
@RequestMapping(value = "/export")
public class ExportController {


    @Resource
    ExportService exportService;

    @PostMapping
    public void exportDemo() {
        exportService.exportDemo();
    }

}