package com.zbw.server.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.ZonedDateTime;

@ApiModel("文件上传返回")
public class FileDTO {
    @ApiModelProperty("原始文件名")
    private String originName;
    @ApiModelProperty("文件扩展名")
    private String extName;
    @ApiModelProperty("上传后文件名")
    private String fileName;
    @ApiModelProperty("服务器上文件访问路径")
    private String path;
    @ApiModelProperty("文件大小")
    private Long size;
    @ApiModelProperty("上传时间")
    private ZonedDateTime zonedDateTime;

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
