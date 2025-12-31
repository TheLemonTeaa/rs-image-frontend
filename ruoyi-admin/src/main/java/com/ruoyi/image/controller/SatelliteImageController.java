package com.ruoyi.image.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.image.domain.SatelliteImage;
import com.ruoyi.image.service.ISatelliteImageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 遥感图像信息管理Controller
 * 
 * @author Lemon
 * @date 2025-12-25
 */
@RestController
@RequestMapping("/image/image")
public class SatelliteImageController extends BaseController
{
    @Autowired
    private ISatelliteImageService satelliteImageService;

    /**
     * 查询遥感图像信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('image:image:list')")
    @GetMapping("/list")
    public TableDataInfo list(SatelliteImage satelliteImage)
    {
        startPage();
        List<SatelliteImage> list = satelliteImageService.selectSatelliteImageList(satelliteImage);
        return getDataTable(list);
    }

    /**
     * 导出遥感图像信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('image:image:export')")
    @Log(title = "遥感图像信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SatelliteImage satelliteImage)
    {
        List<SatelliteImage> list = satelliteImageService.selectSatelliteImageList(satelliteImage);
        ExcelUtil<SatelliteImage> util = new ExcelUtil<SatelliteImage>(SatelliteImage.class);
        util.exportExcel(response, list, "遥感图像信息管理数据");
    }

    /**
     * 获取遥感图像信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('image:image:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(satelliteImageService.selectSatelliteImageById(id));
    }

//    /**
//     * 新增遥感图像信息管理
//     */
//    @PreAuthorize("@ss.hasPermi('image:image:import')")
//    @Log(title = "遥感图像信息管理", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody SatelliteImage satelliteImage)
//    {
//        return toAjax(satelliteImageService.insertSatelliteImage(satelliteImage));
//    }

    /**
     *  批量新增遥感图像信息管理
     */
    @PreAuthorize("@ss.hasPermi('image:image:import')")
    @Log(title = "遥感图像信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody List<SatelliteImage> satelliteImages)
    {
        int count = satelliteImageService.insertSatelliteImages(satelliteImages);
        return AjaxResult.success("成功入库 " + count + " 条影像信息, 已过滤重复信息");
    }

    /**
     * 上传遥感图像
     */
    @PreAuthorize("@ss.hasPermi('image:image:import')")
    @Log(title = "遥感图像信息管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importZip")
    public AjaxResult importZip(@RequestParam("file") MultipartFile file) throws Exception {
        return satelliteImageService.importZip(file);
    }


    /**
     * 修改遥感图像信息管理
     */
    @PreAuthorize("@ss.hasPermi('image:image:edit')")
    @Log(title = "遥感图像信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SatelliteImage satelliteImage)
    {
        return toAjax(satelliteImageService.updateSatelliteImage(satelliteImage));
    }

    /**
     * 删除遥感图像信息管理
     */
    @PreAuthorize("@ss.hasPermi('image:image:remove')")
    @Log(title = "遥感图像信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(satelliteImageService.deleteSatelliteImageByIds(ids));
    }

    /**
     * 查询图表遥感图像信息
     */
    @PreAuthorize("@ss.hasPermi('image:image:stat')")
    @GetMapping("/statistics")
    public AjaxResult stat() {
        return satelliteImageService.getImageStat();
    }

}
