package io.openjob.server.repository.dao;

import io.openjob.server.repository.entity.NotifyGroup;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author inhere
 * @since 1.0.0
 */
public interface NotifyGroupDAO {

    /**
     * add NotifyGroup
     *
     * @param entity entity
     * @return id
     */
    Long add(NotifyGroup entity);

    /**
     * batch add NotifyGroup
     *
     * @param entityList entity list
     */
    void batchAdd(List<NotifyGroup> entityList);

    /**
     * get NotifyGroup by Id
     *
     * @param id id
     * @return NotifyGroup
     */
    NotifyGroup getById(Long id);

    /**
     * update NotifyGroup by ID
     *
     * @param entity entity
     * @return number
     */
    Integer updateById(NotifyGroup entity);

    /**
     * get NotifyGroup list by page, size
     *
     * @param page page
     * @param size size
     * @return NotifyGroup list
     */
    Page<NotifyGroup> getPageList(Integer page, Integer size);

}

