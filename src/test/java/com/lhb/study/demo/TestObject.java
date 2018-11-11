package com.lhb.study.demo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestObject {

    @Test
    public void testMap(){
        Map hashMap = new HashMap();
        hashMap.put("hashMap","hashMap");
        Map hashTable = new Hashtable();
        hashTable.put("hashTable","hashTable");
        assert "hashTable".equals(hashTable.get("hashTable"));
    }


}
