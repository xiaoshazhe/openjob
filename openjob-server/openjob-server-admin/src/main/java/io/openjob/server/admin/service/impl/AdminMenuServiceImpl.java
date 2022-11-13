package io.openjob.server.admin.service.impl;

import io.openjob.server.repository.data.AdminMenuData;
import io.openjob.server.admin.service.AdminMenuService;
import io.openjob.server.admin.request.AdminMenuAddRequest;
import io.openjob.server.admin.vo.AdminMenuAddVO;
import io.openjob.server.admin.request.AdminMenuQueryRequest;
import io.openjob.server.admin.vo.AdminMenuQueryVO;
import io.openjob.server.admin.request.AdminMenuUpdateRequest;
import io.openjob.server.admin.vo.AdminMenuUpdateVO;
import io.openjob.server.admin.request.AdminMenuDeleteRequest;
import io.openjob.server.admin.vo.AdminMenuDeleteVO;
import io.openjob.server.admin.request.AdminMenuListRequest;
import io.openjob.server.repository.dto.AdminMenuDTO;
import io.openjob.server.common.dto.PageDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author inhere
 * @date 2022-11-13 23:24:48
 * @since 1.0.0
 */
@Service
public class AdminMenuServiceImpl implements AdminMenuService {

    private final AdminMenuData adminMenuData;

    @Autowired
    public AdminMenuServiceImpl(AdminMenuData adminMenuData) {
        this.adminMenuData = adminMenuData;
    }

    @Override
    public AdminMenuAddVO add(AdminMenuAddRequest reqDTO) {
        AdminMenuDTO entDTO = new AdminMenuDTO();
        BeanUtils.copyProperties(reqDTO, entDTO);

        AdminMenuAddVO retVo = new AdminMenuAddVO();
        retVo.setId(adminMenuData.add(entDTO));

        return retVo;
    }

    @Override
    public AdminMenuUpdateVO update(AdminMenuUpdateRequest reqDTO) {
        AdminMenuDTO entDTO = new AdminMenuDTO();
        BeanUtils.copyProperties(reqDTO, entDTO);

        AdminMenuUpdateVO retVo = new AdminMenuUpdateVO();
        adminMenuData.update(entDTO);
        return retVo;
    }

    @Override
    public AdminMenuUpdateVO delete(AdminMenuDeleteRequest reqDTO) {
        AdminMenuDTO entDTO = new AdminMenuDTO();
        entDTO.setDeleted(CommonConst.YES);

        AdminMenuUpdateVO retVo = new AdminMenuUpdateVO();
        adminMenuData.update(entDTO);

        return retVo;
    }

    @Override
    public AdminMenuQueryVO query(AdminMenuQueryRequest reqDTO) {
        AdminMenuDTO entDTO = adminMenuData.getById(reqDTO.getId());
        AdminMenuQueryVO retVo = new AdminMenuQueryVO();

        BeanUtils.copyProperties(entDTO, retVo);

        return retVo;
    }

    @Override
    public PageDTO<AdminMenuQueryVO> getPageList(AdminMenuListRequest reqDTO) {
        // return adminMenuData.getPageList(reqDTO);
        return null;
    }
}

