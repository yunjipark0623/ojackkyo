package com.example.ojackkyoserver.Controller;

import com.example.ojackkyoserver.Exceptions.MalFormedResourceException;
import com.example.ojackkyoserver.Exceptions.NoResourcePresentException;
import com.example.ojackkyoserver.Model.Comment;
import com.example.ojackkyoserver.Service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    CommentService commentService;

    @GetMapping(value = "/{id}")
    public Comment get(@PathVariable Integer id, HttpServletResponse res){
        try {
            return commentService.get(id);
        } catch (NoResourcePresentException e) {
            res.setStatus(404, e.getMessage());
            return null;
        }
    }

    @GetMapping(value = "/list/search")
    public Page<Comment> getList(@RequestParam(defaultValue = "") String authorsNickname,
                                 @RequestParam(defaultValue = "0") Integer articleId, Pageable pageable){
        System.out.println(authorsNickname);
        if(!authorsNickname.equals("")){
            return commentService.getListByAuthorNickname(authorsNickname, pageable);
        }else if(articleId != 0){
            return commentService.getListByArticleId(articleId, pageable);
        }else{
            return null;
        }
    }

    @PostMapping
    public Comment create(@RequestBody Comment comment, HttpServletResponse res){
        try {
            return commentService.create(comment);
        } catch (MalFormedResourceException e) {
            res.setStatus(400, e.getMessage());
            return null;
        } catch (NoResourcePresentException e) {
            res.setStatus(404, "댓글을 쓰고자 하는 게시글이 없습니다.");
            return null;
        }
    }

    @PutMapping
    public Comment update(@RequestBody Comment comment, HttpServletResponse res){
        try {
            return commentService.update(comment);
        } catch (NoResourcePresentException e) {
            res.setStatus(404, e.getMessage());
            return null;
        } catch (MalFormedResourceException e) {
            res.setStatus(400, e.getMessage());
            return null;
        }
    }

    @DeleteMapping(value ="/{id}")
    public void delete(@PathVariable Integer id, HttpServletResponse res){
        try {
            commentService.delete(id);
        } catch (NoResourcePresentException e) {
            res.setStatus(404, e.getMessage());
        }

    }
}
