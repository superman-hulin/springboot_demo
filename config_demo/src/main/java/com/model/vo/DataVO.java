package com.model.vo;


/**
 * @author : molamola
 * @Description: VO（View Object）：视图对象，用于展示层，它的作用是把某个指定页面（或组件）的所有数据封装起来。
 *      controller层：
 *          public List<UserVO> getUsers(UserDTO userDto);
 *       将页面中用户填写的信息封装到UserDTO时，userId应该为空，然后业务层将UserDTO拷贝成UserDO,并生成userId
 *       将UserDO查询的对象拷贝成UserDTO，此时已经将不需要显示的数据进行了去除。
 *       最后UserDTO再拷贝成UserVO进行页面信息显示
 * @date : 2020-02-13 17:23
 **/
public class DataVO {

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
     * 数据描述
     */
    private String description;

    /**
     * 0:csv数据 1:json数据 2:xml数据
     */
    private String dataType;

    /**
     * 数据大小，单位为b
     */
    private String dataSize;

    /**
     * 数据对应什么类型的实例
     */
    private String instanceType;
}
