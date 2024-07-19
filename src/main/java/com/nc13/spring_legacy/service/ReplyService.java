package com.nc13.spring_legacy.service;

import com.nc13.spring_legacy.model.ReplyDTO;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReplyService {
    private final SqlSession SESSION;
    private final String NAMESPACE = "mappers.ReplyMapper";

    public List<ReplyDTO> selectAll(int boardId) {
        return SESSION.selectList(NAMESPACE + ".selectAll", boardId);
    }
}
