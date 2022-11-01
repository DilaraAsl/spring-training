package com.repository;

import com.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
