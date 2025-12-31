package com.ruoyi.system.untils.xml;

import com.ruoyi.common.utils.DateParseUtils;
import com.ruoyi.common.utils.xml.XmlParseUtils;
import com.ruoyi.image.domain.SatelliteImage;
import org.w3c.dom.Document;

import java.io.File;
import java.math.BigDecimal;

public class SatelliteImageXmlParser {

    public static SatelliteImage parse(File xmlFile) throws Exception {

        Document doc = XmlParseUtils.parse(xmlFile);
        SatelliteImage img = new SatelliteImage();

        // 基本信息
        img.setTaskId(XmlParseUtils.getString(doc, "/metadata/taskID"));
        img.setSatellite(XmlParseUtils.getString(doc, "/metadata/satellite"));
        img.setSensor(XmlParseUtils.getString(doc, "/metadata/sensor"));
        img.setProductId(XmlParseUtils.getString(doc, "/metadata/productID"));

        // 时间
        img.setImagingTime(DateParseUtils.parseUtc(XmlParseUtils.getString(doc, "/metadata/imagingTime")));
        img.setProduceTime(DateParseUtils.parseUtc(XmlParseUtils.getString(doc, "/metadata/produceTime")));

        // 产品信息
        img.setProductLevel(XmlParseUtils.getString(doc, "/metadata/productLevel"));
        img.setProductType(XmlParseUtils.getString(doc, "/metadata/productType"));

        // 影像参数
        img.setDataBits(XmlParseUtils.getInteger(doc, "/metadata/dataBits").longValue());
        img.setGsdMeter(BigDecimal.valueOf(XmlParseUtils.getDouble(doc, "/metadata/imageGSD")));
        img.setWidthPixels(XmlParseUtils.getInteger(doc, "/metadata/widthInPixels").longValue());
        img.setHeightPixels(XmlParseUtils.getInteger(doc, "/metadata/heightInPixels").longValue());

        // 波段信息
        img.setBands(XmlParseUtils.getString(doc, "/metadata/bands"));
        img.setWavelengthNm(XmlParseUtils.getDouble(doc, "/metadata/wavelength").longValue());
        img.setFwhmNm(XmlParseUtils.getDouble(doc, "/metadata/FWHM").longValue());

        // 中心经纬度（地图展示用，最重要）
        img.setCenterLat(BigDecimal.valueOf(XmlParseUtils.getDouble(doc, "/metadata/CenterLatitude")));
        img.setCenterLon(BigDecimal.valueOf(XmlParseUtils.getDouble(doc, "/metadata/CenterLongitude")));

        // 四角坐标（GIS 用）
        img.setUlLat(BigDecimal.valueOf(XmlParseUtils.getDouble(doc, "/metadata/UpperLeftLatitude")));
        img.setUlLon(BigDecimal.valueOf(XmlParseUtils.getDouble(doc, "/metadata/UpperLeftLongitude")));

        img.setUrLat(BigDecimal.valueOf(XmlParseUtils.getDouble(doc, "/metadata/UpperRightLatitude")));
        img.setUrLon(BigDecimal.valueOf(XmlParseUtils.getDouble(doc, "/metadata/UpperRightLongitude")));

        img.setLrLat(BigDecimal.valueOf(XmlParseUtils.getDouble(doc, "/metadata/LowerRightLatitude")));
        img.setLrLon(BigDecimal.valueOf(XmlParseUtils.getDouble(doc, "/metadata/LowerRightLongitude")));

        img.setLlLat(BigDecimal.valueOf(XmlParseUtils.getDouble(doc, "/metadata/LowerLeftLatitude")));
        img.setLlLon(BigDecimal.valueOf(XmlParseUtils.getDouble(doc, "/metadata/LowerLeftLongitude")));

        // 云量
        img.setCloudPercent(BigDecimal.valueOf(XmlParseUtils.getDouble(doc, "/metadata/CloudPercent")));

        return img;
    }
}
