package com.example.demo.todo.repository;

import com.example.demo.todo.entity.ToDo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.server.reactive.HttpHandlerDecoratorFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //스프링 컨테이너를 테스트 클래스에서 사용 가능
class TodoRepositoryMemoryImplTest {

    @Autowired
    TodoRepository repository;


    //단언 : 강력하게 주장한다


    @Test
    @DisplayName("1번 할 일을 삭제한 후 다시 조회했을 때 null이 나와야 한다.")
    void fidOneTest(){

        //given
        Long id = 1L;



        //When
        boolean flag = repository.remove(id);
        ToDo toDo = repository.findOne(id);



        //then
        assertTrue(flag);
        assertNull(toDo);
        assertEquals(2,repository.findAll().size());







    }

    @Test
    @DisplayName("2번 할 일을 삭제한 후 다시 조회했을 때 null이 나와야 한다.")
    void findOneTest(){

        //given
        Long id = 2L;

        //when
        boolean flag = repository.remove(id);
        ToDo toDo = repository.findOne(id);

        List(ToDo) toDoList = repository.findAll();

        //then
        assertTrue(flag);
        assertNull(toDo);
        assertEquals(2,repository.findAll().size());

    }


}