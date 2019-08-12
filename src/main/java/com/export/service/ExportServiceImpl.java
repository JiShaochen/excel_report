package com.export.service;

import com.dining.common.utils.mapper.MapperUtils;
import com.dining.common.utils.uuid.UUIDUtils;
import com.export.common.util.excelutil.ExcelUtils;
import com.export.common.util.excelutil.ManySheetDTO;
import com.export.entity.dto.export.ExportModelDTO;
import com.export.entity.enums.export.SourceEnum;
import com.export.entity.po.export.EsArticleEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JiShaochen
 * @date 2019/8/9 9:48
 * @desc 导出服务层
 */
@Service
public class ExportServiceImpl implements ExportService {

    public static void main(String[] args) {
        List<EsArticleEntity> data =  new ArrayList();
        EsArticleEntity esArticleEntity = new EsArticleEntity();
        esArticleEntity.setSource(SourceEnum.WE_CHAT);
        esArticleEntity.setTitle("这是一个无敌好看的");
        esArticleEntity.setSourceUrl("震惊");
        esArticleEntity.setPublishOn(LocalDateTime.now());
        data.add(esArticleEntity);
        List<ExportModelDTO> exportModelDTOS = MapperUtils.mapperList(data, ExportModelDTO.class);
        String url = "D://" + UUIDUtils.getUUID() + ".xlsx";
        try {
            ManySheetDTO data1 = new ManySheetDTO<>();
            data1.setData(exportModelDTOS);
            data1.setSheetName("第一个sheet名字");
            ExcelUtils.writeToFile(data1, null, url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exportDemo() {

    }
}