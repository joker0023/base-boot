package com.jokerstation.boot.response;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ContentRowHeight(25)
public class ItemExcelResp implements Serializable {

	private static final long serialVersionUID = -7339427922717287542L;

	@ColumnWidth(value = 20)
	@ExcelProperty(value = "批次id", index = 0)
    private Integer id;

    @ColumnWidth(value = 20)
	@ExcelProperty(value = "数量", index = 1)
    private Integer totalNum;
    
    
    @ColumnWidth(value = 20)
	@ExcelProperty(value = "状态", index = 2)
    private Integer status;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ColumnWidth(value = 20)
	@ExcelProperty(value = "创建时间", index = 3)
    private Date createTime;

}
