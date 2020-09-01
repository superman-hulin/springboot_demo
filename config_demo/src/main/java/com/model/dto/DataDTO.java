package com.model.dto;


import java.io.Serializable;

/**
 * @author : molamola
 * @Description: DTO（Data Transfer Object）：数据传输对象
 *      Service层：
            List<UserDTO> getUsers(UserDTO userDto);
 * @date : 2020-01-13 15:10
 **/

public class DataDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据id
     */
    private String id;

    /**
     * 工程创建者id
     */
    private String uid;

    /**
     * 数据名
     */
    private String name;

    /**
     * 数据描述
     */
    private String description;

    /**
     * 数据绝对路径
     */
    private String dataPath;

    /**
     * 数据的实例类型
     */
    private String instanceType;
}
