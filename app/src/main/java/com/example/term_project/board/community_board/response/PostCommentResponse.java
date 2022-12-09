package com.example.term_project.board.community_board.response;

import androidx.annotation.Nullable;

import com.example.term_project.board.community_board.response.result.PostCommentResult;
import com.google.gson.annotations.SerializedName;

public class PostCommentResponse {
    @SerializedName(value = "isSuccess") private boolean isSuccess;
    @SerializedName(value = "code") private int code;
    @SerializedName(value = "message") private String message;

    @Nullable
    @SerializedName(value = "result")
    private PostCommentResult result;

    public PostCommentResponse(boolean isSuccess, int code, String message, @Nullable PostCommentResult result) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Nullable
    public PostCommentResult getResult() {
        return result;
    }

    public void setResult(@Nullable PostCommentResult result) {
        this.result = result;
    }
}
