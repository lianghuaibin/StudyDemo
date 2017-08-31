package com.lhb.study.devSmallDemo.mongodb;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author lianghuaibin
 * @since 2017/8/31 16:06
 */
public class MongoTest {

    @Before
    public void before(){
        MongoDbApi.connect("lhb_test", "t_user", "10.13.92.9", 27017);
    }

    @Test
    public void testInsert(){
        Document document = new Document();
        document.append("name", "liang").append("gender", "male");
        MongoDbApi.insert(document);
    }

    @Test
    public void testFindAll(){
        List<Document> results = MongoDbApi.findAll();
        for(Document doc : results){
            System.out.println(doc.toJson());
        }
    }

    @Test
    public void testFindBy(){
        Document filter = new Document();
        filter.append("name", "liang");
        List<Document> results = MongoDbApi.findBy(filter);
        for(Document doc : results){
            System.out.println(doc.toJson());
        }
    }

    @Test
    public void testUpdateOne(){
        Document filter = new Document();
        filter.append("gender", "male");

        //注意update文档里要包含"$set"字段
        Document update = new Document();
        update.append("$set", new Document("gender", "female"));
        UpdateResult result = MongoDbApi.updateOne(filter, update);
        System.out.println(JSON.toJSONString(result));
        System.out.println("matched count = " + result.getMatchedCount());
    }

    @Test
    public void testUpdateMany(){
        Document filter = new Document();
        filter.append("gender", "female");

        //注意update文档里要包含"$set"字段
        Document update = new Document();
        update.append("$set", new Document("gender", "male"));
        UpdateResult result = MongoDbApi.updateMany(filter, update);
        System.out.println("matched count = " + result.getMatchedCount());
    }

    @Test
    public void testReplace(){
        Document filter = new Document();
        filter.append("name", "zhang");

        //注意：更新文档时，不需要使用"$set"
        Document replacement = new Document();
        replacement.append("value", 123);
        MongoDbApi.replace(filter, replacement);
    }

    @Test
    public void testDeleteOne(){
        Document filter = new Document();
        filter.append("name", "li");
        MongoDbApi.deleteOne(filter);
    }

    @Test
    public void testDeleteMany(){
        Document filter = new Document();
        filter.append("gender", "male");
        MongoDbApi.deleteMany(filter);
    }

}
