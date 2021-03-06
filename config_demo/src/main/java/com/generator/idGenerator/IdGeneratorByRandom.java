package com.generator.idGenerator;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author : molamola
 * @Project: edu
 * @Description:
 * @date : 2020-02-21 11:35
 **/
public class IdGeneratorByRandom {

    public static synchronized String generateId(String module){
        String stamp = new Long(System.currentTimeMillis()).toString();
        return String.format("%s%s_%s",
                stamp.substring(8),
                RandomStringUtils.randomAlphanumeric(5),
                module);
    }

    public static void main(String[] args) {
        System.out.println(generateId("instance"));
    }
}
