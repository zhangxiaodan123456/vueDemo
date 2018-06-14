package com.example.demo.dao;

import java.util.List;

import com.example.demo.domain.Iplog;

public interface IplogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Iplog record);

    Iplog selectByPrimaryKey(Long id);

    List<Iplog> selectAll();

    int updateByPrimaryKey(Iplog record);
}