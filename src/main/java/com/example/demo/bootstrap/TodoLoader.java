package com.example.demo.bootstrap;


import com.example.demo.model.Todo;
import com.example.demo.model.TodoStatus;
import com.example.demo.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoLoader  implements CommandLineRunner {
    public final TodoRepository todoRepository;


    public TodoLoader(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadTodos();
    }

    private void loadTodos() {
        if (todoRepository.count() == 0) {
                    todoRepository.save(
                            Todo.builder()
                                    .title("Go to Market")
                                    .description("Buy eggs from market")
                                    .todoStatus(TodoStatus.NOT_COMPLTED)
                                    .build()
                    );
                    todoRepository.save(
                            Todo.builder()
                                    .title("go to school")
                                    .description("complete assigments")
                                    .todoStatus(TodoStatus.NOT_COMPLTED)
                                    .build()
                    );
                    System.out.println("Sample todos Loaded");
        }
    }
}
