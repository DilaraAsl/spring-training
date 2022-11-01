package com.proxy;

import com.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
