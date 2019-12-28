package com.db.service;

import com.db.entity.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class MongoTemplateService {
    @Autowired
    private MongoTemplate mongoTemplate;

    private void insert(){
        // insert into fencai_test_user (id, user_name) values (1,'鲨鱼老师1');
        // 写入主键=1的用户，如果Mongo中没有主键=1的用户时新增，如果有做修
        mongoTemplate.save(new User(1L, "鲨鱼老师1"));

        // 如果Mongo中没有主键=1的用户时新增，如果有抛主键异常。
        mongoTemplate.insert(new User(1L, "鲨鱼老师"));

        // 批量新增 如果新增的对象Mongo中存在，抛主键异常。
        mongoTemplate.insertAll(
                Arrays.asList(
                        new User(2L, "海豚老师"),
                        new User(3L, "巧克力老师"),
                        new User(4L, "沙丁鱼老师")
                ));
    }

    private void query(){
        Query query = new Query();
        // where id in (3,4)
        query.addCriteria(Criteria.where("_id").in(3, 4));
        // order by user_name asc
        query.with(new Sort(Sort.Direction.ASC, "user_name"));
        // 查询一条记录
        // select * from t where id in (3,4) limit 1
        User user = mongoTemplate.findOne(query, User.class);
        // 查询所有的匹配记录
        // select * from t where id in (3,4)
        List<User> list = mongoTemplate.find(query, User.class);
        // 全表查询
        // select * from t
        List<User> list2 = mongoTemplate.findAll(User.class);

    }

    private void update(){
        Query query = new Query();
        // where id in (3,4)
        query.addCriteria(Criteria.where("_id").in(3, 4));
        // update xxx set user_name = '巧克力老师 4'
        Update update = Update.update("user_name", "巧克力老师 4");
        // TODO CASE 1 查询到的全部更新
        UpdateResult updateResult = mongoTemplate.updateMulti(query, update,
                User.class);
        // TODO CASE 2 查询更新第一条
        UpdateResult updateResult2 = mongoTemplate.updateFirst(query, update,
                User.class);
        // TODO CASE 3 有则更新，没有则新增
        UpdateResult updateResult3 = mongoTemplate.upsert(query, update,
                User.class);
    }

    private void delete(){
        // 主键删除 delete from fencai_test_user where id = 1;
        mongoTemplate.remove(new User(1L));
        // delete from fencai_test_user where user_name = '海豚老师';
        mongoTemplate.remove(Query.query(Criteria.where("user_name").is("海豚老师")),
                User.class);
        // delete from fencai_test_user where user_name in( '海豚老师');
        mongoTemplate.remove(Query.query(Criteria.where("user_name").in("海豚老师")),
                User.class);
    }
}
