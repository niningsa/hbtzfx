package com.hbtzfx.dao;

import com.hbtzfx.entity.TelDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelDao {

    @Select("select tel_id as telId, telnumber, user_name as userName, desction, date_format(created_on, '%Y-%c-%d %h:%i:%s' ) createdOnStr from cms_tel")
    List<TelDO> findTel();

    @Insert("insert into cms_tel(telnumber, user_name, desction, search_type) values('${telnumber}', '${userName}', '${desction}', '${searchType}')")
    int saveTel(TelDO tel);

}
