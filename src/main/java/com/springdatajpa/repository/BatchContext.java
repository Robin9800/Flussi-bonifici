package com.springdatajpa.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springdatajpa.model.RecordBonifici;

@Component
public class BatchContext {
    private List<RecordBonifici> recordList;

    public BatchContext() {
        this.recordList = new ArrayList<>();
    }

    public void addRecord(RecordBonifici record) {
        recordList.add(record);
    }

    public List<RecordBonifici> getRecordList() {
        return recordList;
    }
}
