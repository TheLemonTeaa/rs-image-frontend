package com.ruoyi.image.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.image.domain.SatelliteImage;

/**
 * 遥感图像信息管理Mapper接口
 * 
 * @author Lemon
 * @date 2025-12-25
 */
public interface SatelliteImageMapper 
{
    /**
     * 查询遥感图像信息管理
     * 
     * @param id 遥感图像信息管理主键
     * @return 遥感图像信息管理
     */
    public SatelliteImage selectSatelliteImageById(Long id);

    /**
     * 查询遥感图像信息管理
     *
     * @param productId 遥感图像信息管理主键
     * @return 遥感图像信息管理
     */
    public SatelliteImage selectSatelliteImageByProductId(String productId);

    /**
     * 查询遥感图像信息管理列表
     * 
     * @param satelliteImage 遥感图像信息管理
     * @return 遥感图像信息管理集合
     */
    public List<SatelliteImage> selectSatelliteImageList(SatelliteImage satelliteImage);

    /**
     * 新增遥感图像信息管理
     * 
     * @param satelliteImage 遥感图像信息管理
     * @return 结果
     */
    public int insertSatelliteImage(SatelliteImage satelliteImage);

    /**
     * 修改遥感图像信息管理
     * 
     * @param satelliteImage 遥感图像信息管理
     * @return 结果
     */
    public int updateSatelliteImage(SatelliteImage satelliteImage);

    /**
     * 删除遥感图像信息管理
     * 
     * @param id 遥感图像信息管理主键
     * @return 结果
     */
    public int deleteSatelliteImageById(Long id);

    /**
     * 批量删除遥感图像信息管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSatelliteImageByIds(Long[] ids);

    /**
     * 查询图表遥感图像信息
     *
     * @return 结果
     */

    List<Map<String, Object>> statByTime();

    List<Map<String, Object>> statBySatellite();

    List<Map<String, Object>> statByCloud();

    List<Map<String, Object>> statByRegion();
}
