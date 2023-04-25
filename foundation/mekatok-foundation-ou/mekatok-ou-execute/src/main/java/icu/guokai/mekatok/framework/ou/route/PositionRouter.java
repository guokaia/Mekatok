package icu.guokai.mekatok.framework.ou.route;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import icu.guokai.mekatok.framework.core.constant.Global;
import icu.guokai.mekatok.framework.core.route.Router;
import icu.guokai.mekatok.framework.core.route.support.SimpleCrudSupport;
import icu.guokai.mekatok.framework.ou.OuModuleInfo;
import icu.guokai.mekatok.framework.ou.model.table.Role;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 职位相关服务接口
 * @author GuoKai
 * @date 2021/8/20
 */
@RestController
@Api(tags = "职位相关接口")
@ApiSupport(author = Global.GK)
@RequestMapping(OuModuleInfo.MODULE_ROUTE_URI + "/position")
public class PositionRouter extends Router implements SimpleCrudSupport<Role> {
}
