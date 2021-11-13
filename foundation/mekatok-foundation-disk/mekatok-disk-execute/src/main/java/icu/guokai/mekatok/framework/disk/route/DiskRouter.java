package icu.guokai.mekatok.framework.disk.route;

import icu.guokai.mekatok.framework.core.route.Router;
import icu.guokai.mekatok.framework.core.route.support.SimpleCreateSupport;
import icu.guokai.mekatok.framework.disk.DiskCenter;
import icu.guokai.mekatok.framework.disk.DiskModuleInfo;
import icu.guokai.mekatok.framework.disk.model.table.DiskDirectory;
import icu.guokai.mekatok.framework.disk.model.table.DiskFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 磁盘相关接口路由
 * @author GuoKai
 * @date 2021/11/4
 */
@RestController
@SuppressWarnings("all")
@Api(tags = "磁盘相关接口路由")
@RequestMapping(DiskModuleInfo.MODULE_ROUTE_URI + "/disk")
public class DiskRouter extends Router implements SimpleCreateSupport<DiskDirectory> {

    @ApiOperation(value = "上传文件", notes = "上传至默认目录")
    @PostMapping(value = "/file",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<DiskFile> upload(@ApiParam("文件") @RequestPart(value = "file") MultipartFile file){
        return upload(file,null);
    }

    @ApiOperation(value = "上传文件")
    @PostMapping(value = "/file/{dirId}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<DiskFile> upload(@ApiParam("文件") @RequestPart(value = "file") MultipartFile file,
                                           @ApiParam("目录ID") @PathVariable(value = "dirId") String path){
        return script(() -> DiskCenter.uploadFile(file, path));
    }

    @DeleteMapping("/file/{fileId}")
    @ApiOperation(value = "简单增删改查-删除",notes = "用于删除文件数据")
    @ApiImplicitParam(name = "fileId", value = "主键", paramType = "path", required = true, dataTypeClass = String.class)
    public ResponseEntity<Boolean> deleteFile(@ApiParam("文件ID") @PathVariable(value = "fileId") String fileId){
        return script(() -> DiskCenter.removeFile(fileId));
    }

    @DeleteMapping("/dir/{dirId}")
    @ApiOperation(value = "简单增删改查-删除",notes = "用于删除目录数据")
    @ApiImplicitParam(name = "dirId", value = "主键", paramType = "path", required = true, dataTypeClass = String.class)
    public ResponseEntity<Boolean> deleteDirectory(@ApiParam("目录ID") @PathVariable(value = "dirId") String dirId){
        return script(() -> DiskCenter.removeDirectory(dirId));
    }

    @PutMapping("/file/trash/{id}")
    @ApiOperation(value = "文件移动至垃圾箱",notes = "用于更新数据")
    @ApiImplicitParam(name = "fileId", value = "主键", paramType = "path", required = true, dataTypeClass = String.class)
    public ResponseEntity<Boolean> fileToTrash(@ApiParam("文件ID") @PathVariable(value = "fileId") String fileId){
        return script(() -> DiskCenter.fileToTrash(fileId));
    }

    @PutMapping("/dir/trash/{id}")
    @ApiOperation(value = "目录移动至垃圾箱",notes = "用于更新数据")
    @ApiImplicitParam(name = "dirId", value = "主键", paramType = "path", required = true, dataTypeClass = String.class)
    public ResponseEntity<Boolean> dirToTrash(@ApiParam("目录ID") @PathVariable(value = "dirId") String dirId){
        return script(() -> DiskCenter.fileToTrash(dirId));
    }

}