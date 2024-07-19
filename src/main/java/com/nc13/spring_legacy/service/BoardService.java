package com.nc13.spring_legacy.service;

import com.nc13.spring_legacy.model.BoardDTO;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {
    private final SqlSession SESSION;
    private final String NAMESPACE = "mappers.BoardMapper";

    public List<BoardDTO> selectAll(){
        return SESSION.selectList(NAMESPACE + ".selectAll");
    }

    public BoardDTO selectOne(int id) {return SESSION.selectOne(NAMESPACE + ".selectOne", id);}

    public void insert(BoardDTO boardDTO) { SESSION.insert(NAMESPACE + ".insert", boardDTO);
    }

    public void update(BoardDTO boardDTO) {
        SESSION.update(NAMESPACE + ".update", boardDTO);
    }

    public void delete(int id) {
        SESSION.delete(NAMESPACE + ".delete", id);
    }


}
