package learnbyteaching.todos.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learnbyteaching.todos.repositories.dao.TodoRepository;
import learnbyteaching.todos.repositories.vo.TodoItem;

@RequestMapping("/api/todos")
@RestController
@CrossOrigin(origins = "*", 
	methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
	allowedHeaders= {"Content-Type", "Authorization"})
public class TodoApiController {
	@Autowired
	private TodoRepository todoRepository;
	
    // 모든 TODO 항목 조회
    @GetMapping
    public ResponseEntity<List<TodoItem>> getAllTodos() {
        List<TodoItem> todos = todoRepository.findAll();
        return ResponseEntity.ok(todos);
    }

    // 특정 TODO 항목 조회
    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getTodoById(@PathVariable("id") Long id) {
        Optional<TodoItem> todo = todoRepository.findById(id);
        return todo.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // TODO 항목 검색 (제목을 대상으로)
    @GetMapping("/search")
    public ResponseEntity<List<TodoItem>> searchTodos(@RequestParam("keyword") String keyword) {
        List<TodoItem> foundTodos = todoRepository.findAll().stream()
                                         .filter(todo -> todo.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                                         .collect(Collectors.toList());
        return ResponseEntity.ok(foundTodos);
    }

    // 새로운 TODO 항목 생성
    @PostMapping
    public ResponseEntity<TodoItem> createTodo(@RequestBody TodoItem todoItem) {
    	System.out.println("TodoItem:" + todoItem);
        TodoItem savedTodo = todoRepository.save(todoItem);
        return ResponseEntity.ok(savedTodo);  // ResponseEntity.created()를 사용하는 것이 나을지도 (201)
    }

    // 기존 TODO 항목 수정
    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateTodo(@PathVariable("id") Long id,
                                               @RequestBody TodoItem updatedTodo) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTitle(updatedTodo.getTitle());
                    todo.setCompleted(updatedTodo.isCompleted());
                    TodoItem savedTodo = todoRepository.save(todo);
                    return ResponseEntity.ok(savedTodo);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // TODO 항목 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        Optional<TodoItem> existingTodo = todoRepository.findById(id);
        if (!existingTodo.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        todoRepository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}
