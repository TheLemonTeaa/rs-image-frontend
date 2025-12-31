package com.ruoyi.image.service;

import java.io.IOException;
import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.image.domain.SatelliteImage;
import org.springframework.web.multipart.MultipartFile;

/**
 * 遥感图像信息Service接口
 * 
 * @author Lemon
 * @date 2025-12-25
 */
public interface ISatelliteImageService 
{
    /**
     * 查询遥感图像信息
     * 
     * @param id 遥感图像信息主键
     * @return 遥感图像信息
     */
    public SatelliteImage selectSatelliteImageById(Long id);

    /**
     * 查询遥感图像信息
     *
     * @param productId 遥感图像信息主键
     * @return 遥感图像信息
     */
    public SatelliteImage selectSatelliteImageByProductId(String productId);

    /**
     * 查询遥感图像信息列表
     * 
     * @param satelliteImage 遥感图像信息
     * @return 遥感图像信息集合
     */
    public List<SatelliteImage> selectSatelliteImageList(SatelliteImage satelliteImage);

    /**
     * 新增遥感图像信息
     * 
     * @param satelliteImage 遥感图像信息
     * @return 结果
     */
    public int insertSatelliteImage(SatelliteImage satelliteImage);
    
    /**
     * 批量新增遥感图像信息
     *
     * @param satelliteImages 遥感图像信息
     * @return 结果
     */
    public int insertSatelliteImages(List<SatelliteImage> satelliteImages); // 批量插入
    
    /**
     * 上传遥感图像信息压缩包
     * @param zipFile 遥感图像压缩包
     * @return 结果
     */
    public AjaxResult importZip(MultipartFile zipFile) throws Exception;

    /**
     * 修改遥感图像信息
     * 
     * @param satelliteImage 遥感图像信息
     * @return 结果
     */
    public int updateSatelliteImage(SatelliteImage satelliteImage);

    /**
     * 批量删除遥感图像信息
     * 
     * @param ids 需要删除的遥感图像信息主键集合
     * @return 结果
     */
    public int deleteSatelliteImageByIds(Long[] ids);

    /**
     * 删除遥感图像信息信息
     * 
     * @param id 遥感图像信息主键
     * @return 结果
     */
    public int deleteSatelliteImageById(Long id);

    /**
     * 查询图表遥感图像信息
     *
     * @return 结果
     */
    public AjaxResult getImageStat();
}
