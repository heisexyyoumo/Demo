package com.interview.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class InterviewController {

    @Autowired
    private InterviewRepository repository;

    /*
        查询所有
     */
    @GetMapping("/interviews")
    public List<Interview> list(){
        return repository.findAll();
    }

    /*
        根据id查询
     */
    @GetMapping("/interviews/{id}")
    public Interview findById(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }


    /*
        增加
     */
    @PostMapping("/interviews")
    public Interview add(@RequestParam("name") String name,
                            @RequestParam("age") Integer age){
        Interview interview = new Interview();
        interview.setName("Tom");
        interview.setAge(19);
        return repository.save(interview);
    }

    /*
        更新
     */
    @PutMapping("/interviews/{id}")
    public Interview update(@PathVariable("id") Integer id,
                            @RequestParam("name") String name) {
        Interview interview = new Interview();
        interview.setId(id);
        interview.setName(name);
        return repository.save(interview);
    }

    /*
        删除
     */
    @PutMapping("/interviews/{id}")
    public void delete(@PathVariable("id") Integer id) {
        Interview interview = new Interview();
        interview.setId(id);
        repository.delete(interview);
    }
}
