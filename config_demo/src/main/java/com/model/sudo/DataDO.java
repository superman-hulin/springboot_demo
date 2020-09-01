package com.model.sudo;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DO（Domain Object）：领域对象，就是从现实世界中抽象出来的有形或无形的业务实体,对应数据表
 *
 * DAO层：
 *  List<UserDTO> getUsers(UserDO userDo);
 *
 * @author molamola
 * @since 2019-12-04
 */

public class DataDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据id
     */
    private String id;

    /**
     * 数据名
     */
    private String name;

    /**
     * 工程创建者id
     */
    private String uid;

    /**
     * 数据描述
     */
    private String description;

    /**
     * 数据创建时间
     */
    private LocalDateTime createTime;

    /**
     * 数据更改时间
     */
    private LocalDateTime updateTime;

    /**
     * 0:csv数据 1:json数据 2:xml数据
     */
    private String dataType;

    /**
     * 数据大小，单位为b
     */
    private String dataSize;

    /**
     * 数据绝对路径
     */
    private String dataPath;

    /**
     * 数据对应什么类型的实例
     */
    private String instanceType;

}
