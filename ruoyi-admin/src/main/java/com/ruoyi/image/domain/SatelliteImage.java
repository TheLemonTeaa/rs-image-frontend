package com.ruoyi.image.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 遥感图像信息管理对象 satellite_image
 * 
 * @author Lemon
 * @date 2025-12-25
 */
public class SatelliteImage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 任务ID */
    @Excel(name = "任务ID")
    private String taskId;

    /** 产品ID */
    @Excel(name = "产品ID")
    private String productId;

    /** 卫星名称 */
    @Excel(name = "卫星名称")
    private String satellite;

    /** 传感器 */
    @Excel(name = "传感器")
    private String sensor;

    /** 产品级别 */
    private String productLevel;

    /** 产品类型 */
    @Excel(name = "产品类型")
    private String productType;

    /** 成像时间(UTC) */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    @Excel(name = "成像时间(UTC)", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date imagingTime;

    /** 生成时间(UTC) */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    @Excel(name = "生成时间(UTC)", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date produceTime;

    /** 波段 */
    private String bands;

    /** 中心波长(nm) */
    private Long wavelengthNm;

    /** 半峰全宽(nm) */
    private Long fwhmNm;

    /** 影像分辨率(m) */
    private BigDecimal gsdMeter;

    /** 数据位深 */
    private Long dataBits;

    /** 影像宽(px) */
    @Excel(name = "影像宽(px)")
    private Long widthPixels;

    /** 影像高(px) */
    @Excel(name = "影像高(px)")
    private Long heightPixels;

    /** 云量(%) */
    @Excel(name = "云量(%)")
    private BigDecimal cloudPercent;

    /** 中心纬度 */
    @Excel(name = "中心纬度")
    private BigDecimal centerLat;

    /** 中心经度 */
    @Excel(name = "中心经度")
    private BigDecimal centerLon;

    /** 拇指图访问路径 */
    @Excel(name = "拇指图")
    private String thumbUrl;

    /** 左上纬度 */
    private BigDecimal ulLat;

    /** 左上经度 */
    private BigDecimal ulLon;

    /** 右上纬度 */
    private BigDecimal urLat;

    /** 右上经度 */
    private BigDecimal urLon;

    /** 右下纬度 */
    private BigDecimal lrLat;

    /** 右下经度 */
    private BigDecimal lrLon;

    /** 左下纬度 */
    private BigDecimal llLat;

    /** 左下经度 */
    private BigDecimal llLon;

    /** 太阳方位角 */
    private BigDecimal solarAzimuth;

    /** 太阳高度角 */
    private BigDecimal solarElevation;

    /** 卫星方位角 */
    private BigDecimal satelliteAzimuth;

    /** 卫星高度角 */
    private BigDecimal satelliteElevation;

    /** 姿态滚转角 */
    private BigDecimal roll;

    /** 姿态俯仰角 */
    private BigDecimal pitch;

    /** 姿态偏航角 */
    private BigDecimal yaw;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTaskId(String taskId) 
    {
        this.taskId = taskId;
    }

    public String getTaskId() 
    {
        return taskId;
    }

    public void setProductId(String productId) 
    {
        this.productId = productId;
    }

    public String getProductId() 
    {
        return productId;
    }

    public void setSatellite(String satellite) 
    {
        this.satellite = satellite;
    }

    public String getSatellite() 
    {
        return satellite;
    }

    public void setSensor(String sensor) 
    {
        this.sensor = sensor;
    }

    public String getSensor() 
    {
        return sensor;
    }

    public void setProductLevel(String productLevel) 
    {
        this.productLevel = productLevel;
    }

    public String getProductLevel() 
    {
        return productLevel;
    }

    public void setProductType(String productType) 
    {
        this.productType = productType;
    }

    public String getProductType() 
    {
        return productType;
    }

    public void setImagingTime(Date imagingTime) 
    {
        this.imagingTime = imagingTime;
    }

    public Date getImagingTime() 
    {
        return imagingTime;
    }

    public void setProduceTime(Date produceTime) 
    {
        this.produceTime = produceTime;
    }

    public Date getProduceTime() 
    {
        return produceTime;
    }

    public void setBands(String bands) 
    {
        this.bands = bands;
    }

    public String getBands() 
    {
        return bands;
    }

    public void setWavelengthNm(Long wavelengthNm) 
    {
        this.wavelengthNm = wavelengthNm;
    }

    public Long getWavelengthNm() 
    {
        return wavelengthNm;
    }

    public void setFwhmNm(Long fwhmNm) 
    {
        this.fwhmNm = fwhmNm;
    }

    public Long getFwhmNm() 
    {
        return fwhmNm;
    }

    public void setGsdMeter(BigDecimal gsdMeter) 
    {
        this.gsdMeter = gsdMeter;
    }

    public BigDecimal getGsdMeter() 
    {
        return gsdMeter;
    }

    public void setDataBits(Long dataBits) 
    {
        this.dataBits = dataBits;
    }

    public Long getDataBits() 
    {
        return dataBits;
    }

    public void setWidthPixels(Long widthPixels) 
    {
        this.widthPixels = widthPixels;
    }

    public Long getWidthPixels() 
    {
        return widthPixels;
    }

    public void setHeightPixels(Long heightPixels) 
    {
        this.heightPixels = heightPixels;
    }

    public Long getHeightPixels() 
    {
        return heightPixels;
    }

    public void setCloudPercent(BigDecimal cloudPercent) 
    {
        this.cloudPercent = cloudPercent;
    }

    public BigDecimal getCloudPercent() 
    {
        return cloudPercent;
    }

    public void setCenterLat(BigDecimal centerLat) 
    {
        this.centerLat = centerLat;
    }

    public BigDecimal getCenterLat() 
    {
        return centerLat;
    }

    public void setCenterLon(BigDecimal centerLon) 
    {
        this.centerLon = centerLon;
    }

    public BigDecimal getCenterLon() 
    {
        return centerLon;
    }

    public void setUlLat(BigDecimal ulLat) 
    {
        this.ulLat = ulLat;
    }

    public BigDecimal getUlLat() 
    {
        return ulLat;
    }

    public void setUlLon(BigDecimal ulLon) 
    {
        this.ulLon = ulLon;
    }

    public BigDecimal getUlLon() 
    {
        return ulLon;
    }

    public void setUrLat(BigDecimal urLat) 
    {
        this.urLat = urLat;
    }

    public BigDecimal getUrLat() 
    {
        return urLat;
    }

    public void setUrLon(BigDecimal urLon) 
    {
        this.urLon = urLon;
    }

    public BigDecimal getUrLon() 
    {
        return urLon;
    }

    public void setLrLat(BigDecimal lrLat) 
    {
        this.lrLat = lrLat;
    }

    public BigDecimal getLrLat() 
    {
        return lrLat;
    }

    public void setLrLon(BigDecimal lrLon) 
    {
        this.lrLon = lrLon;
    }

    public BigDecimal getLrLon() 
    {
        return lrLon;
    }

    public void setLlLat(BigDecimal llLat) 
    {
        this.llLat = llLat;
    }

    public BigDecimal getLlLat() 
    {
        return llLat;
    }

    public void setLlLon(BigDecimal llLon) 
    {
        this.llLon = llLon;
    }

    public BigDecimal getLlLon() 
    {
        return llLon;
    }

    public void setSolarAzimuth(BigDecimal solarAzimuth) 
    {
        this.solarAzimuth = solarAzimuth;
    }

    public BigDecimal getSolarAzimuth() 
    {
        return solarAzimuth;
    }

    public void setSolarElevation(BigDecimal solarElevation) 
    {
        this.solarElevation = solarElevation;
    }

    public BigDecimal getSolarElevation() 
    {
        return solarElevation;
    }

    public void setSatelliteAzimuth(BigDecimal satelliteAzimuth) 
    {
        this.satelliteAzimuth = satelliteAzimuth;
    }

    public BigDecimal getSatelliteAzimuth() 
    {
        return satelliteAzimuth;
    }

    public void setSatelliteElevation(BigDecimal satelliteElevation) 
    {
        this.satelliteElevation = satelliteElevation;
    }

    public BigDecimal getSatelliteElevation() 
    {
        return satelliteElevation;
    }

    public void setRoll(BigDecimal roll) 
    {
        this.roll = roll;
    }

    public BigDecimal getRoll() 
    {
        return roll;
    }

    public void setPitch(BigDecimal pitch) 
    {
        this.pitch = pitch;
    }

    public BigDecimal getPitch() 
    {
        return pitch;
    }

    public void setYaw(BigDecimal yaw) 
    {
        this.yaw = yaw;
    }

    public BigDecimal getYaw() 
    {
        return yaw;
    }

    public void setThumbUrl(String thumbUrl) { this.thumbUrl = thumbUrl; }

    public String getThumbUrl() { return thumbUrl; }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("taskId", getTaskId())
            .append("productId", getProductId())
            .append("satellite", getSatellite())
            .append("sensor", getSensor())
            .append("productLevel", getProductLevel())
            .append("productType", getProductType())
            .append("imagingTime", getImagingTime())
            .append("produceTime", getProduceTime())
            .append("bands", getBands())
            .append("wavelengthNm", getWavelengthNm())
            .append("fwhmNm", getFwhmNm())
            .append("gsdMeter", getGsdMeter())
            .append("dataBits", getDataBits())
            .append("widthPixels", getWidthPixels())
            .append("heightPixels", getHeightPixels())
            .append("cloudPercent", getCloudPercent())
            .append("centerLat", getCenterLat())
            .append("centerLon", getCenterLon())
            .append("ulLat", getUlLat())
            .append("ulLon", getUlLon())
            .append("urLat", getUrLat())
            .append("urLon", getUrLon())
            .append("lrLat", getLrLat())
            .append("lrLon", getLrLon())
            .append("llLat", getLlLat())
            .append("llLon", getLlLon())
            .append("solarAzimuth", getSolarAzimuth())
            .append("solarElevation", getSolarElevation())
            .append("satelliteAzimuth", getSatelliteAzimuth())
            .append("satelliteElevation", getSatelliteElevation())
            .append("roll", getRoll())
            .append("pitch", getPitch())
            .append("yaw", getYaw())
            .append("thumbUrl", getThumbUrl())
            .toString();
    }
}
