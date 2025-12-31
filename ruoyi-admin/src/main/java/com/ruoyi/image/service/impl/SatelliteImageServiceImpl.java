package com.ruoyi.image.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.OssUtils;
import com.ruoyi.common.utils.file.ZipUtils;
import com.ruoyi.system.untils.xml.SatelliteImageXmlParser;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.image.mapper.SatelliteImageMapper;
import com.ruoyi.image.domain.SatelliteImage;
import com.ruoyi.image.service.ISatelliteImageService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 遥感图像信息管理Service业务层处理
 * 
 * @author Lemon
 * @date 2025-12-25
 */
@Service
public class SatelliteImageServiceImpl implements ISatelliteImageService 
{
    @Autowired
    private SatelliteImageMapper satelliteImageMapper;
    @Autowired
    private OssUtils ossUtils;

    /**
     * 查询遥感图像信息管理
     * 
     * @param id 遥感图像信息管理主键
     * @return 遥感图像信息管理
     */
    @Override
    public SatelliteImage selectSatelliteImageById(Long id)
    {
        return satelliteImageMapper.selectSatelliteImageById(id);
    }

    /**
     * 查询遥感图像信息管理
     *
     * @param productId 遥感图像信息管理主键
     * @return 遥感图像信息管理
     */
    @Override
    public SatelliteImage selectSatelliteImageByProductId(String productId)
    {
        return satelliteImageMapper.selectSatelliteImageByProductId(productId);
    }

    /**
     * 查询遥感图像信息管理列表
     * 
     * @param satelliteImage 遥感图像信息管理
     * @return 遥感图像信息管理
     */
    @Override
    public List<SatelliteImage> selectSatelliteImageList(SatelliteImage satelliteImage)
    {
        return satelliteImageMapper.selectSatelliteImageList(satelliteImage);
    }

    /**
     * 新增遥感图像信息管理
     * 
     * @param satelliteImage 遥感图像信息管理
     * @return 结果
     */
    @Override
    public int insertSatelliteImage(SatelliteImage satelliteImage)
    {
        return satelliteImageMapper.insertSatelliteImage(satelliteImage);
    }

    /**
     * 上传遥感图像信息压缩包
     * @param zipFile 遥感图像压缩包
     * @return 结果
     */
    @Override
    public AjaxResult importZip(MultipartFile zipFile) throws Exception {
        if (zipFile == null || zipFile.isEmpty()) {
            return AjaxResult.error("上传文件为空");
        }

        // 1. 创建解压目录
        String baseDir = RuoYiConfig.getUploadPath() + "/rs_image/";
        String unzipDir = baseDir + System.currentTimeMillis() + "/";
        File tempDir = new File(unzipDir);
        tempDir.mkdirs();

        try {
            // 2. 解压
            ZipUtils.unzip(zipFile, unzipDir);
            File[] imageDirs = tempDir.listFiles(File::isDirectory);
            if(imageDirs == null || imageDirs.length == 0) {
                // tempDir 中没有子文件夹，检查是否有 XML 或拇指图
                boolean hasXmlOrThumb = Arrays.stream(tempDir.listFiles())
                        .anyMatch(f -> f.getName().toLowerCase().endsWith(".xml")
                                || f.getName().toLowerCase().endsWith(".jpg"));
                if (hasXmlOrThumb) {
                    // 把 tempDir 当作单个影像文件夹处理
                    imageDirs = new File[] { tempDir };
                } else {
                    return AjaxResult.error("压缩包中未发现影像文件夹或必要文件");
                }
            }
            List<SatelliteImage> resultList = new ArrayList<>();

            for(File imageDir : imageDirs) {
                // 3. 扫描文件
                File xml = null, thumb = null;
                for (File file : Objects.requireNonNull(imageDir.listFiles())) {
                    String name = file.getName().toLowerCase();
                    if (name.endsWith(".xml")) xml = file;
                    else if (name.endsWith(".jpg")) thumb = file;
                }

                if (xml == null) {
                    return AjaxResult.error("压缩包内缺少必要文件");
                }

                // 4. 解析 XML
                SatelliteImage imageInfo = SatelliteImageXmlParser.parse(xml);

                String productId = imageInfo.getProductId();

                // 上传拇指图到 OSS
                if(thumb != null) {
                    String ossPath = "thumb/" + productId + ".jpg";
                    String thumbUrl = ossUtils.upload(new FileInputStream(thumb), ossPath);
                    imageInfo.setThumbUrl(thumbUrl);
                }

                resultList.add(imageInfo);
            }

            return AjaxResult.success(resultList);
        } finally {
            // 删除临时解压文件
            FileUtils.deleteDirectory(tempDir);
        }
    }

    /**
     * 新增遥感图像信息管理
     *
     * @param satelliteImages 遥感图像信息管理
     * @return 结果
     */
    @Override
    public int insertSatelliteImages(List<SatelliteImage> satelliteImages) {
        int count = 0;
        for (SatelliteImage satelliteImage : satelliteImages) {
            // 可加判断避免重复
            SatelliteImage exist = satelliteImageMapper.selectSatelliteImageByProductId(satelliteImage.getProductId());
            if (exist == null) {
                satelliteImageMapper.insertSatelliteImage(satelliteImage);
                count++;
            }
        }
        return count;
    }

    /**
     * 修改遥感图像信息管理
     * 
     * @param satelliteImage 遥感图像信息管理
     * @return 结果
     */
    @Override
    public int updateSatelliteImage(SatelliteImage satelliteImage)
    {
        return satelliteImageMapper.updateSatelliteImage(satelliteImage);
    }

    /**
     * 批量删除遥感图像信息管理
     * 
     * @param ids 需要删除的遥感图像信息管理主键
     * @return 结果
     */
    @Override
    public int deleteSatelliteImageByIds(Long[] ids)
    {
        return satelliteImageMapper.deleteSatelliteImageByIds(ids);
    }

    /**
     * 删除遥感图像信息管理信息
     * 
     * @param id 遥感图像信息管理主键
     * @return 结果
     */
    @Override
    public int deleteSatelliteImageById(Long id)
    {
        return satelliteImageMapper.deleteSatelliteImageById(id);
    }

    /**
     * 查询图表遥感图像信息
     *
     * @return 结果
     */
    @Override
    public AjaxResult getImageStat() {
        Map<String, Object> result = new HashMap<>();

        result.put("timeStat", satelliteImageMapper.statByTime());
        result.put("satelliteStat", satelliteImageMapper.statBySatellite());

        // 云量需要转成前端 bar 数据
        List<Map<String, Object>> cloudRaw = satelliteImageMapper.statByCloud();
        int[] cloudStat = new int[4];
        for (Map<String, Object> m : cloudRaw) {
            String range = (String) m.get("cloud_range");
            int count = ((Number) m.get("count")).intValue();
            switch (range) {
                case "0-10%": cloudStat[0] = count; break;
                case "10-30%": cloudStat[1] = count; break;
                case "30-60%": cloudStat[2] = count; break;
                case "60-100%": cloudStat[3] = count; break;
            }
        }
        result.put("cloudStat", cloudStat);

        result.put("spaceStat", satelliteImageMapper.statByRegion());

        return AjaxResult.success(result);
    }

}
