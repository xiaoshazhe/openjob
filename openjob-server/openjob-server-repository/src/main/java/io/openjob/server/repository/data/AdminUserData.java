package io.openjob.server.repository.data;

import io.openjob.server.repository.dto.AdminUserDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author inhere
 * @since 1.0.0
 */
public interface AdminUserData {

    /**
     * add AdminUser
     *
     * @param dto dto
     * @return id
     */
    Long add(AdminUserDTO dto);

    /**
     * batch add AdminUser
     *
     * @param dtoList dto list
     */
    void batchAdd(List<AdminUserDTO> dtoList);

    /**
     * get AdminUser by ID
     *
     * @param id id
     * @return AdminUser
     */
    AdminUserDTO getById(Long id);

    /**
     * get AdminUser by username
     *
     * @param username username
     * @return AdminUser
     */
    AdminUserDTO getByUsername(String username);

    /**
     * get AdminUser by token
     *
     * @param token token
     * @return AdminUserDTO or null
     */
    AdminUserDTO getByToken(String token);

    /**
     * update AdminUser by ID
     *
     * @param dto dto
     * @return number
     */
    Integer updateById(AdminUserDTO dto);

    /**
     * get AdminUser list by page
     *
     * @param page page
     * @param size size
     * @return AdminUser list
     */
    Page<AdminUserDTO> getPageList(Integer page, Integer size);
}

