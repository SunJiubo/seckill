package com.nsmall.seckill.redis;

/**
 * @ClassName UserKey
 * @Description 用户键前缀
 * @Author sky
 * @Date 19-5-28 上午9:42
 * @Version 1.0
 */

public class UserKey extends BasePrefix{

    private UserKey( String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
