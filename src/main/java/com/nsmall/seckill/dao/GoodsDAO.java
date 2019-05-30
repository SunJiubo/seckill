package com.nsmall.seckill.dao;

import com.nsmall.seckill.domain.User;
import com.nsmall.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsDAO {

    String TABLE_NAME_SKGOODS = " seckill.sk_goods_seckill sg";
    String TABLE_NAME_GOODS = " seckill.sk_goods g";
//    String INSERT_FIELDS = " nickname, password, salt,head,register_date,last_login_date,login_count ";
    String INSERT_FIELDS_SKGOODS = " sg.stock_count,sg.start_date,sg.end_date,sg.seckill_price ";
//    String SELECT_FIELDS = " id,"+INSERT_FIELDS;

    @Select({"select g.*, ",INSERT_FIELDS_SKGOODS, " from ",TABLE_NAME_SKGOODS," left join ",
            TABLE_NAME_GOODS," on sg.goods_id =g.id"})
    public List<GoodsVo> listGoodsVo();

    @Select({"select g.*, ",INSERT_FIELDS_SKGOODS, " from ",TABLE_NAME_SKGOODS," left join ",
            TABLE_NAME_GOODS," on sg.goods_id =g.id where g.id = #{goodsId}"})
    public GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

}
