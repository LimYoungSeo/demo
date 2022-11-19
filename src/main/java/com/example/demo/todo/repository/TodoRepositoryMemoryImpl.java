package com.example.demo.todo.repository;

//역할: 할 일 데이터를 메모리에 CRUD 하는 역할


import com.example.demo.todo.entity.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TodoRepositoryMemoryImpl implements  TodoRepository{


    // 메모리 저장소
    /**
     * key: 할 일의 식별 id 값
     * value: 할 일 집합 객체
     */
    private static final Map<Long, ToDo> toDoMap = new HashMap<>();

    static {


        toDoMap.put(1L, new ToDo(1L, "김철수", "저녁밥 만들기", false));
        toDoMap.put(1L, new ToDo(1L, "김철수", "산책 가기", true));
        toDoMap.put(1L, new ToDo(1L, "김철수", "노래 연습하기",false));

    }

    @Override
    public boolean save(ToDo todo) {

        if (todo ==null) return false;

        toDoMap.put(todo.getId(),todo);
        return false;
    }

    @Override
    public List<ToDo> findAll() {
        List<ToDo> toDoList= new ArrayList<>();

        for(Long id : toDoMap.keySet()){
            ToDo toDo = toDoMap.get(id);
            toDoList.add(toDo);
        }

        return toDoList;
    }

    @Override
    public ToDo findOne(long id) {
        return toDoMap.get(id);
    }

    @Override
    public boolean remove(long id) {
        ToDo todo=toDoMap.remove(id);
        return todo != null;

    }
}
